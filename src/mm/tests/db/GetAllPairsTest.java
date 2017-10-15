package mm.tests.db;

import java.sql.SQLException;
import java.util.ArrayList;

import mm.da.DataAccess;
import mm.model.Meeting;
import mm.model.Mentee;
import mm.model.Mentor;
import mm.model.Pair;
import mm.model.User.userType;

public class GetAllPairsTest {

	static DataAccess da;

	

	public static void main(String[] args) throws SQLException {
		da = new DataAccess();
//		Mentor m1 = new Mentor(0, "sara", "rohana", "sara.rohana@gmail.com", "125", "blabla", 1, "Haifa", "okay", "pic",
//				true, userType.MENTOR, "none", "Student", 2, "yes", "none");
//
//		Mentee m2 = new Mentee(0, "rachell", "green", "rachellgreen@gmail.com", "125", "blabla", 1, "Haifa", "pic",
//				"okay", true, userType.MENTEE, (float) 1, "not yet", 1, (float) 90,
//				"Computer Science", "nope", false, "file", "file");
//		boolean res1=da.addUser(m1);
//		if(res1)System.out.println("mentor added successfully");
//		boolean res2=da.addUser(m2);
//		if(res2)System.out.println("mentee added successfully");
		
		for(Meeting m:da.getMeetingsByPairId(69))
		{
			System.out.println(m);
		}
//		Pair p = new Pair(17, 36);
//		p.setPairId(3);
//		p.setActiveStatus(1);
	//	p.setMentee(m2);
		//p.setMentor(m1);
		//System.out.println("mentor id = " + m1.getId());
	//	System.out.println("mentee id = " + m2.getId());

//		boolean res = da.addPair(17,36);
//		if (res) {
//			System.out.println("Pair added successfully");
//			ArrayList<Pair> allPairs = da.getAllPairs();
//			for (Pair pair : allPairs) {
//				System.out.println(pair.toString());
//			}
//
//			Pair tmp = da.getPair(p.getPairId());
//			System.out.println(tmp.toString());
//			da.disconnectPair(p.getPairId());
//			System.out.println("after disconnect************");
//			allPairs = da.getAllPairs();
//			for (Pair pair : allPairs) {
//				if (pair.getActiveStatus() == 1)
//					System.out.println(pair.toString());
//			}
//			System.out.println("allPairs is supposed to be an empty arrayList");
//		}
	}

}
