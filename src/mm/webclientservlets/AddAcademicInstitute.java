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
		DataAccess da = null;
		try {
			da = new DataAccess();
		String name=request.getParameter("name");
		String city=request.getParameter("cityId");
		String area=request.getParameter("areaId");	
		int cityId,areaId=0;
		if(city.equals(null) ||city.equals(""))
			cityId=0;
		else
			cityId= Integer.parseInt(city);
	
		if(area.equals(null) ||area.equals(""))
		   areaId=0;
		else
		  areaId= Integer.parseInt(area);
		
	
		
		RequestDispatcher req = null;
		 
		AcademicInstitute acadimicIn= new AcademicInstitute(0,name,"","", areaId, cityId); //TODO: set proper area/city id
		

	    boolean res=false;
	    
	    

			res = da.addAcademicInstitute(acadimicIn);
		 
		
		
		if(res){
			response.getWriter().append("AcadimicInstitute Added");
			req = request.getRequestDispatcher("");
		}
		if(!res)
			response.getWriter().append("Failed in added Work Place");	
		
		req.forward(request, response);
		} catch (SQLException e) {
			response.getWriter().append("Failed in added Work Place");	
			e.printStackTrace();
		}
		finally {
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
