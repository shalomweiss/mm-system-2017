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
@WebServlet("/GetAllMenteess")
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

		List<Mentee> ArrMentees = new ArrayList<Mentee>();
		DataAccess da = new DataAccess();
		// try {
		// ArrMentors = da.getAllMentees();
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
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

	public List<Mentee> getAllUsers() {

		List<Mentee> getUsers = new ArrayList<Mentee>();
		getUsers.add(new Mentee("firdos", "bobo"));
		getUsers.add(new Mentee("dunia", "abo"));
		getUsers.add(new Mentee("yara", "roh"));
		getUsers.add(new Mentee("ghada", "aaa"));

		return getUsers;
	}

}
