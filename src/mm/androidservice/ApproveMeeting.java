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
import util.ServerUtils;

/**
 * Servlet implementation class ApproveMeeting
 */
@WebServlet("/ApproveMeeting")
public class ApproveMeeting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveMeeting() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AndroidIOManager iom = new AndroidIOManager(request,response);
		try {
		
		JsonObject jsonMeetingToApprove = iom.getJsonRequest();
		//int id,String token,String meeting_id,boolean action
		int id = jsonMeetingToApprove.get("id").getAsInt();
		String token = jsonMeetingToApprove.get("token").getAsString();
		int meetingId = jsonMeetingToApprove.get("meetingId").getAsInt();
		int action = jsonMeetingToApprove.get("action").getAsInt();
		
		Meeting.meetingStatus status = meetingStatus.valueOf(action);
		if(ServerUtils.validateUserSession(id, token, iom.getDataAccess())){
			if(meetingId>0 && action>0) {
				try {
					if(iom.getDataAccess().changeMeetingStatus(meetingId, id, status)){
						
						iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
						
				

						
					}else {
						iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
							
					}
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
