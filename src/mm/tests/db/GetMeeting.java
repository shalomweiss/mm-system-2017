package mm.tests.db;

import java.sql.SQLException;

import mm.da.DataAccess;
import mm.model.Meeting;

public class GetMeeting {
	
	static DataAccess da;
	
	public static void main(String[] args) throws SQLException {
	
		da = new DataAccess();
		
		Meeting m= da.getMeetingById(1);
		System.out.println(m);
		
	}
	}

