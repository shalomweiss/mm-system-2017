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
import mm.model.WorkPlace;

/**
 * Servlet implementation class AddWorkingPlace
 */
@WebServlet("/AddWorkingPlace")
public class AddWorkingPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWorkingPlace() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String company=request.getParameter("company");
		String city=request.getParameter("cityId");
		String area=request.getParameter("areaId");	
		String address=request.getParameter("address");
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
		
		 
		WorkPlace newWorkPlace= new WorkPlace(0,company,"","",address, areaId, cityId); //TODO: needs to be given proper city/area id
		
		DataAccess da = new DataAccess();
	    boolean res=false;

		try {
			res = da.addWorkPlace(newWorkPlace);
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
			response.getWriter().append("Working Place Is Added");
		}
		if(!res)
			response.getWriter().append("Failed in added Work Place");	
		
		req.forward(request, response);
	}	
	}


