package mm.tests.db;

import java.sql.SQLException;
import java.util.ArrayList;

import mm.da.DataAccess;
import mm.model.Meeting;

public class AddMeetingTest {

	static DataAccess da;

	public AddMeetingTest() {
		super();
	}

	public static void main(String[] args) throws SQLException {
		da = new DataAccess();
		/*
		long d = 0;
		java.sql.Time jsqlT1 = java.sql.Time.valueOf( "18:05:00" );
		java.sql.Time jsqlT2 = java.sql.Time.valueOf( "18:05:00" );
				
		Meeting m1 = new Meeting(11, 2 ,17, 16, "myNote", mm.model.Meeting.meetingStatus.PENDING , "ten", "ten", "nine", "nine",
				mm.model.Meeting.meetingType.FACE_TO_FACE , "sub1", "downtown", d, jsqlT1, jsqlT2 , false, false);
		*/
		
		//getMeetingByStatus Test
		ArrayList<Meeting> meetings = da.getMeetingByStatus(17, mm.model.Meeting.meetingStatus.COMPLETE, 3, 1);

		for (Meeting m : meetings) {
			System.out.println(m.getMentorPrivateReport());
		}

	}

}
