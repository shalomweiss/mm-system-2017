package mm.androidservice;

import java.sql.SQLException;

import javax.ws.rs.Consumes;


import javax.ws.rs.GET;

import javax.ws.rs.GET;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import controllers.SessionController;
import mm.constants.Constants;
import mm.da.DataAccess;
import mm.model.JsonUser;
import mm.model.User;

import controllers.SessionController;

import mm.da.DataAccess;
import mm.model.*;
import mm.constants.*;

import java.lang.Object;

import java.sql.SQLException;


@Path("/users")
public class DeprecatedLogIn {

	// This method is called if TEXT_PLAIN is request
	
	@POST
	@Path("/LogIn")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonUser doLogin(@QueryParam("email") String uname,@QueryParam("password") String pwd,@QueryParam("deviceId") String deviceId)
			 {
		{
			System.out.println("heloo");
		//	PrintWriter writer = 

			
			DataAccess da = new DataAccess();
			User user = null;
			try {
				user = da.login(uname);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JsonUser jsonUser;

			if (user == null) {

				jsonUser = new JsonUser(user, Constants.STATUS_MISSINGPARA, Constants.USERNOTFOUND, null);
			} else {
				if(user.getPassword().equals(pwd)) {
				String session=SessionController.generateToken();
				//insert session into database
				jsonUser = new JsonUser(user, Constants.STATUS_SUCCESS, Constants.SUCCESS, session);
				
				}
				else {
					jsonUser = new JsonUser(user, Constants.STATUS_WRONGPARA, Constants.WRONGPASSWORD, null);
				}
				

			}

			return jsonUser;

		}
	}
}
