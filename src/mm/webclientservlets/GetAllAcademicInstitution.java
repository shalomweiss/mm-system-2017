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
import mm.model.Mentee;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//String NextPage = request.getParameter("jsp");
		DataAccess da = new DataAccess();
		ArrayList<AcademicInstitute> allAcademicInstitutes = new ArrayList<AcademicInstitute>();
		try {
			allAcademicInstitutes = da.getAllAcademiclnstitution();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("AllAcademicInstitutes", allAcademicInstitutes);
		System.out.println("ACADEMIC"+allAcademicInstitutes);
		//RequestDispatcher req = request.getRequestDispatcher(NextPage);
		//req.forward(request, response);
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
