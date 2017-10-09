package mm.tests.db;

import java.sql.SQLException;
import java.util.ArrayList;

import mm.da.DataAccess;
import mm.model.AcademicInstitute;
import mm.model.Mentee;

public class getAllAcademiclnstitution {

	static DataAccess da;

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		da = new DataAccess();
		//for(AcademicInstitute s:da.getAllAcademiclnstitution())
			//System.out.println( s.toString());
		ArrayList<Mentee> mentees = da.getMenteesOfMentor(17);
			System.out.println(mentees);
	}

}
  