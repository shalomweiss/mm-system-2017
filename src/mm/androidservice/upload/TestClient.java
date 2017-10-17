package mm.androidservice.upload;

import java.io.File;

public class TestClient {

	public static void main(String[] args) {
		
		File fileToSend = new File("C:\\Users\\Foad\\Pictures\\tigertiger.jpg");
		//System.out.println(com.fasterxml.jackson.databind.ObjectMapper.class.getProtectionDomain().getCodeSource().getLocation());
		ClientUploadFile.uploadFile("Test", fileToSend, ClientUploadFile.PIC_BUCKET);

	}

}
