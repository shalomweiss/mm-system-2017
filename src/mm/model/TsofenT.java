package mm.model;

import java.sql.Date;

public class TsofenT extends User{
	public TsofenT(int id, String firstName, String lastName, String email, String phoneNumber, String password,
			int gender, String address, String profilePicture, String note, boolean active, userType type, int areaId, String area, int cityId, String city, Date date) {
		super(id, firstName, lastName, email, phoneNumber, password, gender, address, profilePicture, note, active, type, areaId, area, cityId, city, date);
		// TODO Auto-generated constructor stub
	}
}


