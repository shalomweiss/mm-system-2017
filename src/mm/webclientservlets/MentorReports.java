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
		String nextPage = request.getParameter("jsp");
		
		String address = request.getParameter("uAddress");
		int gender = Integer.parseInt(request.getParameter("uGender"));
		int company = Integer.parseInt(request.getParameter("uCompany"));
		Boolean inPair = Boolean.parseBoolean(request.getParameter("inPair"));
		int intInPair = -1;
		if(inPair != null){
			intInPair = 0;
			if(inPair == true){
				intInPair = 1;
			}
		}
		ArrayList<Mentor> allMentors=new ArrayList<Mentor>();
		try {
			allMentors = da.getAllCorrespondingMentors(address, gender, company, intInPair);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();
	   // System.out.println("USER with not json " +getUsers);
		String userResult = gson.toJson(allMentors, Constants.USER_CLASS);
		
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
