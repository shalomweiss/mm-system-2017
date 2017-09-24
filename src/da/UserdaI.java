package da;

import java.util.List;

import mm.model.User;

public interface UserdaI {
	public void addUser( User user );
    public void deleteUser( String userId );
    public void updateUser( User user );
    public List<User> getAllUsers();
    public User getUserById( String userId );
}
