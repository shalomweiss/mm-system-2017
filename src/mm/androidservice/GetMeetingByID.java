package mm.androidservice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.constants.Constants;
import mm.da.DataAccess;
import mm.model.JsonMeeting;
import mm.model.Meeting;
import mm.model.User;
import util.ServerUtils;

/**
 * Servlet implementation class GetMeetingByID
 */
@WebServlet("/GetMeetingByID")
public class GetMeetingByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private class MeetingToGet{
		
		
		private int userId;
		private String token;
		private int meetingId;
		 
		public MeetingToGet(int id,String token,int meetingId) {
			// TODO Auto-generated constructor stub
			
			this.userId=id;
			this.token=token;
			this.meetingId=meetingId;
		}
		
		
		
		
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMeetingByID() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MeetingToGet myMeeting = ServerUtils.getJsonFromRequest(request, MeetingToGet.class);
		
		DataAccess da = new DataAccess();
		Meeting meetingFromDB = null;
//		try {
//			//meetingFromDB = da.getMeetingById(myMeeting.userId,myMeeting.token,myMeeting.meetingId);
//			 //user = new User(1,"testMan","ok","gmail.com","12345","abc","male","Antractica","good test",true,User.userType.MENTEE);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
		
		JsonMeeting jsonMeeting=null;
		if(meetingFromDB==null) {
			//TODO 
			jsonMeeting = new JsonMeeting(meetingFromDB, Constants.STATUS_MISSINGPARA, Constants.USERNOTFOUND, null);
		} 
		else {
			jsonMeeting = new JsonMeeting(meetingFromDB, Constants.STATUS_SUCCESS, Constants.SUCCESS, myMeeting.token);
		}
		
		
		ServerUtils.respondJsonObject(response,jsonMeeting);
		
	}

}
