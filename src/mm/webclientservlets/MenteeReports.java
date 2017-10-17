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
import mm.model.Mentee;
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
		String address = request.getParameter("uAddress");
		int  gender = Integer.parseInt(request.getParameter("uGender"));
		int academicInstitution = Integer.parseInt(request.getParameter("uAcademicInstitution"));
		int inPair = Integer.parseInt(request.getParameter("inPair"));
		String academicDicipline1 = request.getParameter("uAcademicDicipline1");
		ArrayList<Mentee> allMentees=new ArrayList<Mentee>();
		try {
			allMentees = da.getAllCorrespondingMentees(address, gender, academicInstitution, inPair,
					academicDicipline1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   // System.out.println("USER with not json " +getUsers);
		Gson gson = new Gson();
		String userResult = gson.toJson(allMentees, Constants.USER_CLASS);
		
	//    System.out.println("USer with JSON" + userResult);	    
    
	    PrintWriter writer = response.getWriter();
		writer.println(userResult);
		writer.close();
		
		
	//	RequestDispatcher req = request.getRequestDispatcher(nextPage);
	//	req.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
