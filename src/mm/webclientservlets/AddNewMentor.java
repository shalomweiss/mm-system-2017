//clicking on the Add button

package mm.webclientservlets;

import mm.constants.Constants;
import mm.da.*;
import mm.model.*;

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

	/**
	 * Default constructor.
	 * @return 
	 */
	public void AddMentorButton() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SaveMentor Servlet");





	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Add New MentorServlet");

		String email = request.getParameter("uEmail");
		String firstName = request.getParameter("uFirstName");
		String lastName = request.getParameter("uLastName");
		String phoneNumber = request.getParameter("uPhoneNumber");
		String workingPlace = request.getParameter("uWorkingPlace");
		String address = request.getParameter("uAddress");
		String notes = request.getParameter("uNotes");
		String experience = request.getParameter("uExperience");
		String volunteering = request.getParameter("uVolunteering");

        String jsp = request.getParameter("jsp");


		DataAccess da = new DataAccess();
		Mentor mentor = null;
		/*try {
			mentor = da.addMentor(email,firstName,lastName,phoneNumber,workingPlace,address,notes,experience,volunteering);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Gson gson = new Gson();
		String addedMentor = gson.toJson(mentor, Mentor.class);
	    PrintWriter writer = response.getWriter();
		writer.println(addedMentor);
		RequestDispatcher req = request.getRequestDispatcher(jsp);
		req.forward(request, response);
		writer.close();



	}
}
