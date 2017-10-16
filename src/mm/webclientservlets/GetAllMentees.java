package mm.webclientservlets;

import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
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

		request.setAttribute("Mentees", ArrMentees);
		ArrayList<AcademicInstitute> AcadimicIn =new ArrayList<AcademicInstitute>();
		 try {
			 AcadimicIn = da.getAllAcademiclnstitution();
			 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			ArrayList<String> AcadimicIn1 =new ArrayList<String>();

	//	AcadimicIn = getAllAcademiclnstitution();
		 AcadimicIn1.add("ss");
		 AcadimicIn1.add("DDDDDDDD");
		request.setAttribute("AcadimicIn", AcadimicIn); 
		System.out.println("AcadimicInnn "+ AcadimicIn1);
	
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

	public ArrayList<User> getAllUsers() {

		ArrayList<User> getUsers = new ArrayList<User>();
		Mentee m=new Mentee();
		m.setFirstName("hseen");
		m.setLastName("SSSS");
		getUsers.add(m);
		return getUsers;
	}
	public ArrayList<AcademicInstitute> getAllAcademiclnstitution(){
		ArrayList<AcademicInstitute> arr=new ArrayList<AcademicInstitute>();
		AcademicInstitute a=new AcademicInstitute(0, "University Of Haifa", "nesher", "Haifa");
		AcademicInstitute a1=new AcademicInstitute(0, "technion", "Haifa", "Haifa");

		arr.add(a);
		arr.add(a1);
	    return arr;
	}
}
