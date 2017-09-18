package org.MM.model;


/**
 * A simple bean to hold data
 */
public class SendMessage {
	private boolean Sucsses,Failure,Error ;
	String resusername,password;
	 

	 public SendMessage()
	    {
	    
	    }
   public SendMessage(String user,String pass)
	    {
	    	this.resusername=user;
	    	this.password=pass;
	    }

	 
	
    public SendMessage(boolean s,boolean f,boolean error)
    {
    	this.Sucsses=s;
    	this.Failure=f;
    	this.Error=error;
    }

	
    public void setFailure(boolean fl) {
		this.Failure=fl;
	}
	
	public void setSucsees(boolean Sucsses) {
		this.Sucsses=Sucsses;
	}
	
	public void setError(boolean error) {
		this.Error=error;
	}
	public void setUser(String user) {
		this.resusername=user;
	}
	public void setPass(String pass) {
		this.password=pass;
	}
	 public boolean getFailure() {
			return Failure;
	 }
	 public boolean getSucsses() {
			return Sucsses;
	 }
	 public boolean getError() {
			return Error;
	 }
	 public String getUser() {
			return resusername;
	 }
	 public String getPass() {
			return password;
	 }		
		
				    
	
	
	  //type json
	 public String toString() {
         return "BufferSend [Sucsses=" + Sucsses + ", Failure=" + Failure+ ", error=" +Error+"]";
 }

}
