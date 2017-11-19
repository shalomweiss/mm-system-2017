package mm.androidservice.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class JsonKeyMapper {
	
	private static String path = "/log.json";
	public static final String ID;
	public static final String KEY;

	static{
		InputStream is = null;
		BufferedReader reader = null;
		try {
		 is = JsonKeyMapper.class.getResourceAsStream(path);
		 reader = new BufferedReader(new InputStreamReader(is));
		
		  JsonObject jsonObject = (JsonObject) new JsonParser().parse(reader);
		 
		  //Initialising fields
		  ID = jsonObject.get("id").getAsString();
		  KEY = jsonObject.get("key").getAsString();
		
		 //Closing streams
		}finally {
			  try {
			 if(reader!=null)
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  try {
			 if(is!=null)
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		  
    }
	
	
	
	
	
}
