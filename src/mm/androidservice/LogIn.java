package mm.androidservice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import mm.model.Session;
import mm.model.User;
import mm.model.User.userType;
import util.ServerUtils;

/**
 * Servlet implementation class LogInTest
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogIn() {
		super();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//response.addHeader("Content-Type", "application/json; charset=UTF-8"); 

		AndroidIOManager iom = new AndroidIOManager(request, response);

		try {
			JsonObject myJson = iom.getJsonRequest();

			String email = myJson.get("email").getAsString();
			String password = myJson.get("password").getAsString();
		
			String deviceId = "0";
			if (myJson.has("deviceId")) {
				deviceId = myJson.get("deviceId").getAsString();
			}
			User user = null;
			try {
				user = iom.getDataAccess().login(email);

				if (user == null) {
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
				} else if (user.getPassword().equals(password)
						&& (user.getType() == userType.MENTEE || user.getType() == userType.MENTOR)) {

					String token = ServerUtils.generateToken();
					
					try {
						iom.getDataAccess().startUserSession(new Session(user.getId(), token, deviceId));
						iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
						iom.addResponseParameter("user", user);
						iom.addResponseParameter("token", token);
					} catch (SQLException e) {
						iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
					}

				} else {
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PASSWORD_ERROR));
				}

			} catch (SQLException e) {
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
			}

		} catch (NullPointerException ex) {

			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
		} catch (Exception e) {
			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.GENERAL_ERROR));
		} finally {
			iom.SendJsonResponse();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
	}

}
