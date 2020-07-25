package com.cooper.util;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.text.html.parser.Entity;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PostJson {
	public static void main(String[] args) {
		try {
			String token = (String) test2().get("access_token");
			
			JSONObject req = new JSONObject();
			req.put("memberId", "123");
			req.put("lineuid", "213");
			
			String url = "http://localhost:8082/crm/system/syncAIMCRM";
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost(url);
			request.addHeader("Content-Type", "application/json");
			request.addHeader("Authorization", "Bearer " + token);
			request.setEntity(new StringEntity(req.toString()));
			HttpResponse response = httpClient.execute(request);
			
			// 請求返回的數據
			InputStream in = response.getEntity().getContent();
			String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
//			JSONObject jsonObject = new JSONObject(result);
			in.close();
			
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	public static JSONObject test() throws Exception {
//		HttpClient httpClient = HttpClientBuilder.create().build();
//		HttpPost request = new HttpPost("http://localhost:8082/crm/customer/getMmCard");
//		trustAllSite();
//		String authString = "Bearer " + "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ0QXU2N2dibTlIeEFVLVROQmtsOGtBN0ZQeHBnbjA3NmlFM0pEX3Eta0ZjIn0.eyJqdGkiOiI0NWVkMTVlNC04YmIxLTQ3MmMtYjBjNS1iMDg5ZWVjNzNiMTEiLCJleHAiOjE1NjgxOTI0NTMsIm5iZiI6MCwiaWF0IjoxNTY3NTg3NjUzLCJpc3MiOiJodHRwczovL2F1dGhzaXQudGVzdHJpdGVncm91cC5jb20vYXV0aC9yZWFsbXMvdGVzdHJpdGVncm91cC1jdXN0b21lciIsImF1ZCI6ImNybS1hcGkiLCJzdWIiOiJmOjNkMzAwZmNiLWRhOTctNGRlZS1iODE3LWEyNTVkOGNjMDgxMDowOTM4MDQyMDg5IiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiY3JtLWFwaSIsImF1dGhfdGltZSI6MCwic2Vzc2lvbl9zdGF0ZSI6IjhlODVmYjYwLWQ0NWUtNDM1ZC04MGEzLTRiOTdiMTY3ODJjZSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiUk9MRV9DVVNUT01FUiIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwiaXNwYXNzd29yZG1vZGlmeSI6IlkiLCJDTEFJTVMiOiJ7XCJNTV9DQVJEXCI6W3tcImNoYW5uZWxJZFwiOlwiSFFcIixcImNvbXBhbnlJZFwiOlwiMTAxMFwiLFwiY2FyZFR5cGVcIjpudWxsLFwibWVtYmVySWRcIjpudWxsLFwidmlwTm9cIjpcIjI5OTIwODYxNzQwMTFcIixcInN0YXR1c1wiOm51bGwsXCJjYXJkSWRcIjpudWxsLFwiY2FyZFNjb3JlXCI6bnVsbCxcImFjY1R5cGVcIjpudWxsfV0sXCJBUFBfQ09NUEFOWVwiOltcIjEwMTBcIl0sXCJBUFBfQ0hBTk5FTDJcIjpbXCJHMFwiLFwiQ0FTQVwiLFwiSE9MQVwiLFwiVExXXCIsXCJIUVwiLFwiUzBcIl0sXCJBUFBfQ0hBTk5FTDFcIjpbXCJIUVwiLFwiUzBcIixcIkcwXCIsXCJIT0xBXCIsXCJUTFdcIl19IiwiTUVNQkVSX0lEIjoiMjAxOTA4MjAwMDAwMDEiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiIwOTM4MDQyMDg5In0.kZFjlL5pf4uf9DDtdw1EFITmcSNBm36EGwxYZv8Zg95VpEhzLuMF7JPnmuELoFp7KYLtqUNIDt6lhxCRXkwB1JTDzwR_Od-vDHODG6VYEyueiu476IHdQppTm5Uzh7GpveHJ4s81BXbib5_qiPAFrw-sIvYVwf5q7DCFbzeAmYUTJbH46TecyJEsCyTpCqPYiqGB--mlr4rxRGQTBSZi3Bu60P3oDXQ6QIyGNqglmkBrMTFrIyiwVeYDeO2E8LPA1rm25o_l3s_nl3Lw-JlxkKhtzn_YgaK_WPpJ2c0sXXsmSKdh-Fpr7Mjyo03tJn6jzH8KxVHUmUQpCgMrTeM6Ww";
//	    request.addHeader("content-type", "application/json; charset=UTF-8");
//	    request.addHeader("Authorization", authString);
		HttpClient httpClient = HttpClientBuilder.create().build();
		String a = URLEncoder.encode("213213 214214");
	    StringBuilder builder = new StringBuilder();
		builder.append("https://uatbe.trplus.com.tw/rest/v2/trplus/sendPOSContact?type=newq5e&name=test&email=test@gmil.com&tel=0989392833&posCode=00700")
		.append("&description=" + a)
		.append("&site=trplus");
		HttpPost request = new HttpPost(builder.toString());
		trustAllSite();
		request.addHeader("content-type", "application/x-www-form-urlencoded");
		HttpResponse response = httpClient.execute(request);
		
		// 請求返回的數據
		InputStream in = response.getEntity().getContent();
		String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
		JSONObject jsonObject = new JSONObject(result);
		in.close();
//	    HttpResponse response = httpClient.execute(request);
		
//		JSONObject jsonObject = new JSONObject();
//			// 請求返回的數據
//			try {
//				InputStream in = response.getEntity().getContent();
//				String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
//				jsonObject = new JSONObject(result);
//				JSONArray a = jsonObject.getJSONArray("data");
//				for (int i = 0; i < a.length(); i++) {
//					JSONObject rec = a.getJSONObject(i);
//					String vipNo = rec.optString("vipNo");
//					System.out.println(vipNo);
//				}
//				
//				in.close();
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}

		return jsonObject;
	}
	
	@SuppressWarnings("rawtypes")
	public static JSONObject test2() throws Exception {
		String url = "https://authsit.testritegroup.com/auth/realms/testritegroup-employee/protocol/openid-connect/token";
//		String body = "client_id=tmshoi-api&password=Aa123456&username=line-system&grant_type=password&client_secret=5431f438-f730-43ce-b7d7-b8e25a7203da";
//		
//		HttpClient httpClient = HttpClientBuilder.create().build();
//		HttpPost request = new HttpPost(url);
//		request.addHeader("content-type", "application/x-www-form-urlencoded");
//		request.setEntity(new StringEntity(body));
//		HttpResponse response = httpClient.execute(request);
//		
//		// 請求返回的數據
//		InputStream in = response.getEntity().getContent();
//		String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
//		JSONObject jsonObject = new JSONObject(result);
//		String token = (String) jsonObject.get("access_token");
//		in.close();
		
		List<NameValuePair> reqParams = new ArrayList<NameValuePair>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("client_id", "tmshoi-api");
		map.put("password", "Aa123456");
		map.put("username", "line-system");
		map.put("grant_type", "password");
		map.put("client_secret", "5431f438-f730-43ce-b7d7-b8e25a7203da");
 		
 		for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
 			Map.Entry mapEntry = (Map.Entry) it.next();
 			reqParams.add(new BasicNameValuePair(mapEntry.getKey().toString(), mapEntry.getValue().toString()));
 		}
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		request.addHeader("content-type", "application/x-www-form-urlencoded");
		request.setEntity(new UrlEncodedFormEntity(reqParams , "UTF-8"));
		HttpResponse response = httpClient.execute(request);
		
		// 請求返回的數據
		InputStream in = response.getEntity().getContent();
		String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
		JSONObject jsonObject = new JSONObject(result);
		System.out.println("jsonObject" + jsonObject);
		in.close();
		return jsonObject;
	}
	
	private static boolean isTrustAll = false;
	public static void trustAllSite() throws Exception {
		if (!isTrustAll) {
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				}
			} };

			// Install the all-trusting trust manager
			try {
//				logger.info("Install trust site!!!");
				SSLContext sc = SSLContext.getInstance("SSL");
				sc.init(null, trustAllCerts, new java.security.SecureRandom());
				HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			} catch (Exception e) {
//				logger.error(e.toString());
				throw e;
			}
			isTrustAll = true;
		}
	}
}
