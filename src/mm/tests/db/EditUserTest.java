package mm.tests.db;

import java.sql.SQLException;

import mm.da.DataAccess;
import mm.model.Mentee;
import mm.model.Mentor;

public class EditUserTest {

	static DataAccess da;

	public EditUserTest() {
		super();
	}

	public static void main(String[] args) throws SQLException {
		da = new DataAccess();
		
		Mentor mentor = (Mentor) da.getUser(9);
		
		Mentee mentee = (Mentee) da.getUser(4);

		
		
		mentor.setCompany(2);
	//	mentor.setActive(false);
		mentor.isActive();
		mentor.setAddress("Yafa");
		mentor.setLastName("black ");
		
		mentee.setAcademicDicipline("Arts");
		mentee.setAverage(80);
		mentee.setFirstName("leen");
		mentee.setAddress("aco");
		
		
		
		da.editUser(mentor);
		da.editUser(mentee);

		System.out.println("updated mentor :" + da.getUser(9).toString());
		
		System.out.println("updated mentee :" + da.getUser(4).toString());
		
		
		
		

	}

}
