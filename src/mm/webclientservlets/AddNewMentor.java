//clicking on the Add button

package mm.webclientservlets;

import mm.constants.Constants;
import mm.da.*;
import mm.model.*;
import mm.model.User.userType;

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

import util.GeneratePass;

import com.google.gson.Gson;

/**
 * Servlet implementation class LoginWeb
 */

@WebServlet("/AddNewMentor")
public class AddNewMentor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void AddMentorButton() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMentor Servlet");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("Add New MentorServlet");
		GeneratePass genPass=new GeneratePass();
	//	String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		String workingPlace = request.getParameter("company");
		String address = request.getParameter("address");
		String notes = request.getParameter("notes");
		String experience = request.getParameter("experience");
		String volunteering = request.getParameter("volunteering");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String nextPage = request.getParameter("jsp");
		String workHistory = request.getParameter("history");
		String role=request.getParameter("role");
		int company = Integer.parseInt(request.getParameter("company"));
		String pass= genPass.getSaltString();
		String ProfilePicture=request.getParameter("profilePicture");


		User newMentor=new Mentor(firstName,lastName,email,phoneNumber,pass, gender,address,notes,ProfilePicture,true,userType.MENTOR, experience,role,company,volunteering,workHistory);

	
		
		
		DataAccess da = new DataAccess();
	    boolean res=false;
	
//		try {
//			res = da.addUser(newMentor)
//		} catch (SQLException e) {
////			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if(res){
			request.setAttribute("Status", 200);
		}
		if(!res)
		request.setAttribute("Status", 400);
		
		RequestDispatcher req = request.getRequestDispatcher(nextPage);
		req.forward(request, response);
	}
}
