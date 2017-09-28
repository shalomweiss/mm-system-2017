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
		// System.out.println("Add New MentorServlet");
		String email = request.getParameter("uEmail");
		String firstName = request.getParameter("uFirstName");
		String lastName = request.getParameter("uLastName");
		String phoneNumber = request.getParameter("uPhoneNumber");
		String workingPlace = request.getParameter("uCompany");
		String address = request.getParameter("uAddress");
		String notes = request.getParameter("uNotes");
		String experience = request.getParameter("uExperience");
		String volunteering = request.getParameter("uVolunteering");
		String gender = request.getParameter("uGender");
		String nextPage = request.getParameter("jsp");
		String workHistory = request.getParameter("uHistory");
		String role=request.getParameter("uRole");
		int w=Integer.parseInt(workingPlace.toString());

		Mentor newMentor = new Mentor(firstName, lastName, email, phoneNumber,
				w, gender, address, notes, true, userType.MENTOR, experience,
				role, w, volunteering, workHistory);
		
		
		DataAccess da = new DataAccess();
	    boolean res=false;
	
//		try {
//			res = da.addUser(newMentor);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
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
