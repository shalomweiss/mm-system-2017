package mm.tests.db;

import java.sql.SQLException;

import mm.da.DataAccess;
import mm.model.AcademicInstitute;

public class getAllAcademiclnstitution {

	static DataAccess da;

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		da = new DataAccess();
		for(AcademicInstitute s:da.getAllAcademiclnstitution())
				System.out.println( s.toString());
	}

}
  