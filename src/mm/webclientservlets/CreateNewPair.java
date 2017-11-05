package mm.webclientservlets;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.da.DataAccess;
import mm.model.User;

/**
 * Servlet implementation class CreateNewPair req: mentorId,menteeId-->
 * da.createPair(mentorId,menteeId)
 */
@WebServlet("/CreateNewPair")
public class CreateNewPair extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewPair() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CreateNewPair");
		int MentorId =Integer.parseInt( request.getParameter("mentorID"));
		int MenteeId =Integer.parseInt( request.getParameter("menteeID"));
		DataAccess da = new DataAccess();
		User mentor = null;
		try {
			mentor = da.getUser(MentorId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		User mentee = null;
		try {
			mentee = da.getUser(MenteeId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean res = false;
		System.out.println(MentorId +"  "+ MenteeId);
		 try {
		 res = da.addPair(MentorId,MenteeId);
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
			
		if (res) {
			response.getWriter().append("Success");
			String menteeFullName=mentee.getFirstName()+" "+mentee.getLastName();
			String mentorFullName=mentor.getFirstName()+" "+mentor.getLastName();
			String subject = "Welcome";
		    String body1 = "Hi "+ menteeFullName+
		    "\nThank you for using our mentorem program," +
		    "\nYour new mentor is "+mentorFullName+"."+
		    "\n\nYou can download the mentorem application from here:\n"+
		    "https://docs.google.com/document/u/0/"+
		    "\n\nHave a good day,\nTsofen team";
			SendingMail.sendFromGMail(mentee.getEmail(),subject,body1);
			
		    String body2 = "Hi "+ mentorFullName+
		    "\nThank you for using our mentorem program," +
		    "\nYour new mentee is "+menteeFullName+"."+
		    "\n\nYou can download the mentorem application from here:\n"+
		    "https://docs.google.com/document/u/0/"+
		    "\n\nHave a good day,\nTsofen team";
		    SendingMail.sendFromGMail(mentor.getEmail(),subject,body2);
			
		}
		else
			response.getWriter().append("Failure");
		
			
		

	}
}
