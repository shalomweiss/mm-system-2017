package mm.constants;
import mm.model.Mentor;
import mm.model.User;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;

public class Constants {
	public final static Type USER_CLASS = new TypeToken<List<User>>() {}.getType();	
	public final static String SUCCESS="success";
	public final static String USERNOTFOUND="user not found";
	public final static String WRONGPASSWORD="wrong password";
	public final static int STATUS_SUCCESS=200;
	public final static int STATUS_MISSINGPARA=401;
	public final static int STATUS_WRONGPARA=402;

	public final static Type MENTOR_CLASS = new TypeToken<List<Mentor>>() {}.getType();	




}
