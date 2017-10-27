package mm.androidservice.upload;

import java.io.File;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

import mm.androidservice.common.JsonKeyMapper;


public class ClientUploadFile {

	public final static String PIC_BUCKET     = "tsofenpic";
	public final static String CV_BUCKET     = "tsofencv";
	public final static String GRADE_BUCKET     = "tsofengrade";
	

	private static final  String awsId = JsonKeyMapper.ID;

	private static final  String awsKey = JsonKeyMapper.KEY;
	
	
	private ClientUploadFile(){}

	/**
	 * Use UploadFile.BucketName
	 * @param keyName
	 * @param filePathToUpload
	 * @param BUCKET_NAME
	 */
	public static void uploadFile(String keyName,File fileToUpload,String BUCKET_NAME) {
		
		

        AmazonS3 s3Client = s3client(); 
        //s3Client.setRegion(Region.getRegion(Regions.US_EAST_2));
    
        // Use Amazon S3 Transfer Acceleration endpoint.           
        //s3Client.setS3ClientOptions(S3ClientOptions.builder().setAccelerateModeEnabled(true).build());
        
        try {
        	System.out.println("Uploading a new object to S3 from a file\n");
            File file = fileToUpload;
            s3Client.putObject(new PutObjectRequest(
            		BUCKET_NAME, keyName, file));

         } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
            		"means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
            		"means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }  

		
		
	}
	private static AmazonS3 s3client() {
 
   		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
   		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
   								.withRegion(Regions.US_EAST_2)
   		                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
   		                        .build();
   		
   		return s3Client;
   	}
	
	
}
