package mm.webclientservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mm.constants.Constants;
import mm.da.DataAccess;
import mm.model.AcademicInstitute;
import mm.model.User;

@WebServlet("/MenteeReports")
public class MenteeReports extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MenteeReports() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataAccess da = new DataAccess();
		String nextPage = request.getParameter("jsp");
		
		String address = request.getParameter("uAddress");
		String gender = request.getParameter("uGender");
		String academicInstitution = request.getParameter("uAcademicInstitution");
		Boolean inPair = Boolean.parseBoolean(request.getParameter("inPair"));
		String academicDicipline1 = request.getParameter("uAcademicDicipline1");
		String academicDicipline2 = request.getParameter("uAcademicDicipline2");
		ArrayList<User> allMentees=new ArrayList<User>();
		allMentees = da.getAllCorrespondingMentees(address, gender, academicInstitution, inPair,
				academicDicipline1, academicDicipline2);

		Gson gson = new Gson();
	   // System.out.println("USER with not json " +getUsers);
		String userResult = gson.toJson(allMentees, Constants.USER_CLASS);
		
	//    System.out.println("USer with JSON" + userResult);	    
    
	    PrintWriter writer = response.getWriter();
		writer.println(userResult);
		writer.close();
		
		
		RequestDispatcher req = request.getRequestDispatcher(nextPage);
		req.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
