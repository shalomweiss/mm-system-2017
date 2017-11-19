package mm.webclientservlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.model.AcademicInstitute;
import mm.model.Area;
import mm.model.City;
import mm.da.DataAccess;
import mm.model.Mentee;
import mm.model.User;
import mm.model.WorkPlace;
import mm.model.User.userType;
/**
 * Servlet implementation class AddingDataServlet
 */
@WebServlet("/AddingDataServlet")
public class AddingDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddingDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataAccess da = new DataAccess();
		ArrayList<AcademicInstitute> AcadimicIn =new ArrayList<AcademicInstitute>();
		 try {
			 AcadimicIn = da.getAllAcademiclnstitution();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
			ArrayList<City> cities =new ArrayList<City>();
			ArrayList<Area> areas =new ArrayList<Area>();
			ArrayList<WorkPlace> allWorkingPlace =new ArrayList<WorkPlace>();
		 try {
			 allWorkingPlace = da.getAllWorkingPlace();
			 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
		 try {
			 cities = da.getAllCities();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 try {
			 areas = da.getAllAreas();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }

		 
			try {
				da.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("workplaces", allWorkingPlace);
			request.setAttribute("areas", areas);
			request.setAttribute("cities", cities);
			request.setAttribute("AcadimicIn", AcadimicIn); 
		RequestDispatcher req = request.getRequestDispatcher("addCityWorkPlaceOrAcademy.jsp");
		req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
