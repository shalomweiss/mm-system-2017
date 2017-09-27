package tests.servertests;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
public class AndroidClientTest {
  public static void main(String[] args) throws IOException {

		String input = "{\"email\":\"myk22\",\"password\":\"qweasd\",\"deviceId\":\"1234\"}";

		//String url = "http://localhost:8080/mm-database-2017/LogIn";
		String url = "http://zofenweb-env.hhaqjxq9wa.us-east-2.elasticbeanstalk.com/LogIn";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setDoOutput(true);
		
		OutputStream out = con.getOutputStream();
		
		out.write(input.getBytes(StandardCharsets.UTF_8));
		out.close();		

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
		System.out.println("RESEE " +response);

	}
  
}
