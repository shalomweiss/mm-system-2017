
package mm.androidservice;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import mm.da.DataAccess;
import mm.da.DataInterface;
import util.ServerUtils;


public class AndroidIOManager {
	

	private DataInterface da;
	private Map<String,Object> responseMap;
	private JsonObject requestObject;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	public AndroidIOManager(HttpServletResponse response) throws IOException {
		this.da = new DataAccess();
		this.responseMap = new HashMap<String,Object>();
		this.response=response;
	}

	public AndroidIOManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.da = new DataAccess();
		this.responseMap = new HashMap<String,Object>();
		this.request=request;
		this.response=response;
		this.requestObject=ServerUtils.getJsonObjectFromRequest(request);
	}
       

	
	
	public DataInterface getDataAccess() {
		return this.da;
	}
	
	public Map<String, Object> getResponseMap() {
		return this.responseMap;
	}
	
	public void setResponseMessage(ErrorModel em) {
		responseMap.put("code", em.getCode());
		responseMap.put("message", em.getMessage());
	}
	
	public boolean addResponseParameter(String key,Object value) {
		if(key!=null && value!=null) {
		responseMap.put(key, value);
		return true;
		}
		else {
			return false;
		}
	}
	
	public JsonObject getJsonRequest() {
		return this.requestObject;
	}
	
	
	
	/**
	 * Remove Key and value
	 */
	public void removeResponseParameter(String key,Object value) {
		responseMap.remove(key, value);
	}
	
	
	
	public void SendJsonResponse() throws IOException {
		
		if(da!=null) {
			try {
				da.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ServerUtils.respondJsonMap(response, this.responseMap);
	}
	
	public void closeConnection() {
		if(da!=null) {
			try {
				da.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
