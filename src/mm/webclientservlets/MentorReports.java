package mm.webclientservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
		boolean flagAddress = false;
		boolean flagGender = false;
		boolean flagCompany = false;
		boolean flagPair = false;
		
		String address = null;
		int gender = -1;
		int company = -1;
		 int inPair = -1;
		
		
		
		if(request.getParameter("uAddress")==null) {
			flagAddress=true;
		}else {
			address=request.getParameter("uAddress");
		}
		if(request.getParameter("uGender")==null || request.getParameter("uGender").trim().isEmpty()) {
			flagGender=true;
		}else {
			System.out.println(request.getParameter("uGender"));
			 gender = Integer.parseInt(request.getParameter("uGender"));
		}
		if(request.getParameter("uCompany")==null) {
			flagCompany=true;
		}else {
			 company = Integer.parseInt(request.getParameter("uCompany"));
		}
		if(request.getParameter("inPair")==null) {
			flagPair=true;
		}else {
			  inPair = Integer.parseInt(request.getParameter("inPair"));
		}
		
		ArrayList<Mentor> allMentors=new ArrayList<Mentor>();
		try {
			allMentors = da.getAllCorrespondingMentors(address, gender, company, inPair);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
	    System.out.println("USER with not json " +allMentors);
		String mentorReports = gson.toJson(allMentors, Constants.MENTOR_Class);
		
	    System.out.println("USer with JSON" + allMentors);	    
	    
	    response.setContentType("Content-Type: application/json");
	    System.out.println("MentorsReports" + allMentors);
	    PrintWriter writer = response.getWriter().append(mentorReports);
		writer.println();
		writer.close();

		RequestDispatcher req=new RequestDispatcher() {
			
			@Override
			public void include(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void forward(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
				// TODO Auto-generated method stub
				
			}
		} ;
		req.forward(request, response);
		
		
		
		
	    	    


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
