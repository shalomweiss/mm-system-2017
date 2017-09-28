package tests.servertests;

import java.util.HashMap;
import java.util.Map;

import mm.model.User;
import util.ServerUtils;

public class TestUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Map<String, Object> inputMap = new HashMap<String, Object>();
	        inputMap.put("name", "Java2Novice");
	        inputMap.put("site", "http://java2novice.com");
	        inputMap.put("boolean", true);
	        inputMap.put("user", new User("one","two"));
	        
	        
	       System.out.println( ServerUtils.mapToJson(inputMap) );
		

	}

}
