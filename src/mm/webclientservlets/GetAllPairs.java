package mm.webclientservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.da.DataAccess;
import mm.model.Mentee;
import mm.model.Mentor;
import mm.model.Pair;
import mm.model.PairsInfo;
import mm.model.User;

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

		// String NextPage = request.getParameter("jsp");
		ArrayList<Pair> pairsArray = new ArrayList<Pair>();
		ArrayList<PairsInfo> pairsMainInfo = new ArrayList<PairsInfo>();

		DataAccess da = new DataAccess();
		pairsArray = getAllPair();
		for (Pair pair : pairsArray) {
			if (pair.getActiveStatus() == 1) {
				PairsInfo tmpPairInfo = new PairsInfo(pair.getMentor().getFirstName(), pair.getMentee().getFirstName(),
						pair.getPairId(), pair.getActiveStatus());
				pairsMainInfo.add(tmpPairInfo);
			}
		}
		request.setAttribute("pairs", pairsMainInfo);
		System.out.println("Pairs: " + pairsMainInfo);
		PrintWriter writer = response.getWriter();
		// RequestDispatcher req = request.getRequestDispatcher(NextPage);
		// req.forward(request, response);
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	public ArrayList<Pair> getAllPair() {
		ArrayList<Pair> a = new ArrayList<Pair>();
		Mentee u = new Mentee();
		u.setFirstName("firdos");
		u.setLastName("F");
		u.setActive(true);
		u.setId(4444);
		Mentor men = new Mentor();
		men.setFirstName("MENTOR");
		men.setWorkHistory("MICROSOFT");
		men.setId(1111);
		Pair pair = new Pair(1111, 4444);
		pair.setMentor(men);
		pair.setMentee(u);
		pair.setActiveStatus(1);
		pair.setPairId(2);
		a.add(pair);
		return a;
	}

}
