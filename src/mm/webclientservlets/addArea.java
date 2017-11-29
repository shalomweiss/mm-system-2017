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

/**
 * Servlet implementation class addArea
 */
@WebServlet("/addArea")
public class addArea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addArea() {
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
			da = new DataAccess();
		String area=request.getParameter("area");
		
		
		RequestDispatcher req = null;
		 
		
		
	    boolean res=false;
	    
	 
			res = da.addArea(area);
		
	
		if(res){
			response.getWriter().append("Area added");
			req = request.getRequestDispatcher("");
		}
		if(!res)
			response.getWriter().append("Failed in added Area");	
		
		req.forward(request, response);
		} catch (SQLException e) {
			response.getWriter().append("Failed in added Area");	
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
