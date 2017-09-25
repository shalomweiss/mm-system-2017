package tests;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;




public class AndroidClientTest {





  public static void main(String[] args) throws IOException {

	

//		Client client = Client.create();
//
//		WebResource webResource = client
//		   .resource("http://localhost:8080/mm-database-2017/LogInTest");

		String input = "{\"email\":\"Metallica\",\"password\":\"Fade To Black\",\"deviceId\":\"1234\"}";

		String url = "http://localhost:8080/mm-database-2017/LogIn";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		con.setDoOutput(true);
		
		OutputStream out = con.getOutputStream();
		
//		JsonParser jsonParser = new JsonParser();
//		JsonObject jo = (JsonObject)jsonParser.parse(input);
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
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}
}