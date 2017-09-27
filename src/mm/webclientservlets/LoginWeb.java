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

import da.UserDA;

/**
 * Servlet implementation class LoginWeb
 */
@WebServlet("/LoginWeb")
public class LoginWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	/**
	 * Default constructor.
	 */
	public LoginWeb() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login Servlet");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Login Servlet");

		String email = request.getParameter("uName");
		String pass = request.getParameter("uPass");
		
		int isNotEntered = 0;
		DataAccess da = new DataAccess();
		//UserDA da = new UserDA();
		User temp = null;
		try {
			temp = da.login(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (temp == null) {
			request.setAttribute("isNotEntered", 1);
			RequestDispatcher req = request.getRequestDispatcher("LogIn.jsp");
			response.setContentType("text/html");
			req.include(request, response);
		} 
			if (temp.getPassword().matches(pass)){
			request.setAttribute("isNotEntered", 0);
			RequestDispatcher req = request.getRequestDispatcher("Welcome.jsp");
			response.setContentType("text/html");
			req.forward(request, response);
		}
	}
}
