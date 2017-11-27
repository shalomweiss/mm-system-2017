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
import mm.model.Mentee;
import mm.model.Mentor;
import mm.model.Pair;

/**
 * Servlet implementation class PairReport1
 */
@WebServlet("/PairReport1")
public class PairReport1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PairReport1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("REPORTS PAIRR");
		String number=request.getParameter("numOfDays");
		int numOfDays= Integer.parseInt(number);	
	//	System.out.println("REPORTS PAIRR"+numOfDays);

		ArrayList<Pair> pairsArray = new ArrayList<Pair>();
		ArrayList<Pair> sendingPairsArray = new ArrayList<Pair>();

		DataAccess da = new DataAccess();
		 try {
			 pairsArray = da.getAllPairs();
			 } catch (SQLException e) {
			
			 e.printStackTrace();
			 }
		 
		 
		 for (Pair pair : pairsArray) {		
					try {
						pair.setMentee(da.getUser(pair.getMenteeId()));
						pair.setMentor(da.getUser(pair.getMentorId()));
						((Mentee)pair.getMentee()).setAcademiclnstitutionName((da.getAcademicInstituteById(((Mentee)pair.getMentee()).getAcademiclnstitution()).getName()));
						((Mentor)pair.getMentor()).setCompanyName((da.getWorkPlaceById(((Mentor)pair.getMentor()).getCompany()).getCompany()));

						sendingPairsArray.add(pair);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
	 
	try {
		da.closeConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("PAIRSENDARRAY"+sendingPairsArray);
	request.setAttribute("pair1", sendingPairsArray);
	RequestDispatcher req = request.getRequestDispatcher("reports.jsp");
	req.forward(request, response);
		
	}

}
