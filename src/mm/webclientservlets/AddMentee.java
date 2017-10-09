package mm.webclientservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import com.google.gson.Gson;

import util.GeneratePass;
import mm.constants.Constants;
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

		System.out.println("here to stay");
    	String uFirstName = request.getParameter("uFirstName");
		String uLastName = request.getParameter("uLastName");
		String uPhoneNumber = request.getParameter("uPhoneNumber");
		String uEmail = request.getParameter("uEmail");
		String gender=request.getParameter("uGender");
		String uAddress = request.getParameter("uAddress");
		String uGraduationStatus = request.getParameter("uGraduationStatus");
		Float avg= null;
		if(!request.getParameter("uAverage").isEmpty()){
			avg=Float.valueOf(request.getParameter("uAverage"));
		}
        //int uAcademicInstitution = Integer.parseInt(request.getParameter("uAcademicInstitution"));
		String uRemSemesters = request.getParameter("uRemSemesters");
		//String uAverage = request.getParameter("uAverage");
		String uNotes = request.getParameter("uNotes");
		String academicDicipline =request.getParameter("uAcademicDicipline");
		String academicDicipline2=request.getParameter("uAcademicDicipline2");
		boolean SignedEULA=Boolean.parseBoolean(request.getParameter("uSignedEULA"));
		String resume=request.getParameter("uResume");
		String gradeSheet=request.getParameter("uGradeSheet");
		String profilePicture=request.getParameter("profilePicture");
		int uAcademicInstitution = 1;
		Float remSemesters= null;
		
		int uGender=1;
		if(!gender.isEmpty()){
			uGender = Integer.parseInt(gender);
		}
		if(!uRemSemesters.isEmpty()){
		remSemesters=Float.valueOf(uRemSemesters);
		}
//		if(!uAverage.isEmpty()){
//		avg=Float.valueOf(uAverage);
//		}
		
		String uPass= GeneratePass.getSaltString();	 
		System.out.println("AVERAGE: "+avg);
		User newMentee=new Mentee(0,uFirstName,uLastName,uEmail,uPhoneNumber,uPass,uGender,uAddress,profilePicture,uNotes,true,userType.MENTEE,remSemesters,uGraduationStatus,uAcademicInstitution, avg,academicDicipline,academicDicipline2,SignedEULA,resume,gradeSheet );
		System.out.println("here to stay111");
		
		
		User user=new User();
		DataAccess da = new DataAccess();
		RequestDispatcher req=null;
	    int resId=-1;
	
		try {
			resId = da.addUser(newMentee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(resId>0){
			try {
				user=da.getUser(resId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			request.setAttribute("AddedSuc", 1);
		    String subject = "Java send mail example";
		    String body = "Welcome to JavaMail!   ";
		    String[] to = { "2131995m@gmail.com" };
	//		SendingMail.sendFromGMail("Mail.test135791","mailtest",to,subject,body);
		    Gson gson=new Gson();
		
		    System.out.println("USER with not json " +user);
			String userResult = gson.toJson(user,Constants.USER_CLASS);
			
		    System.out.println("USer with JSON" + userResult);	    
		    response.setContentType("application/json");
		    PrintWriter writer = response.getWriter();
			writer.println(userResult);
			writer.close();  
			System.out.println("USER IS ADDED SUCSSESS");
		}}
		if (resId==-1){
			request.setAttribute("AddedSuc", 0);
			response.getWriter().append("Failed to add a mentee");
		}
		req=request.getRequestDispatcher("GetAllMentees");
		req.forward(request, response);
	}
}