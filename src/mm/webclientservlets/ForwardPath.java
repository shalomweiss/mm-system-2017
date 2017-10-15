package mm.webclientservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardPath
 * 
 */
@WebServlet("/ForwardPath")
public class ForwardPath extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardPath() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String path = request.getParameter("jsp");
		 String switchPath="LogIn.jsp";
		/* switch(path) {
		 case ("welcome.jsp"): switchPath=path;
		 case (""):
		//this change is done by Daniel, sorry if I ruined something, trying to increase security 
		 }*/
		 RequestDispatcher req=request.getRequestDispatcher("Home.jsp");
		 req.forward(request, response);	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
