package mm.androidservice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import mm.constants.Constants;
import mm.da.DataAccess;
import mm.model.JsonMeeting;
import mm.model.Meeting;
import mm.model.Session;
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
		
		JsonObject myJson = ServerUtils.getJsonObjcetFromRequest(request);
		//int id,String token,int meetingId
		int id = myJson.get("id").getAsInt();
		String token = myJson.get("token").getAsString();
		String meetingId = myJson.get("meetingId").getAsString();
		
		DataAccess da = new DataAccess();
		Meeting meetingFromDB = null;
		try {
			//meetingFromDB = da.insert(id,token,meetingId);
			 //user = new User(1,"testMan","ok","gmail.com","12345","abc","male","Antractica","good test",true,User.userType.MENTEE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		JsonMeeting jsonMeeting=null;
		if(meetingFromDB==null) {
			//TODO 
			//jsonMap.put(key, value)
		
			jsonMeeting = new JsonMeeting(meetingFromDB, Constants.STATUS_MISSINGPARA, Constants.USERNOTFOUND, null);
		} 
		else {
			jsonMeeting = new JsonMeeting(meetingFromDB, Constants.STATUS_SUCCESS, Constants.SUCCESS, token);
		}
		
		
		ServerUtils.respondJsonObject(response,jsonMeeting);
		
	}

}
