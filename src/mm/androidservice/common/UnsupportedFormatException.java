package mm.androidservice.common;

public class UnsupportedFormatException extends Exception{

	  public UnsupportedFormatException(String message) {
	        super(message);
	    }
	
	  
	  public static void invalidFormat(String message) throws UnsupportedFormatException {
		  
		  throw new UnsupportedFormatException(message);
		  
	  }
	  
}
