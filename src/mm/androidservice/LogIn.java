package mm.androidservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.crypto.Data;
import javax.enterprise.context.spi.Context;
import javax.json.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Past;

import mm.da.DataAccess;
import mm.model.*;

import java.lang.Object;

import java.sql.SQLException;

import org.apache.catalina.Session;

public class LogIn {

	// This method is called if TEXT_PLAIN is request
	@javax.ws.rs.core.Context
	@POST
	@Path("/LogIn")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonUser doLogin(@QueryParam("uName") String uname,
			@QueryParam("uPass") String pwd,
			@javax.ws.rs.core.Context HttpServletRequest req) {
		{

			HttpSession session = req.getSession(true);
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

				jsonUser = new JsonUser(user, 403, "invalid input", null);
			} else {

				// HttpSession session=Context
				jsonUser = new JsonUser(user, 200, "success", session);

			}

			return jsonUser;

		}
	}
}
