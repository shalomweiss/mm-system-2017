
package mm.webclientservlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.da.DataAccess;
import mm.model.Meeting;
import mm.model.MeetingHelp;
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
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		System.out.println("GetMeetingByPairId Servlet");
		int pairId =Integer.parseInt( request.getParameter("id"));
		DataAccess da = null;
		try {
		
		      da = new DataAccess();
			
            Pair pair = null;
          try {
               pair = da.getPair(pairId);
            } catch (SQLException e) {
               
                e.printStackTrace();
            }
          ArrayList<Meeting> allMeetings = new ArrayList<Meeting>();
          ArrayList<MeetingHelp> allMeetings1 = new ArrayList<MeetingHelp>();
          try {
            allMeetings= da.getMeetingsByPairId(pairId);       
           } catch (SQLException e) {
              
               e.printStackTrace();
           }
          PairDetails pairDetails=new PairDetails();
          pairDetails.setPair(pair);
          pairDetails.setMeetings(allMeetings);
               
          for (Meeting meeting : allMeetings) {
        	  Date meetingDate=new Date(meeting.getDate() * 1000);
        	 MeetingHelp p= new MeetingHelp( meeting.getMeetingId(),meeting.getPairId(), meeting.getMentorId(),meeting.getMenteeId(), meeting.getNote(), meeting.getStatus(),meeting.getMenteeReport(), meeting.getMentorReport(), meeting.getMenteePrivateReport(), meeting.getMentorPrivateReport(), meeting.getMeetingType(), meeting.getSubject(), meeting.getLocation(), meeting.getDate(), meeting.getStartingDate(), meeting.getEndingDate(), meeting.getMentorComplete(), meeting.getMenteeComplete(),meetingDate);
        	  allMeetings1.add(p);      	  
              
          }   
     
          
          request.setAttribute("Pairs", pairDetails);
          request.setAttribute("meetings", allMeetings1);
          RequestDispatcher req = null;
		  req=request.getRequestDispatcher("meetings.jsp");
	      req.forward(request, response);	
		}finally{
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
