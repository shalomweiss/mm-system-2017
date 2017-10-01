package tests.servertests;

import java.sql.SQLException;
import java.sql.Time;

import com.google.gson.Gson;

import mm.da.DataAccess;
import mm.model.Meeting;
import mm.model.Meeting.meetingStatus;
import mm.model.Meeting.meetingType;
import util.DBUtil;

public class TestMeeting {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		Meeting myTestMeeting = new Meeting(1, 4, 8, 2, null,meetingStatus.APPROVED, null, null, null, null, meetingType.FACE_TO_FACE, null, null, null, null, null, false,false);
		//new DataAccess().addMeeting(myTestMeeting);
		//new DataAccess().getMeetingById(1);
		
		System.out.println(DBUtil.getConnection());
		//System.out.println( new Gson().toJson(myTestMeeting, Meeting.class) );
	}

}
