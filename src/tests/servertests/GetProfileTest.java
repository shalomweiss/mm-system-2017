package tests.servertests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GetProfileTest {
	  public static void main(String[] args) throws IOException {
			//String input = "{\"id\":\"Metallica\",\"token\":\"Fade To Black\"}";

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
			String url = "http://localhost:8080/mm-database-2017/getProfile";

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");
			con.setDoOutput(true);
			
			OutputStream out = con.getOutputStream();
			
//			JsonParser jsonParser = new JsonParser();
//			JsonObject jo = (JsonObject)jsonParser.parse(input);
			//add request header
			out.write(input.getBytes(StandardCharsets.UTF_8));
			out.close();		
			//con.setRequestProperty("myData", input);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			//	System.out.println(inputLine);

			}
			in.close();

			//print result
			

	  }
}
