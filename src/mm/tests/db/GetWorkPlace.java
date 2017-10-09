package mm.tests.db;

import java.sql.SQLException;

import mm.da.DataAccess;
import mm.model.WorkPlace;

public class GetWorkPlace {
	static DataAccess da;
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		da = new DataAccess();
        WorkPlace w = da.getWorkPlaceById(2);
        System.out.println(w);
	}

}
