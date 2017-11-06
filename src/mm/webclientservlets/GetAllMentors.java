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
import mm.model.Area;
import mm.model.City;
import mm.model.Mentor;
import mm.model.User;
import mm.model.User.userType;
import mm.model.WorkPlace;

/**
 * Servlet implementation class GetAllMentors
 */
@WebServlet("/GetAllMentors")
public class GetAllMentors extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllMentors() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET ALL MENTORS");
		ArrayList<User> ArrMentors = new ArrayList<User>();
		DataAccess da = new DataAccess();
		 try {
		 ArrMentors = da.getUsers(userType.MENTOR);
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		for(User mentor: ArrMentors){
			try {
				((Mentor)mentor).setCompanyName((da.getWorkPlaceById(((Mentor)mentor).getCompany()).getCompany()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		ArrayList<WorkPlace> allWorkingPlace =new ArrayList<WorkPlace>();
		 try {
			 allWorkingPlace = da.getAllWorkingPlace();
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
		request.setAttribute("Mentors", ArrMentors);
		request.setAttribute("NewWorkPlace", allWorkingPlace); 		
		PrintWriter writer = response.getWriter();
		writer.println(ArrMentors);
		RequestDispatcher req ;
		req = request.getRequestDispatcher("mentors.jsp");
		req.forward(request, response);
		writer.close();
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
