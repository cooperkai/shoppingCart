package com.cooper.parsejson;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 *
 */
public class DeserializeJson {

	public static void main(String[] args) throws IOException {
		// Object mapper instance
		ObjectMapper mapper = new ObjectMapper();

		// JSON input
		String a = "{\"data\":{\"memberList\":[{\"memberId\":\"20180524000031\",\"svcCardNo\":\"8048800000000001\"}]}}";
		String b = "{\"status\":\"SUCCESS\",\"message\":\"查詢成功\",\"errorCode\":\"100\",\"data\":{\"memberList\":[{\"memberId\":\"20180524000031\",\"svcCardNo\":\"8048800000000001\"},{\"memberId\":\"20180524000031\",\"svcCardNo\":\"8048800000000001\"}]}}";
		String c = "{\"status\":\"SUCCESS\",\"message\":\"查詢成功\",\"errorCode\":\"100\",\"data\":{\"memberList\":[]}}";
//		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
//		R out3 = mapper.readValue(a, R.class);
//		System.out.println(out3.toString());
		U<D> out5 = mapper.readValue(b, new TypeReference<U<D>>(){});// 正確的
		U<D> out6 = mapper.readValue(c, new TypeReference<U<D>>(){});// 正確的
		System.out.println(out5.toString());
		System.out.println(out6.toString());
	}

}

class A<T> {
	private List<T> memberList;

	public List<T> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<T> memberList) {
		this.memberList = memberList;
	}

	@Override
	public String toString() {
		return "A [memberList=" + memberList + "]";
	}
}

class D {
	private String memberId;
	private String svcCardNo;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getSvcCardNo() {
		return svcCardNo;
	}

	public void setSvcCardNo(String svcCardNo) {
		this.svcCardNo = svcCardNo;
	}

	@Override
	public String toString() {
		return "D [memberId=" + memberId + ", svcCardNo=" + svcCardNo + "]";
	}
}

class R {
	private List<A<D>> data;

	public List<A<D>> getData() {
		return data;
	}

	public void setData(List<A<D>> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "R [data=" + data + "]";
	}

}

class U<T> {
	private String errorCode;
	private String status;
	private String message;
	private A<T> data;

	public A<T> getData() {
		return data;
	}

	public void setData(A<T> data) {
		this.data = data;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}