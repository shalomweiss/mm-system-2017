//clicking on the Add button

package mm.webclientservlets;

import mm.constants.Constants;
import mm.da.*;
import mm.model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/**
 * Servlet implementation class LoginWeb
 */

@WebServlet("/AddNewMentor")
public class AddNewMentor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void AddMentorButton() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMentor Servlet");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("Add New MentorServlet");
		String email = request.getParameter("uEmail");
		String firstName = request.getParameter("uFirstName");
		String lastName = request.getParameter("uLastName");
		String phoneNumber = request.getParameter("uPhoneNumber");
		String workingPlace = request.getParameter("uCompany");
		String address = request.getParameter("uAddress");
		String notes = request.getParameter("uNotes");
		String experience = request.getParameter("uExperience");
		String volunteering = request.getParameter("uVolunteering");
		int gender = Integer.parseInt(request.getParameter("uGender"));
		String nextPage = request.getParameter("jsp");
		int isActive = Integer.parseInt(request.getParameter("uActive"));
		/* TODO: ask about a profile picture?!!?!! */
		String workHistory = request.getParameter("uHistory");

		DataAccess da = new DataAccess();
	//	Mentor mentor = null;
		
		if (

				firstName != null && lastName != null && phoneNumber != null
						&& email != null && gender != null && address != null && 
						&& notes != null
						&& !firstName.trim().isEmpty() && !uLastName.trim().isEmpty()
						&& !uPhoneNumber.trim().isEmpty() && !uEmail.trim().isEmpty()
						&& !uGender.trim().isEmpty() && !uAddress.trim().isEmpty()
						&& !uGraduationStatus.trim().isEmpty()
						&& !uCourseOfStudy.trim().isEmpty()
						&& !uAcademicInstitution.trim().isEmpty()
						&& !uRemSemesters.trim().isEmpty()
						&& !uAverage.trim().isEmpty() && !uNotes.trim().isEmpty()
				){
		  try {
		  da.addMentor(email,firstName,lastName,phoneNumber,workingPlace,address
		  ,notes,experience,volunteering,gender,isActive,workHistory); } catch
		  (SQLException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }
		} 
		else{
			
		}
		request.setAttribute("Status", 200);
		RequestDispatcher req = request.getRequestDispatcher(nextPage);
		req.forward(request, response);
	}
}
