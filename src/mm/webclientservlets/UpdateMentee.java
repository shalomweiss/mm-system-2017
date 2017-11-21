

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
		System.out.println("academicDicipline "+academicDicipline);
		String academicDicipline2 = request.getParameter("uAcademicDicipline2").replaceAll("\\s+","");		
		String email = request.getParameter("uEmail");
		int gender = Integer.parseInt(request.getParameter("uGender"));
		String address = request.getParameter("uAddress");
		String graduationStatus = request.getParameter("uGraduationStatus");		
		float remSemesters = Float.parseFloat(request.getParameter("uRemSemesters"));
		float average = Float.parseFloat(request.getParameter("uAverage"));
		String notes = request.getParameter("uNotes");
		DataAccess da = new DataAccess();
		Boolean status = false;
		int academicInstitution = Integer.parseInt(request.getParameter("uAcademicInstitution"));
		String cityId=request.getParameter("cityId");
		String areaId=request.getParameter("areaId");		
		int uCity= Integer.parseInt(cityId);
		int uArea= Integer.parseInt(areaId);
		boolean isActive =true;
		boolean signedEULA = true;     
		long millis=System.currentTimeMillis();  
        Date date=new Date(millis);
        Mentee myUser=new Mentee();
		try {
			myUser = (Mentee) da.getUser(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Mentee mentee = new Mentee(id,firstName,lastName,email,phoneNum,myUser.getPassword(),gender,address,myUser.getProfilePicture(),notes,isActive,userType.MENTEE,uArea,"",uCity,"",myUser.getJoinDate(),"",remSemesters,graduationStatus,academicInstitution,average,academicDicipline,academicDicipline2,signedEULA,myUser.getResume(),myUser.getGradeSheet());
	    System.out.println(""+mentee+"/n number of string:  "+mentee.getAcademicDicipline2().length());
	    System.out.println("String Lenghth: "+mentee.getAcademicDicipline2().length());

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
