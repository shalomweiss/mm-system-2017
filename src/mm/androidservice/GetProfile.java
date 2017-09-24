package mm.androidservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import mm.constants.Constants;
import mm.da.DataAccess;
import mm.model.JsonUser;
import mm.model.User;

@Path("/users")
public class GetProfile {
	
	

	@GET
	@Path("/getProfile")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonUser getProfile(@QueryParam("id") String id,@QueryParam("token") String token) {
		JsonUser jsonUser;
		User user;
<<<<<<< HEAD
<<<<<<< Updated upstream
=======

>>>>>>> Server
		
		DataAccess da = new DataAccess();
		//user=da.getUser(id);//returns a user or null or session not available
		user=null;
		if(user==null) {
			jsonUser=new JsonUser(null,Constants.STATUS_MISSINGPARA,Constants.USERNOTFOUND,token);
		}
		else {
			jsonUser=new JsonUser(user,Constants.STATUS_SUCCESS,Constants.SUCCESS,token);

		}
		
		return jsonUser;
		
	}
	
}
