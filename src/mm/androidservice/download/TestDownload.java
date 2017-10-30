package mm.androidservice.download;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TestDownload {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
		  .url("http://localhost:8080/mm-database-2017/DownloadFile")
		  .post(null)
		  .addHeader("id", "5491")
		  .addHeader("type", "img")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("postman-token", "981c7040-f406-bfbe-77ad-5ce7e83a1f24")
		  .build();

		Response response = client.newCall(request).execute();
		

	}

}
