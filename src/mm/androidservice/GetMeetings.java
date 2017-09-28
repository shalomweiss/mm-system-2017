package mm.androidservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
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
		
		JsonObject myJson = ServerUtils.getJsonObjcetFromRequest(request);
		
		int id = (myJson.get("id").isJsonNull() ? 0 : myJson.get("id").getAsInt());
		String token = myJson.get("token").getAsString();
		int meetingStatus =(myJson.get("meetingStatus").isJsonNull() ? 0 : myJson.get("meetingStatus").getAsInt());
		int count =  (myJson.get("count").isJsonNull() ? 0 : myJson.get("count").getAsInt());
		int page =  (myJson.get("page").isJsonNull() ? 0 : myJson.get("page").getAsInt());
	
		
		
		JsonMeeting jsonMeeting = null;
		List<Meeting> meetings =null;
		DataInterface da = new DataAccess();
	
		
		
		if(ServerUtils.validateUserSession(id,token,da)) {
		if(meetings==null) {
			jsonMeeting = new JsonMeeting (Constants.STATUS_MISSINGPARA, Constants.USERNOTFOUND, null,meetings);
		}
		else {
			jsonMeeting = new JsonMeeting (Constants.STATUS_SUCCESS, Constants.SUCCESS, token,meetings);
		}
		}else {
			jsonMeeting = new JsonMeeting(Constants.STATUS_MISSINGPARA, Constants.INVALID_SESSION_TOKEN,null,meetings);
		}
		
		
		ServerUtils.respondJsonObject(response,jsonMeeting);
	}

}
