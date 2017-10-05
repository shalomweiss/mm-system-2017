package mm.webclientservlets;

import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class GetAllMentors
 */
@WebServlet("/GetAllMentees")
public class GetAllMentees extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllMentees() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,

		HttpServletResponse response) throws ServletException, IOException {
	//	String NextPage = request.getParameter("jsp");
		ArrayList<User> ArrMentees = new ArrayList<User>();
	//	ArrMentees=getAllUsers();
		DataAccess da = new DataAccess();
		 try {
		 ArrMentees = da.getUsers(userType.MENTEE);
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
//		ArrMentees=getAllUsers();
		request.setAttribute("Mentees", ArrMentees);
		//TODO : getAllAcadimicIns;
	//	request.setAttribute("AcadimicIn", AcadimicIn); 
		List<Integer> l2 =new ArrayList<Integer>();
		l2.add(1);
		l2.add(2);
		l2.add(3);
		
		request.setAttribute("AcadimicIn",l2);
		System.out.println("Mentees: " + ArrMentees);
	
		RequestDispatcher req = request.getRequestDispatcher("mentees.jsp");
		req.forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

	public ArrayList<User> getAllUsers() {

		ArrayList<User> getUsers = new ArrayList<User>();
		Mentee m=new Mentee();
		m.setFirstName("hseen");
		m.setLastName("SSSS");
		getUsers.add(m);
		
		
        
		return getUsers;
	}
}
