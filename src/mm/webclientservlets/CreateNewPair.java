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
import mm.model.Pair;

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
		int MentorId =Integer.parseInt( request.getParameter("mentorID"));
		int MenteeId =Integer.parseInt( request.getParameter("menteeID"));
		//String nextPage = request.getParameter("jsp");
		DataAccess da = new DataAccess();
		Pair p = null;
		RequestDispatcher req = null;
		 try {
		 p = da.addPair1(MentorId,MenteeId);
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		if (p==null) {
			response.getWriter().append("Success");
		}
		else
			response.getWriter().append("Failure");
		
		request.setAttribute("NewPair", p);	
		req.forward(request, response);

	}
}
