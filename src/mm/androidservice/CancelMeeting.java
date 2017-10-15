package mm.androidservice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import mm.model.Meeting;
import mm.model.Meeting.meetingStatus;
import mm.model.User.userType;
import mm.model.User;
import util.ServerUtils;

/**
 * Servlet implementation class CancelMeeting
 */
@WebServlet("/CancelMeeting")
public class CancelMeeting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelMeeting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {AndroidIOManager iom = new AndroidIOManager(request,response);
	try {
		
	JsonObject jsonMeetingToApprove = iom.getJsonRequest();
	//int id,String token,String meeting_id,boolean action
	int id = jsonMeetingToApprove.get("id").getAsInt();
	String token = jsonMeetingToApprove.get("token").getAsString();
	String meetingId = jsonMeetingToApprove.get("meetingId").getAsString();		
	String message = jsonMeetingToApprove.get("message").getAsString();		
	boolean flag=true;
	

	if(ServerUtils.validateUserSession(id, token, iom.getDataAccess())){
		Meeting meeting=iom.getDataAccess().getMeetingById(Integer.parseInt(meetingId));
		User user=iom.getDataAccess().getUser(id);
		if(meeting.getStatus().equals(meetingStatus.PENDING)&&(!user.getType().equals(userType.MENTOR))) flag=false;
		if(meeting.getMenteeId()!=id && meeting.getMentorId()!=id)flag=false;
		if(meetingId!=null && (meeting.getStatus().equals(meetingStatus.APPROVED)||meeting.getStatus().equals(meetingStatus.PENDING))&& flag) {

			try {
				if(iom.getDataAccess().changeMeetingStatus(Integer.parseInt(meetingId),id, meetingStatus.CANCELED)){
					if(iom.getDataAccess().editMeetingNote(Integer.parseInt(meetingId),message))
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
	
				}else {
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
						
				}
			} catch (NumberFormatException | SQLException e) {
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
			}
			
						
		
		}else {
			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
		}
	}else {
		iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.INVALID_SESSION));

		
	}
	
	  }catch(NullPointerException ex){
             iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
     }catch(Exception e){
             iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.GENERAL_ERROR));
     }finally{
             iom.SendJsonResponse();
     }
	
}
}


