package mm.androidservice.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import mm.androidservice.common.JsonKeyMapper;

public class ClientDownloadFile {

	private ClientDownloadFile() {
	}

	public final static String PIC_BUCKET = "tsofenpic";
	public final static String CV_BUCKET = "tsofencv";
	public final static String GRADE_BUCKET = "tsofengrade";

	private static final  String awsId = JsonKeyMapper.ID;

	private static final  String awsKey = JsonKeyMapper.KEY;

	/**
	 * key is User's id, bucketName file location, include response
	 * @param key
	 * @param bucketName
	 * @param response
	 */
	public static boolean downloadFile(String key, String bucketName, HttpServletResponse response) {

		AmazonS3 s3Client = s3client();
		File file = null;
	
		try {
			System.out.println("Downloading an object");
			S3Object s3object = s3Client.getObject(new GetObjectRequest(bucketName, key));
			
			
			
			
			String contentType = s3object.getObjectMetadata().getContentType();
	
			
			
			response.setContentType(contentType);

			// response.setHeader(arg0, arg1);

			if (bucketName.equals(PIC_BUCKET)) {
				if (contentType.equals("image/png"))
					file = File.createTempFile("img", ".png");
				if (contentType.equals("image/jpeg"))
					file = File.createTempFile("img", ".jpg");
			} else if (bucketName.equals(CV_BUCKET)) {
				if (contentType.equals("text/plain"))
					file = File.createTempFile("cvtodownload", ".txt");
				if (contentType.equals("application/pdf"))
					file = File.createTempFile("cvtodownload", ".pdf");
				if (contentType.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
					file = File.createTempFile("cvtodownload", ".docx");
				}
		
			

			} else if (bucketName.equals(GRADE_BUCKET)) {
				if (contentType.equals("application/pdf"))
					file = File.createTempFile("gradetodownload", ".pdf");

			}

		      InputStream initialStream = s3object.getObjectContent();
      	    
		    
		  	    java.nio.file.Files.copy(
		        	      initialStream, 
		        	      file.toPath(), 
		        	      StandardCopyOption.REPLACE_EXISTING);
		      
      
      	 
      	    IOUtils.closeQuietly(initialStream);
      
//      	    System.out.println(file.getName());
			// This should send the file to browser
			OutputStream out = response.getOutputStream();
			FileInputStream in = new FileInputStream(file);
			byte[] buffer = new byte[4096];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			in.close();
			out.flush();

		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which" + " means your request made it "
					+ "to Amazon S3, but was rejected with an error response" + " for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
			if(ase.getErrorCode().equals("NoSuchKey")) {
				return false;
			}
				
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which means" + " the client encountered "
					+ "an internal error while trying to " + "communicate with S3, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}finally {
			if(file!=null)
			file.deleteOnExit();
		}
			return true;
	}

	private static AmazonS3 s3client() {

		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2)
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

		return s3Client;
	}

}
