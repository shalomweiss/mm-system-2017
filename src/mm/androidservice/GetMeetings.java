package mm.androidservice;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonObject;
import util.ServerUtils;
import java.util.ArrayList;
import java.util.List;

import mm.jsonModel.MeetingModel;
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		AndroidIOManager iom = new AndroidIOManager(request, response);
		JsonObject myJson = iom.getJsonRequest();
		int flag=0;
		
		int id = (myJson.get("id").isJsonNull() ? flag=1 : myJson.get("id").getAsInt());
		String token = (String) (myJson.get("token").isJsonNull()? flag=1 :myJson.get("token").getAsString());
		int status = (myJson.get("meetingStatus").isJsonNull() ? flag=1 : myJson.get("meetingStatus").getAsInt());
		meetingStatus meetingStatus = mm.model.Meeting.meetingStatus.values()[status];
		int count = (myJson.get("count").isJsonNull() ? flag=1 : myJson.get("count").getAsInt());
		int page = (myJson.get("page").isJsonNull() ? flag=1 : myJson.get("page").getAsInt());

		if(flag==1) {
			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
		}else {
		List<Meeting> meetings = new ArrayList<Meeting>();
		List<MeetingModel> meetingsToReturn = new ArrayList<MeetingModel>();
		/////////////// TEST////////////////
		// Time time =new Time(12, 12, 2017);
		// Meeting[] arr = {new
		// Meeting(111,5,4,16,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017, time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false),
		// new
		// Meeting(1131,4,6,17,"note",meetingStatus.PENDING,"report1","report2","report3","report4",meetingType.FACE_TO_FACE,"subject","location",(long)
		// 12122017,time,time,false,false)};

		// iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
		//////////// END OF TEST/////////////////////////

		// DataInterface da = new DataAccess();

		if (ServerUtils.validateUserSession(id, token, iom.getDataAccess())) {

			try {
				meetings = iom.getDataAccess().getMeetingByStatus(id, meetingStatus, count, page);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (meetings == null) {
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
			} else {
				/// each meeting must not contain pairId, all reports,complete...
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));

				for (int i = 0; i < meetings.size(); i++) {
					meetings.get(i).setPairId(0);
					meetings.get(i).setMenteePrivateReport(null);
					meetings.get(i).setMentorPrivateReport(null);
					meetings.get(i).setMentorReport(null);
					meetings.get(i).setMenteeReport(null);
				}
				
				for(Meeting e:meetings) {
					meetingsToReturn.add(MeetingModel.fromMeeting(e));
				}
				
				iom.addResponseParameter("meetings", meetingsToReturn);
			}
		} else {
			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.INVALID_SESSION));
		}
		}

		iom.SendJsonResponse();
	}
		
}
