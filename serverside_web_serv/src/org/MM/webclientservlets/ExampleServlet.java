package org.MM.webclientservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import org.MM.model.User;
import org.MM.constants.*;

/**
 * Servlet implementation class ExampleServlet
 */
@WebServlet("/ExampleServlet")
public class ExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ExampleSErvletToGET");
		
		Collection <User> getUsers = new ArrayList<User>();
		
		
		
		//to test
	    getUsers.add(new User("firdos","bobo"));
	    
		getUsers.add(new User("dunia","abo"));
		getUsers.add(new User("yara","roh"));
		getUsers.add(new User("ghada","aaa"));
		
				
		Gson gson = new Gson();
	    System.out.println("USER with not json " +getUsers);
		String userResult = gson.toJson(getUsers, Constants.USER_CLASS);
		
	    System.out.println("USer with JSON" + userResult);	    
	    
	    PrintWriter writer = response.getWriter();
		writer.println(userResult);
		writer.close();
		
		RequestDispatcher req = request.getRequestDispatcher("Welcome.jsp");
		req.forward(request, response);
	
	}
}
