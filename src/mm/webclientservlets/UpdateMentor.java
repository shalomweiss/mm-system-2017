package mm.webclientservlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mm.da.DataAccess;
import mm.model.Mentor;
import mm.model.User.userType;

/**
 * Servlet implementation class EditMentorButton
 */
@WebServlet("/UpdateMentor")
public class UpdateMentor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateMentor() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Update Mentor");
		int id = Integer.parseInt(request.getParameter("uId"));
		String email = request.getParameter("uEmail");
		String firstName = request.getParameter("uFirstName");
		String lastName = request.getParameter("uLastName");
		String address = request.getParameter("uAddress");
		String notes = request.getParameter("uNotes");
		String experience = request.getParameter("uExperience");
		String volunteering = request.getParameter("uVolunteering");
		String phoneNum = request.getParameter("uPhoneNumber");
		int gender = Integer.parseInt(request.getParameter("uGender"));
		String password = request.getParameter("uPassword");
		String profilePic = request.getParameter("uProfilePicture");
		boolean isActive = Boolean.parseBoolean(request.getParameter("uIsActive"));
		String role = request.getParameter("uRole");
		String uCompany=request.getParameter("uCompany");
		int company = Integer.parseInt(uCompany);
		String workHistory = request.getParameter("uWorkHistory");
		String cityId=request.getParameter("cityId");
		String areaId=request.getParameter("areaId");
		int uCity= Integer.parseInt(cityId);
		int uArea= Integer.parseInt(areaId);
		Boolean status = false;

		DataAccess da = new DataAccess();
        Mentor myMentor=new Mentor();
        try {
			myMentor = (Mentor) da.getUser(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        Mentor mentor = new Mentor(id,firstName, lastName, email, phoneNum, myMentor.getPassword(), gender, address, notes, myMentor.getProfilePicture(),
				isActive, userType.MENTOR,uArea,"",uCity,"",myMentor.getJoinDate(),"", experience, role, company, volunteering, workHistory);
		try {
			status = da.editUser(mentor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("status", status);
		RequestDispatcher req ;
		req=request.getRequestDispatcher("GetAllMentors");
		req.forward(request, response);

	}

}
