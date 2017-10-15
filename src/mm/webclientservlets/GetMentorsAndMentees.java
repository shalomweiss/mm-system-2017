package mm.webclientservlets;

import java.io.IOException;
import java.io.PrintWriter;
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
import mm.model.User;
import mm.model.User.userType;

/**
 * Servlet implementation class GetMentorsAndMentees
 * return all mentees and mentors;
 */
@WebServlet("/GetMentorsAndMentees")
public class GetMentorsAndMentees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMentorsAndMentees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	String NextPage = request.getParameter("jsp");
		ArrayList<User> ArrMentors = new ArrayList<User>();
		DataAccess da = new DataAccess();
		 try {
		 ArrMentors = da.getUsers(userType.MENTOR);
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		
		request.setAttribute("Mentors", ArrMentors);
		System.out.println("MENTORS: " + ArrMentors);
		PrintWriter writer = response.getWriter();
		writer.println(ArrMentors);
		
		ArrayList<Mentee> arrMentees = new ArrayList<Mentee>();
		 try {
		// ArrMentees = da.getUsers(userType.MENTEE);
			 arrMentees = da.getAllMenteesWithoutMentor();
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		
		request.setAttribute("Mentees", arrMentees);
		response.setContentType("text/html");
	
		RequestDispatcher req = request.getRequestDispatcher("addPair.jsp");
		req.forward(request, response);
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
