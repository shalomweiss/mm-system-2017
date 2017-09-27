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
import mm.constants.Constants;
import mm.da.DataAccess;
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

	private class MeetingSession {

		private int id;
		private String token;
		
		private int meetingStatus;
		private int count;
		private int page;

		@Override
		public String toString() {
			return "MeetingSession [id=" + id + ", token=" + token + ", meetingStatus="
					+ meetingStatus + ", count=" + count + ", page=" + page + "]";
		}

		public MeetingSession(int id, String token, int meetingId, int meetingStatus, int count, int page) {
			super();
			this.id = id;
			this.token = token;
			this.meetingStatus = meetingStatus;
			this.count = count;
			this.page = page;
		}

	}

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
		doGet(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));

		MeetingSession myMeeting = ServerUtils.getJsonFromRequest(request, MeetingSession.class);
		JsonMeeting jsonMeeting = null;
		List<Meeting> meetings =null;
		DataAccess da = new DataAccess();
		//TODO: make sure the function name is right
		//meetings= da.getAllMeetings(myMeeting);
		if(meetings==null) {
			jsonMeeting = new JsonMeeting (Constants.STATUS_MISSINGPARA, Constants.USERNOTFOUND, null,meetings);
		}
		else {
			jsonMeeting = new JsonMeeting (Constants.STATUS_SUCCESS, Constants.SUCCESS, myMeeting.token,meetings);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
