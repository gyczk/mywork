package httpclient;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClient {
	
	@Test
	public void c1() throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:8080/mywork/customer/c1.action");
		File file = new File("d:\\edit.jsp");
		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
		 multipartEntityBuilder.addBinaryBody("file",file);
		 HttpEntity httpEntity = multipartEntityBuilder.build();
		 httpPost.setEntity(httpEntity);
		 CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		 httpResponse.getEntity().writeTo(System.out);
		 httpResponse.close();
		 
		
		
		
		
	}
	/**
	 * form表单提交
	 * @throws IOException 
	 */
	@Test
	public void c2() throws IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:8080/mywork/customer/c2.action");
		
		
		 List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("name", "lisi")); 
		formparams.add(new BasicNameValuePair("sex", "male")); 
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams,Consts.UTF_8); 
		System.out.println(EntityUtils.toString(entity));
//		HttpPost httppost = new HttpPost("http://localhost/handler.do");
		httpPost.setEntity(entity);
		 CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		 httpResponse.getEntity().writeTo(System.out);
		 httpResponse.close();
		
		
	}
}
