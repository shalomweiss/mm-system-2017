

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


import mm.constants.Constants;
import mm.da.DataAccess;
import mm.model.Mentee;
import mm.model.User;
import mm.model.User.userType;

/**
 * Servlet implementation class EditMentorButton
 */
@WebServlet("/UpdateMentee")
public class UpdateMentee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateMentee() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UPDATE MENTEE DETAILDS");
		int id = Integer.parseInt(request.getParameter("uId"));
		String firstName = request.getParameter("uFirstName");
		String lastName = request.getParameter("uLastName");
		String phoneNum = request.getParameter("uPhoneNumber");
		String password = request.getParameter("uPassword");
		String profilePic = request.getParameter("uProfilePicture");
		String academicDicipline = request.getParameter("uAcademicDicipline2");
		String academicDicipline2 = request.getParameter("uAcademicDicipline2");
		String email = request.getParameter("uEmail");
		String resume = request.getParameter("uResume");
		String gradeSheet = request.getParameter("uGradeSheet");
		int gender = Integer.parseInt(request.getParameter("uGender"));
		String address = request.getParameter("uAddress");
		String graduationStatus = request.getParameter("uGraduationStatus");
		String academicInstitution = request.getParameter("uAcademicInstitution");
		float remSemesters = Float.parseFloat(request.getParameter("uRemSemesters"));
		float average = Float.parseFloat(request.getParameter("uAverage"));
		String notes = request.getParameter("uNotes");
		boolean isActive = Boolean.parseBoolean(request.getParameter("uActive"));
		boolean signedEULA = Boolean.parseBoolean(request.getParameter("signedEULA"));
    	String nextPage = request.getParameter("jsp");
		DataAccess da = new DataAccess();
		Boolean status = false;
		Mentee mentee = new Mentee(id,firstName,lastName,email,phoneNum,password,gender,address,profilePic,notes,isActive,userType.MENTEE,remSemesters,graduationStatus,academicInstitution,average,academicDicipline,academicDicipline2,signedEULA,resume,gradeSheet);
		System.out.println(mentee);
		try {
			status = da.editUser(mentee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("status", status);
		RequestDispatcher req = request.getRequestDispatcher(nextPage);
		req.forward(request, response);
*/
	}

}
