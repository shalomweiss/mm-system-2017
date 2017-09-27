package mm.da;

import java.sql.SQLException;

import mm.model.User;

public interface DataInterface {
	public User login(String email) throws SQLException;
	public boolean updateUserInfo(User user) throws SQLException;
	public boolean deactivateUser(int id) throws SQLException;
	
}
