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
 * Servlet implementation class addCity
 */
@WebServlet("/addCity")
public class addCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		DataAccess da = null;
		try {
			 da =  new DataAccess();
		String city=request.getParameter("city");
		
		
		RequestDispatcher req = null;
		 
		
	    boolean res=false;
	    
	    

			res = da.addCity(city);
		

		
		if(res){
			response.getWriter().append("City Added");
			req = request.getRequestDispatcher("");
		}
		if(!res)
			response.getWriter().append("Failed in added City");	
		
		req.forward(request, response);
	
		} catch (SQLException e) {
			response.getWriter().append("Failed in added City");
			e.printStackTrace();
		}finally {
			try {
				if(da!=null)
				da.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
