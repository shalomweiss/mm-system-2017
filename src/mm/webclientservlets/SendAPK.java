package mm.webclientservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendAPK
 */
@WebServlet("/SendAPK")
public class SendAPK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendAPK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uFirstName = request.getParameter("uFirstName");
		String uLastName = request.getParameter("uLastName");
		String uEmail = request.getParameter("uEmail");
		String to = uEmail;
	    String subject = "Thank you for registering to Mentorem project";
	    String apk="https://goo.gl/dbYx8R";
	    String body = "Hi "+uFirstName+" "+uLastName+",\nWe appreciate your registeration for Mentorem project,\n" +"Download and Install the android client app \n "+ apk+"\n\nHave a good day,\nTsofen team";
		SendingMail.sendFromGMail(to,subject,body);
		response.getWriter().append("Success");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
