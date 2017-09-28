package mm.webclientservlets;

import java.sql.SQLException;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mm.constants.Constants;
import mm.da.DataAccess;
import mm.model.Mentor;
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
		String NextPage = request.getParameter("jsp");

		ArrayList<User> ArrMentees = new ArrayList<User>();
	//	ArrMentees=getAllUsers();
		DataAccess da = new DataAccess();
//		 try {
//		 ArrMentees = da.getUsers(userType.MENTEE);
//		 } catch (SQLException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 }
		request.setAttribute("Mentees", ArrMentees);
		System.out.println("Mentees: " + ArrMentees);
		PrintWriter writer = response.getWriter();
		writer.println(ArrMentees);
		RequestDispatcher req = request.getRequestDispatcher(NextPage);
		req.forward(request, response);
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public List<User> getAllUsers() {

		List<User> getUsers = new ArrayList<User>();
		getUsers.add(new Mentee(0, null, "D", "fff", "fffe","rrr", 0, null, null, null, false, null, 0, null, null, 0, null, null, false, null, null));
		

		return getUsers;
	}
}
