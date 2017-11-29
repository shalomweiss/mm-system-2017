package mm.webclientservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mm.da.DataAccess;
import mm.model.Mentee;
import mm.model.User;
import mm.model.User.userType;

import javax.servlet.RequestDispatcher;
import mm.constants.*;
@WebServlet("/MenteeReports")
public class MenteeReports extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MenteeReports() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("mentees reports");
		DataAccess da = null;
		try {
		da = new DataAccess();
		String address = request.getParameter("uAddress");
		String gender1 = request.getParameter("uGender");
		String academicInstitution1 = request.getParameter("uAcademicInstitution");
		String inPair1 = request.getParameter("inPair");
		String academicDicipline1 = request.getParameter("uAcademicDicipline1");
		ArrayList<User> allMentees=new ArrayList<User>();
		int  gender = Integer.parseInt(gender1);
		int academicInstitution=Integer.parseInt(academicInstitution1 );
		int inPair = Integer.parseInt(inPair1);
		try {
//			allMentees = da.getAllCorrespondingMentees(address, gender, academicInstitution, inPair,
//					academicDicipline1);
			allMentees=da.getUsers(userType.MENTEE);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
	    System.out.println("USER with not json " +allMentees);
		String menteeReports = gson.toJson(allMentees, Constants.MENTEE_Class);
		
	    System.out.println("USer with JSON" + menteeReports);	    
	    
	    response.setContentType("Content-Type: application/json");
	    PrintWriter writer = response.getWriter().append(menteeReports);
		writer.println();
		writer.close();
		}finally {
			try {
				if(da!=null)
				da.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
