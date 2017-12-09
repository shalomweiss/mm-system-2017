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
import mm.model.User;

/**
 * Servlet implementation class GetMenteeById
 */
@WebServlet("/GetMenteeById")
public class GetMenteeById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMenteeById() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get MenteeById Servlet");
		int id =Integer.parseInt( request.getParameter("uId"));
        String jsp = request.getParameter("jsp");
        DataAccess da = null;
        try {
        da = new DataAccess();
            User mentee = null;
          try {
               mentee = da.getUser(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        	
      
  		
        request.setAttribute("MenteeById", mentee);	
        response.setContentType("text/html");
		RequestDispatcher req = request.getRequestDispatcher(jsp);
		req.forward(request, response);
		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
