//package mm.androidservice;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.core.MediaType;
//
//import mm.constants.Constants;
//import mm.da.DataAccess;
//import mm.model.JsonUser;
//import mm.model.User;
//
//public class DeprecatedUpdateProfile {
//
//	
//	
//
//	@POST
//	@Path("/updateProfile")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public JsonUser updateProfile(@QueryParam("id") String id,@QueryParam("token") String token,@QueryParam("user")User updatedUser) {
//		JsonUser jsonUser;
//		User user;
//		DataAccess da = new DataAccess();
//		user=da.updateProfile(id,token,updatedUser);
//		
//		if(user==null) {
//			jsonUser=new JsonUser(user, Constants.STATUS_MISSINGPARA, Constants.USERNOTFOUND, token);
//		}
//		else {
//			jsonUser=new JsonUser(user, Constants.STATUS_SUCCESS, Constants.SUCCESS, token);
//		}
//		
//		return jsonUser;
//		
//}
//}