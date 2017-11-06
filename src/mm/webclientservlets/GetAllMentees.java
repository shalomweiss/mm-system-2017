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
import mm.model.Area;
import mm.model.City;
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
			try {
				((Mentee)mentee).setAcademiclnstitutionName((da.getAcademicInstituteById(((Mentee)mentee).getAcademiclnstitution()).getName()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		 }
		
		ArrayList<AcademicInstitute> AcadimicIn =new ArrayList<AcademicInstitute>();
		 try {
			 AcadimicIn = da.getAllAcademiclnstitution();
			 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			ArrayList<City> cities =new ArrayList<City>();
			ArrayList<Area> areas =new ArrayList<Area>();

		 try {
			 cities = da.getAllCities();
			 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
		 try {
			 areas = da.getAllAreas();
			 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }


			try {
				da.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		request.setAttribute("areas", areas);
		request.setAttribute("cities", cities);
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