package tests;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class AndroidClientTest {


  public static void main(String[] args) {

	try {

		Client client = Client.create();

		WebResource webResource = client
		   .resource("http://localhost:8080/LogIn");

		String input = "{\"email\":\"myk22\",\"password\":\"qweasd\"}";

		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class, input);

		if (response.getStatus() != 200) {
			System.out.println("error");
		}

		System.out.println("Output from Server .... \n"+response.getStatus());
		String output = response.getEntity(String.class);
		System.out.println(output);

	  } catch (Exception e) {

		e.printStackTrace();

	  }

	}
}