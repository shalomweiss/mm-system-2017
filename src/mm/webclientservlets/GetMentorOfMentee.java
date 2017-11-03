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

@WebServlet("/GetMentorOfMentee")
public class GetMentorOfMentee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public GetMentorOfMentee() {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get Mentor Of Mentee");
		int menteeId =Integer.parseInt(request.getParameter("id"));
    
          DataAccess da = new DataAccess();
            Mentor mentor = new Mentor();
          try {
                mentor = da.getMentorOfMentee(menteeId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
          
        try {
			mentor.setCompanyName((da.getWorkPlaceById(mentor.getCompany())).getCompany());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("MentorByMenteeId", mentor);	
        response.setContentType("text/html");
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}
}
