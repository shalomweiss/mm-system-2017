package mm.androidservice;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import mm.constants.Constants;
import mm.da.DataAccess;
import mm.da.DataInterface;
import mm.jsonModel.JsonUser;
import mm.model.Mentee;
import mm.model.Mentor;
import mm.model.Session;
import mm.model.User;
import mm.model.User.userType;
import util.ServerUtils;


/**
 * Servlet implementation class UpdateProfileTest
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		AndroidIOManager iom = new AndroidIOManager(request,response);	
		

		try{
			JsonObject myJson = iom.getJsonRequest();
			
			int id =  (myJson.get("id").isJsonNull() ? 0 : myJson.get("id").getAsInt());
			String token = myJson.get("token").getAsString();
								
			User originalUser = null;
			User sendToDB = new User();
		
		
				try {
					originalUser=iom.getDataAccess().getUser(id);
					System.out.println(originalUser.toString());
				
					
					if( originalUser instanceof Mentee) {
						
						Mentee updatedMentee=new Gson().fromJson(myJson.get("user").getAsJsonObject(), Mentee.class);
						
						updatedMentee.setId(id);
						 updatedMentee.setType(originalUser.getType());
						 
						if(updatedMentee.getFirstName()==(null)) updatedMentee.setFirstName(originalUser.getFirstName());
						if(updatedMentee.getLastName()==(null)) updatedMentee.setLastName(originalUser.getLastName());
						if(updatedMentee.getPhoneNumber()==(null)) updatedMentee.setPhoneNumber(originalUser.getPhoneNumber());
						if(updatedMentee.getGender()!=originalUser.getGender()) updatedMentee.setGender(originalUser.getGender());
						if(updatedMentee.getAddress()==(null)) updatedMentee.setAddress(originalUser.getAddress());
						if(updatedMentee.getNote()==(null)) {System.out.println("note == null"); updatedMentee.setNote(originalUser.getNote());}
						if(updatedMentee.getProfilePicture()==(null)) updatedMentee.setProfilePicture(originalUser.getProfilePicture());
						if(updatedMentee.getEmail()==(null)) updatedMentee.setEmail(originalUser.getEmail());
						
						
						if(updatedMentee.getRemainingSemesters()<=0) updatedMentee.setRemainingSemesters(((Mentee) originalUser).getRemainingSemesters());
						if(updatedMentee.getGraduationStatus()==(null)) updatedMentee.setGraduationStatus(((Mentee) originalUser).getGraduationStatus());
						if(updatedMentee.getAcademiclnstitution()<=0) updatedMentee.setAcademiclnstitution(((Mentee) originalUser).getAcademiclnstitution());
						if(updatedMentee.getAverage()<=0) updatedMentee.setAverage(((Mentee) originalUser).getAverage());
						if(updatedMentee.getRemainingSemesters()<=0) updatedMentee.setRemainingSemesters(((Mentee) originalUser).getRemainingSemesters());
						if(updatedMentee.getAcademicDicipline()==(null)) updatedMentee.setAcademicDicipline(((Mentee) originalUser).getAcademicDicipline());
						if(updatedMentee.getAcademicDicipline2()==(null)) updatedMentee.setAcademicDicipline2(((Mentee) originalUser).getAcademicDicipline2());
						if(updatedMentee.getResume()==(null)) updatedMentee.setResume(((Mentee) originalUser).getResume());
						if(updatedMentee.getGradeSheet()==(null)) updatedMentee.setGradeSheet(((Mentee) originalUser).getGradeSheet());
						
						sendToDB=updatedMentee;
					
					}
					else if(originalUser instanceof Mentor) {
						
						Mentor updatedMentor=new Gson().fromJson(myJson.get("user").getAsJsonObject(), Mentor.class);
					 
						updatedMentor.setId(id);
					    updatedMentor.setType(originalUser.getType());
					    
						if(updatedMentor.getFirstName()==(null)) updatedMentor.setFirstName(originalUser.getFirstName());
						if(updatedMentor.getLastName()==(null)) updatedMentor.setLastName(originalUser.getLastName());
						if(updatedMentor.getPhoneNumber()==(null)) updatedMentor.setPhoneNumber(originalUser.getPhoneNumber());
						if(updatedMentor.getGender()!=originalUser.getGender()) updatedMentor.setGender(originalUser.getGender());
						if(updatedMentor.getAddress()==(null)) updatedMentor.setAddress(originalUser.getAddress());
						if(updatedMentor.getNote()==(null)) updatedMentor.setNote(originalUser.getNote());
						if(updatedMentor.getProfilePicture()==(null)) updatedMentor.setProfilePicture(originalUser.getProfilePicture());
						if(updatedMentor.getEmail()==(null)) updatedMentor.setEmail(originalUser.getEmail());
						
						
						if(updatedMentor.getExperience()==(null)) updatedMentor.setExperience(((Mentor) originalUser).getExperience());
						if(updatedMentor.getRole()==(null)) updatedMentor.setRole(((Mentor) originalUser).getRole());
						if(updatedMentor.getCompany()<=0) updatedMentor.setCompany(((Mentor) originalUser).getCompany());
						if(updatedMentor.getVolunteering()==(null)) updatedMentor.setVolunteering(((Mentor) originalUser).getVolunteering());
						if(updatedMentor.getWorkHistory()==(null)) updatedMentor.setWorkHistory(((Mentor) originalUser).getWorkHistory());
						
						sendToDB=updatedMentor;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
				}

			
			
			
					
				if(ServerUtils.validateUserSession(id, token, iom.getDataAccess())) {
					try {	
						User temp=null;
					
						//Sending user updated info to database
						if(originalUser instanceof Mentee) {
							temp =(Mentee)originalUser;
							System.out.println("Mentee"+sendToDB.toString());
							
						}
						if(originalUser instanceof Mentor) {
							temp =(Mentor)originalUser;
							System.out.println("Mentor"+sendToDB.toString());
						}
						
						if(
								iom.getDataAccess().editUser(sendToDB)
						) {
							//success
							iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
					
							
						}else {
							//failed

							iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
						}
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
					}
							
					
				}else {
	
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.INVALID_SESSION));
				}
				}catch(NullPointerException ex){
             iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
     }catch(Exception e){
             iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.GENERAL_ERROR));
     }finally{
             iom.SendJsonResponse();
     }
		
		
			
			}
			
			

	}
	
	

