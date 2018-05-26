package org.alcoseba.soapxmlupload;

import java.io.File;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.FileRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

public class App {
	public static void main(String[] args) {
		String url = "";
		PostMethod post = new PostMethod(url);
		File input = new File("");
		RequestEntity entity = new FileRequestEntity(input, "text/xml; charset=ISO-8859-1");
		post.setRequestEntity(entity);
		post.setRequestHeader("SOAPAction", "");

		try {
			HttpClient httpclient = new HttpClient();
			int result = httpclient.executeMethod(post);
			System.out.println("Response status code : " + result);
			System.out.println("Response body: ");
			System.out.println(post.getResponseBodyAsString());
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			post.releaseConnection();
		}
	}
}
