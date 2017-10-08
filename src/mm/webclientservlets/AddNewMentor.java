//clicking on the Add button

package mm.webclientservlets;

import mm.da.*;
import mm.model.*;
import mm.model.User.userType;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.GeneratePass;

/**
 * Servlet implementation class LoginWeb
 */

@WebServlet("/AddNewMentor")
public class AddNewMentor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void AddMentorButton() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AddMentor Servlet");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Add New MentorServlet");
		GeneratePass genPass = new GeneratePass();
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		String workingPlace = request.getParameter("company");
		String address = request.getParameter("address");
		String notes = request.getParameter("notes");
		String experience = request.getParameter("experience");
		String volunteering = request.getParameter("volunteering");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String nextPage = request.getParameter("jsp");
		String workHistory = request.getParameter("history");
		String role = request.getParameter("role");
		int company = Integer.parseInt(request.getParameter("company"));
		String pass = GeneratePass.getSaltString();
		String ProfilePicture = request.getParameter("profilePicture");
		User newMentor = new Mentor(0, firstName, lastName, email, phoneNumber, pass, gender, address, notes,
				ProfilePicture, true, userType.MENTOR, experience, role, company, volunteering, workHistory);
		DataAccess da = new DataAccess();
		boolean res = false;
		RequestDispatcher req = null;

		try {
			
			res = da.addUser(newMentor);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (res) {
			response.getWriter().append("Mentor Added");
			req = request.getRequestDispatcher(nextPage);
		}
		if (!res)
			response.getWriter().append("Failed in added Mentor");
		request.setAttribute("NewMentor", newMentor);
		req.forward(request, response);
	}
}
