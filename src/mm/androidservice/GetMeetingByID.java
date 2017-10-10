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
import mm.da.DataInterface;
import mm.model.JsonMeeting;
import mm.model.Meeting;
import mm.model.Session;
import mm.model.User;
import mm.androidservice.AndroidIOManager;
import util.ServerUtils;

/**
 * Servlet implementation class GetMeetingByID
 */
@WebServlet("/GetMeetingByID")
public class GetMeetingByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
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
		
		AndroidIOManager iom = new AndroidIOManager(request,response);
		JsonObject myJson = iom.getJsonRequest();
		//int id,String token,int meetingId
		int id = myJson.get("id").getAsInt();
		String token = myJson.get("token").getAsString();
		int meetingId = myJson.get("meetingId").getAsInt();

		Meeting meetingFromDB = null;
		try {
			if(ServerUtils.validateUserSession(id, token, iom.getDataAccess())){
				try {
					meetingFromDB = iom.getDataAccess().getMeetingById(Integer.valueOf(meetingId));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				
				if(meetingFromDB==null) {
					//TODO 
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
				} 
				else {
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
					iom.addResponseParameter("meeting", meetingFromDB);
				}
				

			}else {
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.INVALID_SESSION));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		iom.SendJsonResponse();

		
	}

}
