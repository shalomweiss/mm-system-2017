package mm.webclientservlets;

import mm.da.*;
import mm.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		String name = request.getParameter("uName");
		String pass = request.getParameter("uPass");
		String type = "1"; // tsofen team is 1
		int isNotEntered = 0;
		DataAccess da = new DataAccess();
		User temp = null;
		try {
			temp = da.login(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (temp.getFirstName().isEmpty() || pass.isEmpty()) {
			request.setAttribute("isNotEntered", 1);
			RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
			req.include(request, response);
		} else {
			request.setAttribute("isNotEntered", 0);
			RequestDispatcher req = request.getRequestDispatcher("Welcome.jsp");
			req.forward(request, response);
		}
	}
}
