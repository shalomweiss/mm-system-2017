
package mm.webclientservlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.da.DataAccess;
import mm.model.Meeting;
import mm.model.Pair;
import mm.model.PairDetails;

/**
 * Servlet implementation class GetPairById
 * Get Pair Object By sending Pais's ID 
 */
@WebServlet("/GetPairDetails")
public class GetPairDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPairDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("GetPairDetails Servlet");
		int pairId =Integer.parseInt( request.getParameter("pairId"));
        String nextPage = request.getParameter("jsp");
        DataAccess da = new DataAccess();
            Pair pair = null;
          try {
               pair = da.getPair(pairId);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
          ArrayList<Meeting> allMeetings = null;
          try {
            allMeetings= da.getMeetingsByPairId(pairId);
           } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
//          PairDetails pairDetails=new PairDetails();
//          pairDetails.setPair(pair);
//          pairDetails.setMeetings(allMeetings);
//          
    //    request.setAttribute("Pairs", pairDetails);	
        

        response.setContentType("text/html");
		RequestDispatcher req = request.getRequestDispatcher(nextPage);
		req.forward(request, response);	
	}

}
