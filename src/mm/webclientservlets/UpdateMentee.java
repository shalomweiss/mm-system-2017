

package mm.webclientservlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.da.DataAccess;
import mm.model.Mentee;
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
		System.out.println("UPDATE MENTEE DETAILDS");
		int id = Integer.parseInt(request.getParameter("uId"));
		String firstName = request.getParameter("uFirstName");
		String lastName = request.getParameter("uLastName");
		String phoneNum = request.getParameter("uPhoneNumber");
		String academicDicipline = request.getParameter("uAcademicDicipline");
		String academicDicipline2 = request.getParameter("uAcademicDicipline2");
		String email = request.getParameter("uEmail");
	//	String resume = request.getParameter("uResume");
	//	String gradeSheet = request.getParameter("uGradeSheet");
		int gender = Integer.parseInt(request.getParameter("uGender"));
		String address = request.getParameter("uAddress");
		String graduationStatus = request.getParameter("uGraduationStatus");
		
		float remSemesters = Float.parseFloat(request.getParameter("uRemSemesters"));
		float average = Float.parseFloat(request.getParameter("uAverage"));
		String notes = request.getParameter("uNotes");
	//	boolean isActive = Boolean.parseBoolean(request.getParameter("uActive"));
	//	boolean signedEULA = Boolean.parseBoolean(request.getParameter("signedEULA"));
		DataAccess da = new DataAccess();
		Boolean status = false;
		int academicInstitution = Integer.parseInt(request.getParameter("uAcademicInstitution"));
		///////////////////////daniel change please note
		String cityId="1";//request.getParameter("cityId");
		String areaId="1";//request.getParameter("areaId");		
		int uCity= Integer.parseInt(cityId);
		int uArea= Integer.parseInt(areaId);
		
		String password = null; // DB ignore it
		String profilePic =null;
		String resume = null;
		String gradeSheet =null;
		boolean isActive =true;
		boolean signedEULA = true;     
		long millis=System.currentTimeMillis();  
        Date date=new Date(millis);
		

		Mentee mentee = new Mentee(id,firstName,lastName,email,phoneNum,password,gender,address,profilePic,notes,isActive,userType.MENTEE,uArea,"",uCity,"",date ,remSemesters,graduationStatus,academicInstitution,average,academicDicipline,academicDicipline2,signedEULA,resume,gradeSheet);
		try {
			status = da.editUser(mentee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			da.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("status", status);
	    RequestDispatcher req;
		req=request.getRequestDispatcher("GetAllMentees");
		req.forward(request, response);
	}

}
