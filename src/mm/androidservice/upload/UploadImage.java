package mm.androidservice.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import mm.androidservice.AndroidIOManager;
import mm.androidservice.RESPONSE_STATUS;
import mm.androidservice.common.UnsupportedFormatException;
import util.ServerUtils;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadImage")
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletFileUpload uploader = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadImage() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getHeader("id");
		String token = request.getHeader("token");
		AndroidIOManager iom = new AndroidIOManager(response);


		FileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemFactory);

		// if (!contentType.equals("image/png")) {
		// out.println("Only PNG image files supported.");
		// continue;
		// }
		File file = null;
		try {
			if (id != null) {
				if (ServerUtils.validateUserSession(Integer.parseInt(id), token, iom.getDataAccess())) {
					List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));

					for (FileItem item : items) {

						String contentType = item.getContentType();
						// save file in temporary directory on the server before sending it to a bucket

						if(contentType.equals("image/png") || contentType.equals("image/jpeg")) {
							if (contentType.equals("image/png"))
								file = File.createTempFile("img", ".png");
							if (contentType.equals("image/jpeg"))
								file = File.createTempFile("img", ".jpg");
						}else {
							UnsupportedFormatException.invalidFormat("Unsupported Image Format.(Only .png .jpg allowed)");
						
						}
						
					

						item.write(file);// write to temp

						// upload to bucket
						ClientUploadFile.uploadFile(id, file, ClientUploadFile.PIC_BUCKET,contentType);
						iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
						// success
						file.deleteOnExit();
					}
				} else {
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.INVALID_SESSION));
				}
			} else {
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
			}
		} catch (NullPointerException e) {
			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.UNSUPPORTED_FORMAT));

			return;
		} catch (FileUploadException e) {
			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.GENERAL_ERROR));

			return;
		}catch (UnsupportedFormatException e) {
			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.UNSUPPORTED_FORMAT));
		} 
		
		catch (Exception e) {
			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.GENERAL_ERROR));
		} finally {
			if (file != null)
				file.deleteOnExit();

			iom.SendJsonResponse();
		}

	}

}
