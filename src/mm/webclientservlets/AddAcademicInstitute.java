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
import mm.model.AcademicInstitute;

/**
 * Servlet implementation class AddAcademinInstitute
 */
@WebServlet("/AddAcademicInstitute")
public class AddAcademicInstitute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAcademicInstitute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String Area=request.getParameter("area");
		String City=request.getParameter("city");
	
		
		RequestDispatcher req = null;
		 
		AcademicInstitute acadimicIn= new AcademicInstitute(0,name,Area,City, 0, 0); //TODO: set proper area/city id
		
		DataAccess da = new DataAccess();
	    boolean res=false;
	    
	    
		try {
			res = da.addAcademicInstitute(acadimicIn);
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
		
		if(res){
			response.getWriter().append("AcadimicInstitute Added");
			req = request.getRequestDispatcher("");
		}
		if(!res)
			response.getWriter().append("Failed in added Work Place");	
		
		req.forward(request, response);
	
	}

}
