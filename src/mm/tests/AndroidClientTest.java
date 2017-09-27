package mm.tests;


import javax.ws.rs.core.Response;

import mm.model.JsonUser;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.research.ws.wadl.Request;

import mm.androidservice.*;

public class AndroidClientTest {

  public static void main(String[] args) {

	try {
		Client client = Client.create();

		WebResource webResource = client
		   .resource("http://localhost:8080/mm-database-2017/users/sss");

		String input = "{\"email\":\"Metallica\"}";

		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class, input);

		if (response.getStatus() != 200) {
			System.out.println("error");
		}
		String result = "Restful example : ";

		System.out.println("Output from Server .... \n");
		
		
		int output = response.getStatus();
		System.out.println("OOO "+output);

	  } catch (Exception e) {

		e.printStackTrace();
	  }

	}
}
