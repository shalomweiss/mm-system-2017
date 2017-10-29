package mm.webclientservlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.da.DataAccess;
import mm.model.Pair;
import mm.model.PairsInfo;


/**
 * Servlet implementation class GetAllPairs return from db ArrayList<Pair>: Pair
 * Contructor is: public Pair(int pairId, Mentor mentor, Mentee mentee, int
 * activeStatuse, Date startDate, Date endDate, String joinMessage, String
 * tsofenMessage)
 * 
 * check if activestatuse==1? send to client else remove this pair
 */
@WebServlet("/GetAllPairs")
public class GetAllPairs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllPairs() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Get AllPairs Servlet");

		ArrayList<Pair> pairsArray = new ArrayList<Pair>();
		//Daniel did this change because I need more info that the pair model has
		//ArrayList<PairsInfo> pairsMainInfo = new ArrayList<PairsInfo>();
		//added by Daniel
		ArrayList<Pair> activePairsArray= new ArrayList<Pair>();
		DataAccess da = new DataAccess();
		 try {
			 pairsArray = da.getAllPairs();
			 } catch (SQLException e) {
			
			 e.printStackTrace();
			 }
		
		for (Pair pair : pairsArray) {
			if (pair.getActiveStatus() == 1) {
				try {
					pair.setMentee(da.getUser(pair.getMenteeId()));
					pair.setMentor(da.getUser(pair.getMentorId()));
					
					activePairsArray.add(pair);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Daniel did this change because I need more info that the pair model has
				/*PairsInfo tmpPairInfo = new PairsInfo(pair.getMentee().getFirstName(), pair.getMentor().getFirstName(),
						pair.getPairId(), pair.getActiveStatus());
				pairsMainInfo.add(tmpPairInfo);*/
				
			}
		}
		//changed by Daniel
		request.setAttribute("pairs", activePairsArray);
		response.setContentType("text/html");
	    RequestDispatcher req = request.getRequestDispatcher("mainPair.jsp");
	    req.forward(request, response);
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}

