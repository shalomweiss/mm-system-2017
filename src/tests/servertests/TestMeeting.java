package tests.servertests;

import java.sql.Time;

import com.google.gson.Gson;

import mm.model.Meeting;
import mm.model.Meeting.meetingType;

public class TestMeeting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Meeting myTestMeeting = new Meeting(0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		System.out.println( new Gson().toJson(myTestMeeting, Meeting.class) );
	}
}
