
package mm.webclientservlets;
import mm.da.*;
import mm.model.*;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetMentorById
 * 
 */

@WebServlet("/GetMentorById")
public class GetMentorById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public GetMentorById() {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get MentorById Servlet");
		int id =Integer.parseInt( request.getParameter("uId"));
        String jsp = request.getParameter("jsp");
          DataAccess da = new DataAccess();
            User mentor = null;
          try {
                mentor = da.getUser(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
          try {
  			da.closeConnection();
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		
        request.setAttribute("MentorById", mentor);	
        response.setContentType("text/html");
		RequestDispatcher req = request.getRequestDispatcher(jsp);
		req.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}
