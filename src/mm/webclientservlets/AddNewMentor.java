//clicking on the Add button

package mm.webclientservlets;

import mm.da.*;
import mm.model.*;
import mm.model.User.userType;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.GeneratePass;

/**
 * Servlet implementation class LoginWeb
 */

@WebServlet("/AddNewMentor")
public class AddNewMentor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void AddMentorButton() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AddMentor Servlet");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Add New MentorServlet");
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String notes = request.getParameter("notes");
		String experience = request.getParameter("experience");
		String volunteering = request.getParameter("volunteering");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String nextPage = request.getParameter("jsp");
		String workHistory = request.getParameter("history");
		String role = request.getParameter("role");
		String pass = GeneratePass.getSaltString();
		String ProfilePicture = request.getParameter("profilePicture");
		String cityId=request.getParameter("cityId");
		String areaId=request.getParameter("areaId");	
		String comp=request.getParameter("company");
		int uCity;
		int uArea;
		int company;
		System.out.println("company: "+comp+"city "+cityId +"area: "+ areaId);
		
		if(cityId.equals(null) ||cityId.equals(""))
			uCity=0;
		else
			uCity= Integer.parseInt(cityId);
	
		if(areaId.equals(null) ||areaId.equals(""))
		   uArea=0;
		else
		  uArea= Integer.parseInt(areaId);
		if(comp.equals(null) ||comp.equals(""))
			company=0;
		else
		    company = Integer.parseInt(comp);

		
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);
		
		User newMentor = new Mentor(0, firstName, lastName, email, phoneNumber, pass, gender, address, notes,
				ProfilePicture, true, userType.MENTOR,uArea,"",uCity,"",date,"", experience, role, company, volunteering, workHistory);
		DataAccess da = new DataAccess();
		int res = -1;
		RequestDispatcher req = null;

		try {		
			res = da.addUser(newMentor);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (res>0) {
			response.getWriter().append("Mentor Added");
			req = request.getRequestDispatcher(nextPage);
			String to = email;
			String subject = "Thank you for registering to Mentorem project";
			String apk="https://goo.gl/dbYx8R";
		    String body = "Hi "+firstName+" "+lastName+",\nWe appreciate your registeration for Mentorem project,\n" +"Here is your login username and passwod: \n\nUsername: "+email+"\nPassword: " +pass+"\nDownload and Install the android client app  \n "+ apk+"\n\nHave a good day,\nTsofen team";
			
		    
		    SendingMail.sendFromGMail(to,subject,body);

		}
		try {
			da.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (res==-1)
		response.getWriter().append("Failed in added Mentor");
	
		
		newMentor.setId(res);	
		request.setAttribute("NewMentor", newMentor);
		req=request.getRequestDispatcher("GetAllMentors");
		req.forward(request, response);
	}
}