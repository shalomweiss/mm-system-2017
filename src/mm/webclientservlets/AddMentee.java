package mm.webclientservlets;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.constants.Constants;
import mm.da.DataAccess;

/**
 * Servlet implementation class AddMentee
 */
@WebServlet("/AddMentee")
public class AddMentee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMentee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ")
				.append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String uFirstName = request.getParameter("uFirstName");
		String uLastName = request.getParameter("uLastName");
		String uPhoneNumber = request.getParameter("uPhoneNumber");
		String uEmail = request.getParameter("uEmail");
		String uGender = request.getParameter("uGender");
		String uAddress = request.getParameter("uAddress");
		String uGraduationStatus = request.getParameter("uGraduationStatus");
		String uCourseOfStudy = request.getParameter("uCourseOfStudy");
		String uAcademicInstitution = request
				.getParameter("uAcademicInstitution");
		String uRemSemesters = request.getParameter("uRemSemesters");
		String uAverage = request.getParameter("uAverage");
		String uNotes = request.getParameter("uNotes");

		DataAccess myDa = new DataAccess();
		if (

		uFirstName != null && uLastName != null && uPhoneNumber != null
				&& uEmail != null && uGender != null && uAddress != null
				&& uGraduationStatus != null && uCourseOfStudy != null
				&& uAcademicInstitution != null && uRemSemesters != null
				&& uAverage != null && uNotes != null
				&& !uFirstName.trim().isEmpty() && !uLastName.trim().isEmpty()
				&& !uPhoneNumber.trim().isEmpty() && !uEmail.trim().isEmpty()
				&& !uGender.trim().isEmpty() && !uAddress.trim().isEmpty()
				&& !uGraduationStatus.trim().isEmpty()
				&& !uCourseOfStudy.trim().isEmpty()
				&& !uAcademicInstitution.trim().isEmpty()
				&& !uRemSemesters.trim().isEmpty()
				&& !uAverage.trim().isEmpty() && !uNotes.trim().isEmpty()
		) {
			myDa.addMentee(uFirstName.trim(), uLastName.trim(),
					uPhoneNumber.trim(), uEmail.trim(), uGender.trim(),
					uAddress.trim(), uGraduationStatus.trim(),
					uCourseOfStudy.trim(), uAcademicInstitution.trim(),
					uRemSemesters.trim(), uAverage.trim());
		} else {
			// get status 402
		}

	}

}
