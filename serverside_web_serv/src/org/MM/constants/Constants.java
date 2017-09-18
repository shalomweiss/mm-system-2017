package org.MM.constants;
import org.MM.model.User;
import java.lang.reflect.Type;
import java.util.Collection;
import com.google.gson.reflect.TypeToken;

public class Constants {
	public final static Type USER_CLASS = new TypeToken<Collection<User>>() {}.getType();	
	


}
