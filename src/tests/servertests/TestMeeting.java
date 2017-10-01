package tests.servertests;

import java.sql.Time;

import com.google.gson.Gson;

import mm.model.Meeting;
import mm.model.Meeting.meetingType;

public class TestMeeting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Meeting myTestMeeting = new Meeting(1,2,3,"meeting note",2,"mentee report","mentor report","mentee private report","mentor private report",meetingType.SMS,"we did nothing interesting","haifa",1234l,new Time(100),new Time(100),true,true);
		
		System.out.println( new Gson().toJson(myTestMeeting, Meeting.class) );
	}

}
