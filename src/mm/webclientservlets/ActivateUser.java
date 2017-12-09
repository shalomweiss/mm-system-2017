package mm.webclientservlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.da.DataAccess;

/**
 * Servlet implementation class ActivateUser
 */
@WebServlet("/ActivateUser")
public class ActivateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataAccess da = null;
		try {
		String userId=request.getParameter("userId");
		int id=Integer.parseInt(userId);
		da =  new DataAccess();
	    boolean res=false;
	    response.setContentType("text/html");   

			res = da.activateUser(id);
		

		
		if(res)
			response.getWriter().append("Success");			
		else
			response.getWriter().append("Failure");	
		} catch (SQLException e) {
			response.getWriter().append("Failure");	
		}finally {
			try {
				if(da!=null)
				da.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}