package mm.webclientservlets;

import java.sql.SQLException;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.da.DataAccess;
import mm.model.AcademicInstitute;
import mm.model.Mentee;
import mm.model.User;
import mm.model.User.userType;

/**
 * Servlet implementation class GetAllMentors
 */
@WebServlet("/GetAllMentees")
public class GetAllMentees extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllMentees() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,

		HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> ArrMentees = new ArrayList<User>();
	    
		DataAccess da = new DataAccess();
		 try {
		 ArrMentees = da.getUsers(userType.MENTEE);
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
        
		 for(User mentee: ArrMentees){
			((Mentee)mentee).setAcademiclnstitutionName((da.getAcadimicInsById(((Mentee)mentee).getAcademiclnstitution())));			
		 }
		
		ArrayList<AcademicInstitute> AcadimicIn =new ArrayList<AcademicInstitute>();
		 try {
			 AcadimicIn = da.getAllAcademiclnstitution();
			 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
		
//			ArrayList<Address> Address =new ArrayList<Address>();
//			 try {
//				 Address = da.getAllAddress();
//				 } catch (SQLException e) {
//				 // TODO Auto-generated catch block
//				 e.printStackTrace();
//				 }
//		 
//		 
//	    request.setAttribute("AddressList", Address);
		request.setAttribute("Mentees", ArrMentees);
		request.setAttribute("AcadimicIn", AcadimicIn); 
	
		RequestDispatcher req = request.getRequestDispatcher("mentees.jsp");
		req.forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	}