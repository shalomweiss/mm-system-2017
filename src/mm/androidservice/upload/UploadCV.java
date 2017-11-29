package mm.androidservice.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import mm.androidservice.ErrorModel;
import mm.androidservice.RESPONSE_STATUS;
import mm.androidservice.common.UnsupportedFormatException;
import mm.androidservice.common.WordToPDF;
import mm.da.DataAccess;
import mm.model.Mentee;
import util.ServerUtils;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadCV")
public class UploadCV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadCV() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AndroidIOManager iom = null;
		File file = null;
		File outPdf = null;
		try {
			iom  = new AndroidIOManager(response);
		String isForUser = null;
		boolean forUser = false;
		//forUserId - int
		String id = request.getHeader("id");
		String token = request.getHeader("token");
		
	
			isForUser =request.getHeader("forUserId");
		
		
		if(isForUser!=null) {
			forUser = true;
		}

	

		FileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemFactory);

		// if (!contentType.equals("image/png")) {
		// out.println("Only PNG image files supported.");
		// continue;
		// }
		
		boolean isConverted = false;
		boolean isValidForUser = false;
		
			if (id != null) {
				if (token.equals("TSOFEN")
						|| ServerUtils.validateUserSession(Integer.parseInt(id), token, iom.getDataAccess())) {
					
					
					if(forUser) {
						ArrayList<Mentee> listOfMentees = iom.getDataAccess().getMenteesOfMentor(Integer.parseInt(id));
						int menteeId = Integer.parseInt(isForUser);
						if(listOfMentees!= null)
						for(Mentee m : listOfMentees) {
							if(m.getId() == menteeId) {
								System.out.println(m.getId());
								isValidForUser = true;
								break;
							}
							
						}
						if(!isValidForUser) {
							UnsupportedFormatException
							.invalidFormat("This is mentee is not in mentor's list.");
							return;
						}
					}
					
					List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));
					for (FileItem item : items) {
						System.out.println(request.getHeader("Content-Type"));
						System.out.println(item.getContentType());
						String contentType = item.getContentType();
						// save file in temporary directory on the server before sending it to a bucket

						if (contentType.equals("text/plain") || contentType.equals("application/pdf") || contentType
								.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
								||
								contentType.equals("application/msword")) {
							if (contentType.equals("text/plain")) {
								file = File.createTempFile("cvtoupload", ".txt");
							}
							if (contentType.equals("application/pdf")) {
								file = File.createTempFile("cvtoupload", ".pdf");
							}
							if (contentType.equals(
									"application/vnd.openxmlformats-officedocument.wordprocessingml.document")
									||
									contentType.equals("application/msword")) {
							
								file = File.createTempFile("cvtoupload", ".docx");
								outPdf = File.createTempFile("doctopdf", ".pdf");

								isConverted = true;
							}

						} else {
							UnsupportedFormatException
									.invalidFormat("Unsupported File Format.(Only .txt .pdf .docx allowed)");

						}

						item.write(file);// write to temp

						
						
						// upload to bucket
						if (isConverted && file != null) {
							WordToPDF.ConvertToPDF(file, outPdf);
							ClientUploadFile.uploadFile(id + ".docx", file, ClientUploadFile.CV_BUCKET, contentType);
							iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
						}
						if (outPdf != null) {
							ClientUploadFile.uploadFile(id, outPdf, ClientUploadFile.CV_BUCKET, "application/pdf");
							iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
						}
						if(!isConverted && file != null){
							ClientUploadFile.uploadFile(id, file, ClientUploadFile.CV_BUCKET, contentType);
							iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
						}
						// success
						file.deleteOnExit();
						if (outPdf != null)
							outPdf.deleteOnExit();
					}
				} else {
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.INVALID_SESSION));
				}
			} else {
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
			}
		} 
		catch (NullPointerException e) {
			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.UNSUPPORTED_FORMAT));

		} catch (FileUploadException e) {

			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.GENERAL_ERROR));

		} catch (UnsupportedFormatException e) {

			e.printStackTrace();
			iom.setResponseMessage(new ErrorModel() {

				@Override
				public String getMessage() {
					return "Error converting doc to pdf.";
				}

				@Override
				public int getCode() {
					return 404;
				}
			});

		} catch (Exception e) {
			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.GENERAL_ERROR));

		} finally {
			if (file != null)
				file.deleteOnExit();
			
			if (outPdf != null)
				outPdf.deleteOnExit();

			if(iom!=null)
			iom.SendJsonResponse();
		}
		
		
		
	}
	



}
