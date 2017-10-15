package mm.tests.db;

import java.sql.SQLException;

import mm.da.DataAccess;

public class ChangeMeetingStatus {

	static DataAccess da;

	public ChangeMeetingStatus() {
		super();
	}

	public static void main(String[] args) throws SQLException {
		da = new DataAccess();

		da.changeMeetingStatus(11, 16, mm.model.Meeting.meetingStatus.COMPLETE);


	}

}
