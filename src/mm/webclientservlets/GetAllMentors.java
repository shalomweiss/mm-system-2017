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
import mm.model.User;
import mm.model.User.userType;

/**
 * Servlet implementation class GetAllMentors
 */
@WebServlet("/GetAllMentors")
public class GetAllMentors extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllMentors() {
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
		List<Mentor> ArrMentors = new ArrayList<Mentor>();
		DataAccess da = new DataAccess();
		 /*try {
		 ArrMentors = da.getUsers(userType.MENTOR);
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }*/
		request.setAttribute("Mentors", ArrMentors);
		System.out.println("MENTORS: " + ArrMentors);
		PrintWriter writer = response.getWriter();
		writer.println(ArrMentors);
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

	public List<Mentor> getAllUsers() {

		List<Mentor> getUsers = new ArrayList<Mentor>();
		getUsers.add(new Mentor("firdos", "bobo"));
		getUsers.add(new Mentor("dunia", "abo"));
		getUsers.add(new Mentor("yara", "roh"));
		getUsers.add(new Mentor("ghada", "aaa"));

		return getUsers;
	}

}
