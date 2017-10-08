package mm.androidservice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import mm.constants.Constants;
import mm.da.DataAccess;
import mm.da.DataInterface;
import mm.jsonModel.JsonUser;
import mm.jsonModel.JsonUsers;
import mm.model.Mentee;
import mm.model.User;
import util.ServerUtils;

/**
 * Servlet implementation class GetMentees
 */
@WebServlet("/GetMentees")
public class GetMentees extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetMentees() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AndroidIOManager iom = new AndroidIOManager(request, response);
		JsonObject myJson = iom.getJsonRequest();
		int flag=0;
		
		int id = (myJson.get("id").isJsonNull() ? flag=1 : myJson.get("id").getAsInt());
		String token = (String) (myJson.get("token").isJsonNull()? flag=1 :myJson.get("token").getAsString());
		if(flag==1) {
			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
		}else {

		List<Mentee> mentees = null;

		try {
			if (ServerUtils.validateUserSession(id, token, iom.getDataAccess())) {

				try {
					mentees = iom.getDataAccess().getMenteesOfMentor(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (mentees == null) {

					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
				} else {

					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
					iom.addResponseParameter("users", mentees);
					for(int i=0;i<mentees.size();i++)
						System.out.println(mentees.get(i).toString());

				}

			} else {
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.INVALID_SESSION));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		iom.SendJsonResponse();

	}

}
