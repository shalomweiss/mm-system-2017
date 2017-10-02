package mm.androidservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import mm.constants.Constants;
import mm.da.DataAccess;
import mm.da.DataInterface;
import mm.jsonModel.JsonMeeting;
import mm.jsonModel.JsonUser;
import mm.model.User;
import util.ServerUtils;

import java.util.ArrayList;
import java.util.List;
import mm.model.Meeting;
import mm.model.Meeting.meetingStatus;

/**
 * Servlet implementation class GetMeetings
 */
@WebServlet("/GetMeetings")
public class GetMeetings extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetMeetings() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AndroidIOManager iom = new AndroidIOManager(request,response);
		JsonObject myJson = iom.getJsonRequest();
		Gson gson=new Gson();
		
		int id = (myJson.get("id").isJsonNull() ? 0 : myJson.get("id").getAsInt());
		String token = myJson.get("token").getAsString();
		int status=(myJson.get("meetingStatus").isJsonNull() ? 0 : myJson.get("meetingStatus").getAsInt());
		meetingStatus meetingStatus=mm.model.Meeting.meetingStatus.values()[status];
		int count =  (myJson.get("count").isJsonNull() ? 0 : myJson.get("count").getAsInt());
		int page =  (myJson.get("page").isJsonNull() ? 0 : myJson.get("page").getAsInt());
	
		
		
		//JsonMeeting jsonMeeting = null;
		List<Meeting> meetings =null;
		//DataInterface da = new DataAccess();
		System.out.println("het");
		
		if(ServerUtils.validateUserSession(id,token,iom.getDataAccess())) {
			
			try {
				meetings=iom.getDataAccess().getMeetingByStatus(id, meetingStatus, count, page);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(meetings==null) {
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
			}
			else {
				///each meeting must not contain pairId, all reports,complete...
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
				
				for(int i=0;i<meetings.size();i++) {
					meetings.get(i).setPairId(0);
					meetings.get(i).setMenteePrivateReport(null);
					meetings.get(i).setMentorPrivateReport(null);
					meetings.get(i).setMentorReport(null);
					meetings.get(i).setMenteeReport(null);
					meetings.get(i).setMenteeComplete(null);
					meetings.get(i).setMentorComplete(null);
					
					
				}
				iom.addResponseParameter("meetings", meetings);
			}
				}else {
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.INVALID_SESSION));
				}
		
		
		iom.SendJsonResponse();
	}

}
