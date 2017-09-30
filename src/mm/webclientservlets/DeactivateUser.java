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
 * Servlet implementation class DeactivUser
 * param: id
 * da.deactiveUser(userId)
 */
@WebServlet("/DeactivateUser")
public class DeactivateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeactivateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		String nextPage=request.getParameter("jsp");
		int id=Integer.parseInt(userId);
		DataAccess da = new DataAccess();
	    boolean res=false;
	    RequestDispatcher req = null;
	    response.setContentType("text/html");
	    
		try {
			res = da.deactivateUser(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res){
		req = request.getRequestDispatcher(nextPage);			
		}
		else
		response.getWriter().append("User is not deactivate-Failure");
		
		req.forward(request, response);	
	}
}
