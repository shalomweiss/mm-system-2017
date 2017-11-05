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
import mm.da.DataAccess;
import mm.model.AcademicInstitute;
import mm.model.Meeting.meetingType;
import mm.model.WorkPlace;

/**
 * Servlet implementation class GetAllAcademicInstitution
 */
@WebServlet("/GetAllAcademicInstitution")
public class GetAllAcademicInstitution extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllAcademicInstitution() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataAccess da = new DataAccess();		
		
		ArrayList<meetingType> meetingTypes=new ArrayList<meetingType>();
		meetingTypes.add(meetingType.FACE_TO_FACE);
		meetingTypes.add(meetingType.PHONE);
		meetingTypes.add(meetingType.SMS);

		

		ArrayList<AcademicInstitute> allAcademicInstitutes = new ArrayList<AcademicInstitute>();
		try {
			allAcademicInstitutes = da.getAllAcademiclnstitution();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<WorkPlace> workPlaces = new ArrayList<WorkPlace>();
		
		try {
			workPlaces = da.getAllWorkingPlace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		try {
			da.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("AllAcademicInstitutes", allAcademicInstitutes);
		request.setAttribute("AllWorkPlaces", workPlaces);
		request.setAttribute("meetingType", meetingTypes);
		System.out.println("ACADEMIC"+allAcademicInstitutes);
		RequestDispatcher req = request.getRequestDispatcher("reports.jsp");
		req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
