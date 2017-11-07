package mm.webclientservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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

		System.out.println("ADD MENTEE");
    	String uFirstName = request.getParameter("uFirstName");
		String uLastName = request.getParameter("uLastName");
		String uPhoneNumber = request.getParameter("uPhoneNumber");
		String uEmail = request.getParameter("uEmail");
		String gender=request.getParameter("uGender");
		String uAddress = request.getParameter("uAddress");
		String uGraduationStatus = request.getParameter("uGraduationStatus");
		String uAcademicIn=request.getParameter("uAcademicInstitution");
		String uRemSemesters = request.getParameter("uRemSemesters");
		String uAverage = request.getParameter("uAverage");
		String uNotes = request.getParameter("uNotes");
		String academicDicipline =request.getParameter("uAcademicDicipline");
		String academicDicipline2=request.getParameter("uAcademicDicipline2");
		String Signed=request.getParameter("uSignedEULA");
		String resume=request.getParameter("uResume");
		String gradeSheet=request.getParameter("uGradeSheet");
		String profilePicture=request.getParameter("profilePicture");
		String cityId=request.getParameter("cityId");
		String areaId=request.getParameter("areaId");
		int uGender= Integer.parseInt(gender);
		Float avg= null;
		Float remSemesters= null;
		int uCity=0;
		int uArea=0;
		int uAcademicInstitution= 0;
		boolean SignedEULA=false;
		System.out.println("ACADEMIC "+uAcademicIn+"city "+cityId +"area: "+ areaId);

		if(uAverage.equals(null) ||uAverage.equals("")){
			avg=(float) 0;
		}
		else
		{	
			avg = Float.valueOf(uAverage);
			System.out.println("AVGG" + avg);
			}
	    
		if(uRemSemesters.equals(null) ||uRemSemesters.equals(""))
		remSemesters=(float) 0;
		else
		remSemesters= Float.valueOf(uRemSemesters);
		
		if(cityId.equals(null) ||cityId.equals(""))
			uCity=0;
		else
			uCity= Integer.parseInt(cityId);

		
		if(areaId.equals(null) ||areaId.equals(""))
		   uArea=0;
		else
		  uArea= Integer.parseInt(areaId);
		
		
		if(uAcademicIn.equals(null) ||uAcademicIn.equals(""))
			uAcademicInstitution=0;
		else
			uAcademicInstitution= Integer.parseInt(uAcademicIn);
		
		if(Signed.equals(null) ||Signed.equals(""))
			 SignedEULA=false;
		else
			SignedEULA=Boolean.parseBoolean(Signed);
        
		String uPass= GeneratePass.getSaltString();	
        long millis=System.currentTimeMillis();  
        Date date=new Date(millis);
		User newMentee=new Mentee(0,uFirstName,uLastName,uEmail,uPhoneNumber,uPass,uGender,uAddress,profilePicture,uNotes,true,userType.MENTEE,uArea,"",uCity,"",date,remSemesters,uGraduationStatus,uAcademicInstitution, avg,academicDicipline,academicDicipline2,SignedEULA,resume,gradeSheet );
		
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
				String to = uEmail;
			    String subject = "Thank you for registering to Mentorem project";
			    String apk="https://goo.gl/dbYx8R";
			    String body = "Hi "+uFirstName+" "+uLastName+",\nWe appreciate your registeration for Mentorem project,\n" +"Here is your login username and passwod: \n\nUsername: "+uEmail+"\nPassword: " +uPass+"\nDownload and Install the android client app \n "+ apk+"\n\nHave a good day,\nTsofen team";
				SendingMail.sendFromGMail(to,subject,body);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				da.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("AddedSuc", 1);
		}
		if (resId==-1){
			request.setAttribute("AddedSuc", 0);
			response.getWriter().append("Failed to add a mentee");
		}
		req=request.getRequestDispatcher("GetAllMentees");
		req.forward(request, response);
	}
}