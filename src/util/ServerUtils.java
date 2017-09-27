package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mm.model.JsonUser;


public class ServerUtils {
	
	/** -- Session related methods: */
	
	public static String generateToken() {
        int length = 128;
        String candidateChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb =  new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        return sb.toString();
    }
	 
	
	/**Android related methods*/
	
	/**
	 * getJsonFromRequest
	 * @param request
	 * @param toJsonClass
	 * @return
	 * @throws IOException
	 */
	public static <T> T getJsonFromRequest(HttpServletRequest request,Class<T> toJsonClass) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));

	    StringBuilder sb = new StringBuilder();
	    String s;
	    while ((s = br.readLine()) != null) {
	         sb.append(s).append("\n");
	    }
	    br.close();
	    String jsonString = sb.toString();
	    Gson gson = new Gson();
	    return gson.fromJson(jsonString,toJsonClass);
	}
	
	/**
	 * returns jsonUser as a response -- jsonUser contains status
	 * @param response
	 * @param jsonUser
	 * @throws IOException
	 */
	public static void respondJsonUser(HttpServletResponse response,JsonUser jsonUser) throws IOException {
		
		
		response.setContentType("application/json");
		// Get the printwriter object from response to write the required json object to the output stream      
		PrintWriter out = response.getWriter();
		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
		out.print(jsonUser);
		out.flush();
		out.close();
		
	}
	
	//TODO -- add request validation methods for WEB
	/**Web related methods*/
}
