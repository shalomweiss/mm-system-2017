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
		
		
		String Company=request.getParameter("company");
		String Area=request.getParameter("area");
		String City=request.getParameter("city");
		String Address=request.getParameter("address");
		RequestDispatcher req = null;
		 
		WorkPlace newWorkPlace= new WorkPlace(0,Company,Area,City,Address, 0, 0); //TODO: needs to be given proper city/area id
		
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


