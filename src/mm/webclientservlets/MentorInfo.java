
///clicking on some Mentor





package mm.webclientservlets;

import mm.constants.Constants;
import mm.da.*;
import mm.model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


/**
 * Servlet implementation class LoginWeb
 */

@WebServlet("/MentorInfo")
public class MentorInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MentorInfo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Mentor1 Servlet");


        String name = request.getParameter("uName");
		String id = request.getParameter("uId");
		
        String jsp = request.getParameter("jsp");


            String type = "2"; //user type is Mentor(2)
            DataAccess da = new DataAccess();
            Mentor mentor = null;
            try {
                mentor = da.getMentor(name,id,type);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            Gson gson = new Gson();
	  //  System.out.println("USER with not json " +Mentors);
		String MentorResult = gson.toJson(mentor, Constants.MENTOR_CLASS);

	   // System.out.println("USer with JSON" + userResult);

	    PrintWriter writer = response.getWriter();
		writer.println(MentorResult);
		writer.close();

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
}
