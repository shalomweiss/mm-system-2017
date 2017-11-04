package mm.androidservice.download;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import mm.androidservice.AndroidIOManager;
import mm.androidservice.RESPONSE_STATUS;
import util.ServerUtils;

/**
 * Servlet implementation class DownloadFile
 */
@WebServlet("/DownloadFile")
public class DownloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = null;

		AndroidIOManager iom = new AndroidIOManager(request, response);
		JsonObject jsonRequest = iom.getJsonRequest();
		String token = jsonRequest.get("token").getAsString();

		if (jsonRequest.has("img") || jsonRequest.has("cv") || jsonRequest.has("grade")) {

			if (jsonRequest.has("img"))
				id = jsonRequest.get("img").getAsString();

			if (jsonRequest.has("grade"))
				id = jsonRequest.get("grade").getAsString();

			if (jsonRequest.has("cv"))
				id = jsonRequest.get("cv").getAsString();

			try {
				if (token != null
						&& ServerUtils.validateUserSession(Integer.parseInt(id), token, iom.getDataAccess())) {
					if (jsonRequest.has("img") && jsonRequest.get("img").getAsString() != null) {
						if (!ClientDownloadFile.downloadFile(id, ClientDownloadFile.PIC_BUCKET, response)) {
							ClientDownloadFile.downloadFile("defaultImage", ClientDownloadFile.PIC_BUCKET, response);
							iom.getDataAccess().closeConnection();
						}
					}

					if (jsonRequest.has("cv") && jsonRequest.get("cv").getAsString() != null) {
						ClientDownloadFile.downloadFile(id, ClientDownloadFile.CV_BUCKET, response);
						iom.getDataAccess().closeConnection();
					}

					if (jsonRequest.has("grade") && jsonRequest.get("grade").getAsString() != null) {
						ClientDownloadFile.downloadFile(id, ClientDownloadFile.GRADE_BUCKET, response);
						iom.getDataAccess().closeConnection();
					}

				} else {

					if (jsonRequest.has("img")) {

						ClientDownloadFile.downloadFile("defaultImage", ClientDownloadFile.PIC_BUCKET, response);
						iom.getDataAccess().closeConnection();
					}

					if (jsonRequest.has("cv")) {
						iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.INVALID_SESSION));
						iom.SendJsonResponse();
					}

					if (jsonRequest.has("grade")) {
						iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.INVALID_SESSION));
						iom.SendJsonResponse();
					}

				}
			} catch (NumberFormatException | SQLException e) {

				e.printStackTrace();
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.GENERAL_ERROR));
				iom.SendJsonResponse();
			}
		}

	}

}
