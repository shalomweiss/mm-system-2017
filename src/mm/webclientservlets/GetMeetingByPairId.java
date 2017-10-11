
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
@WebServlet("/GetMeetingByPairId")
public class GetMeetingByPairId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMeetingByPairId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Meeting Servlet");
		int pairId =Integer.parseInt( request.getParameter("id"));
		
		
		
		
        DataAccess da = new DataAccess();
            Pair pair = null;
          try {
               pair = da.getPair(pairId);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
          ArrayList<Meeting> allMeetings = new ArrayList<Meeting>();
          try {
            allMeetings= da.getMeetingsByPairId(pairId);
            System.out.println(pairId+"Meetings"+allMeetings);
           } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
          System.out.println("Meetings"+allMeetings);
        //  allMeetings=getAllMeeting();
          PairDetails pairDetails=new PairDetails();
          pairDetails.setPair(pair);
          pairDetails.setMeetings(allMeetings);
          System.out.println("Meetings"+allMeetings);
          request.setAttribute("Pairs", pairDetails);
          request.setAttribute("meetings", allMeetings);	
          RequestDispatcher req = null;
		  req=request.getRequestDispatcher("meetings.jsp");
	    	req.forward(request, response);	
	}
	
	public ArrayList<Meeting> getAllMeeting(){
		ArrayList<Meeting> arr=new ArrayList<Meeting>();
		Meeting m=new Meeting(0, 0, 0, 0, "String",null,null,null,null,null,null,null, null, null, null, null, false, false);
		m.setLocation("LOCATION");
		
		
		m.setMenteePrivateReport("REPORTING");
		m.setMenteeReport("PPPPP");
		
		arr.add(m);
		return arr;
	}

}
