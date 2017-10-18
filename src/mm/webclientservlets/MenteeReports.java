package mm.webclientservlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mm.da.DataAccess;
import mm.model.Mentee;
import javax.servlet.RequestDispatcher;
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
		String gender1 = request.getParameter("uGender");
		String academicInstitution1 = request.getParameter("uAcademicInstitution");
		String inPair1 = request.getParameter("inPair");
		String academicDicipline1 = request.getParameter("uAcademicDicipline1");
		ArrayList<Mentee> allMentees=new ArrayList<Mentee>();
		int  gender = Integer.parseInt(gender1);
		int academicInstitution=Integer.parseInt(academicInstitution1 );
		int inPair = Integer.parseInt(inPair1);
		try {
			allMentees = da.getAllCorrespondingMentees(address, gender, academicInstitution, inPair,
					academicDicipline1);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	  
		request.setAttribute("menteeReports",allMentees );
		
		System.out.println("MenteeReports: "+allMentees);
		RequestDispatcher req = request.getRequestDispatcher("");
		req.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
