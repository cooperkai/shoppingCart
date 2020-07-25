package com.cooper.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;

public class TrimForOracleLength {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "用MemberID取得CRM會員資料失敗[sourceSystem:CRM_SYSTEM, memberID:12w]";
		byte[] dataByte = null;
		try {
			dataByte = str.getBytes("UTF-8");
		} catch (Throwable e) {
			System.out.println("傳入字串轉成Big5編碼的byte array 失敗 ");
		}
//		String tmp = new String(dataByte, 0, dataByte.length, "UTF-8");
//		boolean isChinese;
//		System.out.println(tmp.length());
//		for (int i = 0; i < tmp.length(); i++) {
//			isChinese = isChineseCharacter(tmp.charAt(i));
//			System.out.println(tmp.charAt(i) + " : " + isChinese);
//		}
//		byte[] result = new byte[str.length()];
//		for (int i = 0; i < dataByte.length; i++) {
//			byte[] temp = new byte[str.length()];
//			int keep = i;
//			if (dataByte[i] < 0 && keep == i) {
//				temp[0] = dataByte[i];
//				keep += 2;
//			} else if (keep < i) {
//				temp[1] = dataByte[i];
//				keep -= 1;
//			} else if (keep < i) {
//				temp[2] = dataByte[i];
//			}
//			System.out.println(new String (temp, "UTF-8"));
//		}
		
		int result = count(str);
		System.out.println(result);
//		if (10 <= result) {
//			System.out.println(str);
//		} else {
			System.out.println(StringUtils.substring(str, 0, 25));
//		}
	}

	public static boolean isChineseCharacter(char c) {
		return (19968 <= (int) c) && ((int) c <= 171941);
	}
	
	public static int count(String aaa) throws UnsupportedEncodingException {
		int result = 0;
		for(char word : aaa.toCharArray()) {
			result += new String(new char[]{word}).getBytes("UTF-8").length;
		}
		return result;
	}
}
