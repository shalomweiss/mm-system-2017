//// why is company of type int???
/// Casting 

package mm.webclientservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
 * Servlet implementation class EditMentorButton
 */
@WebServlet("/UpdateMentor")
public class UpdateMentor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateMentor() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("uId"));
		String email = request.getParameter("uEmail");
		String firstName = request.getParameter("uFirstName");
		String lastName = request.getParameter("uLastName");
		String workingPlace = request.getParameter("uWorkingPlace");
		String address = request.getParameter("uAddress");
		String notes = request.getParameter("uNotes");
		String experience = request.getParameter("uExperience");
		String volunteering = request.getParameter("uVolunteering");
		String phoneNum = request.getParameter("uPhoneNumber");
		int gender = Integer.parseInt(request.getParameter("uGender"));
		String password = request.getParameter("uPassword");
		String profilePic = request.getParameter("uProfilePicture");
		boolean isActive = Boolean.parseBoolean(request.getParameter("uIsActive"));
		String role = request.getParameter("uRole");
		int company = Integer.parseInt(request.getParameter("uCompany"));
		String workHistory = request.getParameter("uWorkHistory");
		DataAccess da = new DataAccess();
		Boolean status = false;
		Mentor mentor = new Mentor(id,firstName, lastName, email, phoneNum, password, gender, address, notes, profilePic,
				isActive, userType.MENTOR, experience, role, company, volunteering, workHistory);
		User u = (User) mentor;
		try {
			status = da.editUser(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("status", status);
		RequestDispatcher req ;
		System.out.println("UUUUUUUUUPDATE");
		req=request.getRequestDispatcher("GetAllMentors");
		req.forward(request, response);

	}

}
