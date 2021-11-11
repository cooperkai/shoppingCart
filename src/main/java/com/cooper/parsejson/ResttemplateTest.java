package com.cooper.parsejson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 
 *
 */
public class ResttemplateTest {

	private static final Logger log = LoggerFactory.getLogger(ResttemplateTest.class);

	public static void main(String[] args) throws IOException {
		String url = "https://apiuat.testritegroup.com/loyalty-empapi/loyalty/employee/appQueryPayCardNo";

		List<String> li = new ArrayList<>();
		li.add("202102010000012");

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("memberList", li);

		JSONObject json = new JSONObject();
		json.put("memberList", li);

		try {
//			ResponseEntity<String> res = callTestritePostTemplete(url, paramMap);
//			log.info(res.getBody());

			ResponseEntity<String> resj = callTestritePostTemplete(url, json);
			log.info(resj.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
//
//	public static ResponseEntity<String> callTestritePostTemplete(String url, Map<String, Object> paramMap) {
//		String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI5djQzY2dmY3pYeGtNelFxUWsxZjFnaE9PRzNLNnVkaWdfQzlxLUV6MTVNIn0.eyJleHAiOjE2MTYxNDg2MDIsImlhdCI6MTYxNjE0NTAwMiwianRpIjoiNjllZGMxYTEtNGM4ZC00OGQ4LTk1YjgtOGEyM2U2ZWU4NTM0IiwiaXNzIjoiaHR0cHM6Ly9hdXRoZW1wc2l0MDIudGVzdHJpdGVncm91cC5jb20vYXV0aC9yZWFsbXMvdGVzdHJpdGVncm91cC1lbXBsb3llZSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI2ZmY5YWY2ZS05YzhhLTQ4MWUtODNhYS02Y2UxNDcwZGU3ZGMiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJhaW0tYXBpIiwic2Vzc2lvbl9zdGF0ZSI6Ijg1ZjQxODEyLTE3MGYtNDdkMS04ZmE3LWE0NTg3ZWYxMzA3MSIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsIlJPTEVfRU1QTE9ZRUUiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6InQzMDY1In0.ZNa4ND3Ip4XBvnOINGsVhqz4FK_DJa9CnNnN8uSXhTrBr5dcxz3mExUY3CxdTPCLCzf25znrA0xXF4lBlzlUS0plAQ1q9Y6TzIh4K7_x8hmjUTNg2bjQqA5GJn_hRaypdwtKWX4bdMdMUhiIELfaG5lxhh--CMRbZClaKj-8owZqaB1438_8rri6Z-F9txwDaePeF_5540bWrNM1jPbxnPqOajOGuAhcgV5EYJH6kB6DqPBFV5ACcPPkLAmxOCvbwC_GZtQkbjzGlMJP6tXv6xndOoJTWVu3z8K7Kcm4IFZVLS6gFedpOoDB5ryyqGeYLmQ7xpW-20q8KrrM7xwLwA";
//
//		HttpHeaders headers = new HttpHeaders();
//		// set content-type header
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		headers.add("Authorization", "Bearer " + token);
//		// set accept header 中文編碼
//		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
//		headers.setAccept(Collections.singletonList(type));
//
//		// build the request
//		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(paramMap, headers);
//
//		// send POST request
//		RestTemplate template = new RestTemplate();
//		return template.postForEntity(url, entity, String.class);
//	}

	public static ResponseEntity<String> callTestritePostTemplete(String url, JSONObject json) {
		String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI5djQzY2dmY3pYeGtNelFxUWsxZjFnaE9PRzNLNnVkaWdfQzlxLUV6MTVNIn0.eyJleHAiOjE2MTYxNDg2MDIsImlhdCI6MTYxNjE0NTAwMiwianRpIjoiNjllZGMxYTEtNGM4ZC00OGQ4LTk1YjgtOGEyM2U2ZWU4NTM0IiwiaXNzIjoiaHR0cHM6Ly9hdXRoZW1wc2l0MDIudGVzdHJpdGVncm91cC5jb20vYXV0aC9yZWFsbXMvdGVzdHJpdGVncm91cC1lbXBsb3llZSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI2ZmY5YWY2ZS05YzhhLTQ4MWUtODNhYS02Y2UxNDcwZGU3ZGMiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJhaW0tYXBpIiwic2Vzc2lvbl9zdGF0ZSI6Ijg1ZjQxODEyLTE3MGYtNDdkMS04ZmE3LWE0NTg3ZWYxMzA3MSIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsIlJPTEVfRU1QTE9ZRUUiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6InQzMDY1In0.ZNa4ND3Ip4XBvnOINGsVhqz4FK_DJa9CnNnN8uSXhTrBr5dcxz3mExUY3CxdTPCLCzf25znrA0xXF4lBlzlUS0plAQ1q9Y6TzIh4K7_x8hmjUTNg2bjQqA5GJn_hRaypdwtKWX4bdMdMUhiIELfaG5lxhh--CMRbZClaKj-8owZqaB1438_8rri6Z-F9txwDaePeF_5540bWrNM1jPbxnPqOajOGuAhcgV5EYJH6kB6DqPBFV5ACcPPkLAmxOCvbwC_GZtQkbjzGlMJP6tXv6xndOoJTWVu3z8K7Kcm4IFZVLS6gFedpOoDB5ryyqGeYLmQ7xpW-20q8KrrM7xwLwA";

		HttpHeaders headers = new HttpHeaders();
		// set content-type header
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer " + token);
		// set accept header 中文編碼
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setAccept(Collections.singletonList(type));

		// build the request
		HttpEntity<String> entity = new HttpEntity<>(json.toString(), headers);

		// send POST request
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());

		return restTemplate.postForEntity(url, entity, String.class);
	}

	private static ClientHttpRequestFactory getClientHttpRequestFactory() {
		int timeout = 100;
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(timeout);
		return clientHttpRequestFactory;
	}

}
