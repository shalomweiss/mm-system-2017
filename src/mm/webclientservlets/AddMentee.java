package mm.webclientservlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.GeneratePass;
import mm.da.DataAccess;
import mm.model.Mentee;
import mm.model.User;
import mm.model.User.userType;
//import mm.webclientservlets.SendingMail;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("here to stay");
	//	String nextPage=request.getParameter("jsp");
    	String uFirstName = request.getParameter("uFirstName");
		String uLastName = request.getParameter("uLastName");
		String uPhoneNumber = request.getParameter("uPhoneNumber");
		String uEmail = request.getParameter("uEmail");
		int uGender = Integer.parseInt(request.getParameter("uGender"));
		String uAddress = request.getParameter("uAddress");
		String uGraduationStatus = request.getParameter("uGraduationStatus");
		String uCourseOfStudy = request.getParameter("uCourseOfStudy");
		//int uAcademicInstitution = Integer.parseInt(request.getParameter("uAcademicInstitution"));
		String uRemSemesters = request.getParameter("uRemSemesters");
		String uAverage = request.getParameter("uAverage");
		String uNotes = request.getParameter("uNotes");
		String academicDicipline =request.getParameter("uAcademicDicipline");
		String academicDicipline2=request.getParameter("uAcademicDicipline2");
	//	String isGraduate=request.getParameter("uIsGraduate");
	//	String resume=request.getParameter("uResume");
	//	String gradeSheet=request.getParameter("uGradeSheet");
	//	String profilePicture=request.getParameter("profilePicture");
		String isGraduate=null;
		String resume=null;
		String gradeSheet=null;
		String profilePicture=null;
		int uAcademicInstitution=1;
		float remSemesters=Float.valueOf(uRemSemesters);
		float avg=Float.valueOf(uAverage);
		
		boolean isGradute=Boolean.parseBoolean(isGraduate);
		String uPass= GeneratePass.getSaltString();	 
		User newMentee=new Mentee(0,uFirstName,uLastName,uEmail,uPhoneNumber,uPass,uGender,uAddress,profilePicture,uNotes,true,userType.MENTEE,remSemesters,uGraduationStatus,uAcademicInstitution, avg,academicDicipline,academicDicipline2,isGradute,resume,gradeSheet );
		System.out.println("here to stay111");
		
		DataAccess da = new DataAccess();
		RequestDispatcher req=null;
	    boolean res=true;
	
		try {
			res = da.addUser(newMentee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res){
			request.setAttribute("AddedSuc", 1);
			 String subject = "Java send mail example";
		        String body = "Welcome to JavaMail!   ";
		        String[] to = { "2131995m@gmail.com" };
	//		SendingMail.sendFromGMail("Mail.test135791","mailtest",to,subject,body);
			System.out.println("USER IS ADDED SUCSSESS");
		}
		if (!res){
			request.setAttribute("AddedSuc", 0);
			response.getWriter().append("Failed to add a mentee");
		}
		request.setAttribute("NewMentee", newMentee);
		req=request.getRequestDispatcher("GetAllMentees");
		req.forward(request, response);
	}
}