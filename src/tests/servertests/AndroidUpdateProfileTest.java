package tests.servertests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Date;

import com.google.gson.Gson;

import mm.model.User;
import util.GeneratePass;


public class AndroidUpdateProfileTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String uPass= GeneratePass.getSaltString();	
        long millis=System.currentTimeMillis();  
        Date date=new Date(millis);
		User myUser = new User(1,"testMan","ok","gmail.com","12345","abc",0, "male","Antractica","good test",true,User.userType.MENTEE,1,"",1,"",date);
		
		Gson myJ = new Gson();
		String jsonInString = myJ.toJson(myUser);
		
		//System.out.println(jsonInString);
		

		//System.out.println(User.class);
		

//		Client client = Client.create();
//
//		WebResource webResource = client
//		   .resource("http://localhost:8080/mm-database-2017/LogInTest");

		String input = "{\r\n" + 
				"	\"id\": \"1\",\r\n" + 
				"	\"token\": \"longString\",\r\n" + 
				"	\"user\": {\r\n" + 
				"		\"id\": 1,\r\n" + 
				"		\"firstName\": \"testMan\",\r\n" + 
				"		\"lastName\": \"ok\",\r\n" + 
				"		\"email\": \"gmail.com\",\r\n" + 
				"		\"phoneNumber\": \"12345\",\r\n" + 
				"		\"password\": \"abc\",\r\n" + 
				"		\"gender\": \"male\",\r\n" + 
				"		\"address\": \"Antractica\",\r\n" + 
				"		\"note\": \"good test\",\r\n" + 
				"		\"active\": true,\r\n" + 
				"		\"type\": \"MENTEE\"\r\n" + 
				"	}\r\n" + 
				"}";
		String url = "http://localhost:8080/mm-database-2017/UpdateProfile";
		//String url = "http://localhost:8080/mm-database-2017/LogIn";
		//String url = "http://localhost:8080/mm-database-2017/updateProfile";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		
		OutputStream out = con.getOutputStream();
		
//		JsonParser jsonParser = new JsonParser();
//		JsonObject jo = (JsonObject)jsonParser.parse(input);
		//add request header
		out.write(input.getBytes(StandardCharsets.UTF_8));
		out.close();		
		//con.setRequestProperty("myData", input);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	
		
	}

}
