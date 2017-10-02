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
		int MentorId =Integer.parseInt( request.getParameter("mentorId"));
		int MenteeId =Integer.parseInt( request.getParameter("menteeId"));
		String nextPage = request.getParameter("jsp");
		DataAccess da = new DataAccess();
		boolean res = false;
		RequestDispatcher req = null;
		 try {
		 res = da.addPair(MentorId,MenteeId);
		 } catch (SQLException e) {
		// // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		if (res) {
		 req = request.getRequestDispatcher(nextPage);
			
		}
		else
			response.getWriter().append("Failure");
			
		req.forward(request, response);

	}
}
