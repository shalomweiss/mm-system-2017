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
import mm.model.Pair;
import mm.model.User;

@WebServlet("/PairReports")
public class PairReports extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PairReports() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataAccess da = new DataAccess();
		String nextPage = request.getParameter("jsp");
		
		String mentorName = request.getParameter("MentorName");
		String menteeName = request.getParameter("MenteeName");


		ArrayList<Pair> allPairs=new ArrayList<Pair>();
		allPairs = da.getAllCorrespondingPairs(mentorName,menteeName);

		Gson gson = new Gson();
	   // System.out.println("USER with not json " +getUsers);
		String userResult = gson.toJson(allPairs, Constants.USER_CLASS);
		
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
