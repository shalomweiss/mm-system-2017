package mm.webclientservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.da.DataAccess;
import mm.model.Mentee;
import mm.model.Mentor;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("GetMenteeById");
		String id = request.getParameter("uId");
        String jsp = request.getParameter("jsp");
          DataAccess da = new DataAccess();
            Mentee mentee = null;
//          try {
//               mentee = da.getUser(id);
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
        	
      	
        request.setAttribute("MenteeById", mentee);	
        	
	    PrintWriter writer = response.getWriter();
		writer.println(mentee);
		RequestDispatcher req = request.getRequestDispatcher(jsp);
		req.forward(request, response);
		writer.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
