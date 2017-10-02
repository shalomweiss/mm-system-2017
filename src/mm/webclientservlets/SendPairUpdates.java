package mm.webclientservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.da.DataAccess;
import mm.model.Pair;

/**
 * Servlet implementation class SentPairUpdates
 */
@WebServlet("/SentPairUpdates")
public class SendPairUpdates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendPairUpdates() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("GetPairDetails Servlet");
		String nextPage = request.getParameter("jsp");
		int pairId = Integer.parseInt(request.getParameter("pairId"));
		String apk=request.getParameter("APK");
		String note=request.getParameter("note");
		
		DataAccess da = new DataAccess();
		String updates  = da.getUpdates(pairId);
		request.setAttribute("Updates", updates);
	}
	

}
