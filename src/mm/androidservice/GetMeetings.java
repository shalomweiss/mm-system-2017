package mm.androidservice;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import mm.constants.Constants;
import mm.da.DataAccess;
import mm.model.Activity;
import mm.model.JsonUser;
import mm.model.User;

public class GetMeetings {

	@GET
	@Path("/getMeetings")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	
	id, token, meetingStatus, count, page

	public JsonUser getProfile(@QueryParam("id") String id,@QueryParam("token") String token,@QueryParam("meetingStatus") String status ) {
		JsonUser jsonUser;
		Collection <Activity> meetings = new ArrayList<Activity>();
		DataAccess da = new DataAccess();
		meetings=da.getMeetings(id,token,status);//returns a collection of activities.
		if(meetings==null) {
			jsonUser=new JsonUser(null,Constants.STATUS_MISSINGPARA,Constants.USERNOTFOUND,token);
		}
		else {
			jsonUser=new JsonUser(meetings,Constants.STATUS_SUCCESS,Constants.SUCCESS,token);

		}
		
		return jsonUser;
		
	}
}
