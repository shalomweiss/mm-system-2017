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
import mm.model.Mentor;
import mm.model.User;

@WebServlet("/MentorReports")
public class MentorReports extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MentorReports() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataAccess da = new DataAccess();
		
		String address = request.getParameter("uAddress");
		String gender1 = request.getParameter("uGender");
		String company1 = request.getParameter("uCompany");
		 String inPair1 = request.getParameter("inPair");
		 System.out.println(inPair1);
		int gender=Integer.parseInt(gender1);
		int company=Integer.parseInt(company1);
		int inPair=Integer.parseInt(inPair1);
		
		ArrayList<Mentor> allMentors=new ArrayList<Mentor>();
		try {
			allMentors = da.getAllCorrespondingMentors(address, gender, company, inPair);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(""+address+"  "+gender+"kk "+company+" "+inPair);
	    System.out.println("MentorsReports" + allMentors);	    
		request.setAttribute("mentorReports", allMentors);

		RequestDispatcher req = request.getRequestDispatcher("");
		req.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
