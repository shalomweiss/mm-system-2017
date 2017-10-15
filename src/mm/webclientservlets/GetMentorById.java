
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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetMentorById Servlet");
		int id =Integer.parseInt( request.getParameter("uId"));
        String jsp = request.getParameter("jsp");
          DataAccess da = new DataAccess();
            User mentor = null;
          try {
                mentor = da.getUser(id);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        request.setAttribute("MentorById", mentor);	
        System.out.println(mentor);
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
		// TODO Auto-generated method stub
		System.out.println("Mentor Servlet");
	}
	
	public Mentor getMentorById(){
		Mentor m=new Mentor("shushu","CC","DEV");
		return m;
	}
}
