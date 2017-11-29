package mm.androidservice.download;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.CharMatcher;
import com.google.gson.JsonObject;

import mm.androidservice.AndroidIOManager;
import mm.androidservice.ErrorModel;
import mm.androidservice.RESPONSE_STATUS;
import mm.model.Mentee;
import mm.model.User;
import mm.model.User.userType;
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
		
		if(request.getParameter("file")!=null) {
			String imgName = request.getParameter("file");
			if(imgName.equals("tos")) {
				ClientDownloadFile.downloadFile("TOS.pdf", ClientDownloadFile.GRADE_BUCKET, response);
			}
			
		
			return;
		}
		
		
		
		if(request.getParameter("logo")!=null) {
			String imgName = request.getParameter("logo");
			if(imgName.equals("MP-LOGO-10.png")) {
				ClientDownloadFile.downloadFile("MP-LOGO-10.png", ClientDownloadFile.PIC_BUCKET, response);
			

			}else if(imgName.equals("logo-tsofen-tagline-trans-whiteback_2016.png")) {
				ClientDownloadFile.downloadFile("logo-tsofen-tagline-trans-whiteback_2016.png", ClientDownloadFile.PIC_BUCKET, response);
			
			}else if(imgName.equals("logo-tsofen-black.png")) {
				ClientDownloadFile.downloadFile("logo-tsofen-black.png", ClientDownloadFile.PIC_BUCKET, response);
				
			}
			else if(imgName.equals("defaultImage")) {
				ClientDownloadFile.downloadFile("defaultImage", ClientDownloadFile.PIC_BUCKET, response);
				
			}
			return;
		}
	
		


		String id = null;
		
	
		if (request.getParameterMap().containsKey("img") || request.getParameterMap().containsKey("cv") || request.getParameterMap().containsKey("grade")) {

			if (request.getParameterMap().containsKey("img"))
				id = request.getParameter("img");
		
			
			try {
				if ( id != null ) {
					
					
					if (request.getParameterMap().containsKey("img") && request.getParameter("img") != null) {
						if (!ClientDownloadFile.downloadFile(id, ClientDownloadFile.PIC_BUCKET, response)) {
							ClientDownloadFile.downloadFile("defaultImage", ClientDownloadFile.PIC_BUCKET, response);
		
						}
					}

				} 
			} catch (NumberFormatException e) {

				e.printStackTrace();
				
			}
		}

	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = null;
		String token = null;
		AndroidIOManager iom = null;
		try {
		
			iom =  new AndroidIOManager(request, response);
			JsonObject jsonRequest = iom.getJsonRequest();
		int userIdToValidate = -1;
		boolean isValid = false;
		boolean isDoc = false;
		
		
		token = jsonRequest.get("token").getAsString();
		
		if (jsonRequest.has("img") || jsonRequest.has("cv") || jsonRequest.has("grade")) {

			if (jsonRequest.has("img"))
				id = jsonRequest.get("img").getAsString();

			if (jsonRequest.has("grade"))
				id = jsonRequest.get("grade").getAsString();

			if (jsonRequest.has("cv")) {
				id = jsonRequest.get("cv").getAsString();
				if(id.contains("doc")) {
					//if id is id.docx .. get only the id.
					id = CharMatcher.DIGIT.retainFrom(id);
					isDoc=true;
					
				}
			}
				if(jsonRequest.has("MENTOR") || jsonRequest.has("MENTEE") || jsonRequest.has("TSOFEN")) {
					//Check if the id of the file to get is of a mentor's mentee
						if (jsonRequest.has("MENTOR")) {
							userIdToValidate = jsonRequest.get("MENTOR").getAsInt();
							try {
								ArrayList<Mentee> listOfMentees = iom.getDataAccess().getMenteesOfMentor(userIdToValidate);
								Mentee menteeToCheck = (Mentee) iom.getDataAccess().getUser(Integer.parseInt(id));
								if(menteeToCheck !=null) {
									if( ServerUtils.validateUserSession(userIdToValidate, token, iom.getDataAccess()) ){
										if(listOfMentees!=null && listOfMentees.contains(menteeToCheck)) {
											isValid = true;
										}else {
											iom.setResponseMessage(new ErrorModel() {
												
												@Override
												public String getMessage() {
													
													return "Mentee is not in mentor's list.";
												}
												
												@Override
												public int getCode() {
													
													return 404;
												}
											});
									}
								}else {
									iom.setResponseMessage(new ErrorModel() {
										
										@Override
										public String getMessage() {
											
											return "Invalid mentor's'session";
										}
										
										@Override
										public int getCode() {
											
											return 404;
										}
									});
								}
							}else {
								iom.setResponseMessage(new ErrorModel() {
									
									@Override
									public String getMessage() {
										
										return "Invalid file id";
									}
									
									@Override
									public int getCode() {
										
										return 404;
									}
								});
							}
								
							} catch (SQLException e) {
								iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
							} catch (Exception e) {
								iom.setResponseMessage(new ErrorModel() {
									
									@Override
									public String getMessage() {
										
										return "Id of file to get is not mentor.";
									}
									
									@Override
									public int getCode() {
										
										return 404;
									}
								});
							}
						}
						
							
					if (jsonRequest.has("MENTEE")) {
						userIdToValidate = jsonRequest.get("MENTEE").getAsInt();
							try {
								//if the requestor is mentee and his id equals that of the file request - return true
								Mentee menteeToCheck = (Mentee) iom.getDataAccess().getUser(Integer.parseInt(id));
								if(menteeToCheck!=null ){
									if(ServerUtils.validateUserSession(userIdToValidate, token, iom.getDataAccess())) {
										if(menteeToCheck.getId()==userIdToValidate) {
											isValid = true;
										}else {
											iom.setResponseMessage(new ErrorModel() {
												
												@Override
												public String getMessage() {
													
													return "Id's don't match.";
												}
												
												@Override
												public int getCode() {
													
													return 404;
												}
											});
										}
									}else {
										iom.setResponseMessage(new ErrorModel() {
											
											@Override
											public String getMessage() {
												
												return "Invalid mentee's'session";
											}
											
											@Override
											public int getCode() {
												
												return 404;
											}
										});
									}
							}else {
								iom.setResponseMessage(new ErrorModel() {
									
									@Override
									public String getMessage() {
										
										return "Invalid file id";
									}
									
									@Override
									public int getCode() {
										
										return 404;
									}
								});
							}
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							iom.setResponseMessage(new ErrorModel() {
								
								@Override
								public String getMessage() {
									
									return "Invalid file id";
								}
								
								@Override
								public int getCode() {
									
									return 404;
								}
							});
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							iom.setResponseMessage(new ErrorModel() {
								
								@Override
								public String getMessage() {
									
									return "Wrong wrong wrong";
								}
								
								@Override
								public int getCode() {
									
									return 404;
								}
							});
						}
					}
						
	
					if (jsonRequest.has("TSOFEN")) {
						User userTsofen = null;
						userIdToValidate = jsonRequest.get("TSOFEN").getAsInt();
						try {
							userTsofen = iom.getDataAccess().getUser(userIdToValidate);
						} catch (SQLException e) {
							iom.setResponseMessage(new ErrorModel() {
								
								@Override
								public String getMessage() {
									
									return "Tsofen member does not exist.";
								}
								
								@Override
								public int getCode() {
									
									return 404;
								}
							});
						}
						Mentee menteeToCheck = null;
						try {
							menteeToCheck = (Mentee) iom.getDataAccess().getUser(Integer.parseInt(id));
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(menteeToCheck!=null ){
							if(userTsofen!=null) {
								isValid = true;
							}
						}else {
							iom.setResponseMessage(new ErrorModel() {
								
								@Override
								public String getMessage() {
									
									return "Invalid file id";
								}
								
								@Override
								public int getCode() {
									
									return 404;
								}
							});
						}
					}
						
					
			}

			try {
				if (isValid) {
					if (jsonRequest.has("img") && jsonRequest.get("img").getAsString() != null) {
						if (!ClientDownloadFile.downloadFile(id, ClientDownloadFile.PIC_BUCKET, response)) {
							ClientDownloadFile.downloadFile("defaultImage", ClientDownloadFile.PIC_BUCKET, response);
							iom.getDataAccess().closeConnection();
						}
					}

					if (jsonRequest.has("cv") && jsonRequest.get("cv").getAsString() != null) {
						if(isDoc) {
							//bringing back the docx.
							id+=".docx";
						}
						if(!ClientDownloadFile.downloadFile(id, ClientDownloadFile.CV_BUCKET, response)) {
							iom.setResponseMessage(new ErrorModel() {
								
								@Override
								public String getMessage() {
									
									return "CV does not exist in DB for this user.";
								}
								
								@Override
								public int getCode() {
									
									return 404;
								}
							});
							if(iom!=null)
							iom.SendJsonResponse();
						}
				
					}

					if (jsonRequest.has("grade") && jsonRequest.get("grade").getAsString() != null) {
						boolean flag =ClientDownloadFile.downloadFile(id, ClientDownloadFile.GRADE_BUCKET, response);
						System.out.println(flag);
						if(!flag) {
							iom.setResponseMessage(new ErrorModel() {
								
								@Override
								public String getMessage() {
									
									return "Gradesheet does not exist in DB for this user.";
								}
								
								@Override
								public int getCode() {
									
									return 404;
								}
							});
							if(iom!=null)
							iom.SendJsonResponse();
						}
						
					}

				} else {

					if (jsonRequest.has("img")) {

						ClientDownloadFile.downloadFile("defaultImage", ClientDownloadFile.PIC_BUCKET, response);
						iom.getDataAccess().closeConnection();
					}

					if (jsonRequest.has("cv")) {
						if(iom!=null)
						iom.SendJsonResponse();
					}

					if (jsonRequest.has("grade")) {
						if(iom!=null)
						iom.SendJsonResponse();
					}

				}
			} catch (NumberFormatException | SQLException e) {

				e.printStackTrace();
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.GENERAL_ERROR));
				if(iom!=null)
				iom.SendJsonResponse();
			}
		}
		}catch (Exception e) {
			// TODO: handle exception
			iom.setResponseMessage(new ErrorModel() {
				
				@Override
				public String getMessage() {
					// TODO Auto-generated method stub
					return "Something is wrong ;/";
				}
				
				@Override
				public int getCode() {
					// TODO Auto-generated method stub
					return 404;
				}
			});
			if(iom!=null)
			iom.SendJsonResponse();
		}
		finally {
			if(iom!=null)
				iom.closeConnection();
		}
	}

}
