package com.courage.platform.store.delay.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class HttpsRequestUtils {  
	private static Logger logger = LoggerFactory.getLogger(HttpsRequestUtils.class);
  
	public static class MyX509TrustManager implements X509TrustManager {  
		  
	    @Override  
	    public void checkClientTrusted(X509Certificate certificates[],String authType) throws CertificateException {  
	    }  
	  
	    @Override  
	    public void checkServerTrusted(X509Certificate[] ax509certificate,String s) throws CertificateException {  
	    }  
	  
	    @Override  
	    public X509Certificate[] getAcceptedIssuers() {  
	        // TODO Auto-generated method stub  
	        return null;  
	    }  
	}  
	static {
		try {
			SSLContext sslcontext = SSLContext.getInstance("SSL","SunJSSE");
	        sslcontext.init(null, new TrustManager[]{new MyX509TrustManager()}, new java.security.SecureRandom());  	        
	        HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {  
	            public boolean verify(String s, SSLSession sslsession) {  
	            	logger.warn("WARNING: Hostname is not matched for cert.");  
	                return true;  
	            }  
	        };
	        HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);
	        HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());  
		} catch (Exception e) {
			logger.error("Http",e);
		} 
	}
	
	public static HttpsURLConnection getHttpsURLConnection(URL url) throws IOException {
		return (HttpsURLConnection)url.openConnection();
	}
} 
