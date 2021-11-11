package com.cooper.exception;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionTest {
	
	private static final Logger log = LoggerFactory.getLogger(ExceptionTest.class);

	public static void finallyOverridesTryException() throws IOException {
		FileOutputStream fileOutStream = null;
		try {
			fileOutStream = new FileOutputStream(new File("../電子錢包合併卡號_系統分析書.pdf"));
			throw new IOException("Function failure");
		} finally {
			try {
				fileOutStream = null;
				fileOutStream.close();
			} catch (Exception e) {
				// log起來就不會蓋掉上面try拋出的exception
				log.error(e.getMessage(), e);
				// throw e;
			}
		}
	}
	
	public static void UnhandleException () {
		try {
			String a = null;
			a.toString();
		} catch (CustomException e) {
			throw e;
		}
	}
	
	public class CustomException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public CustomException(Exception e) {
			super(e);
		}
	}

	public static void main(String[] args) {
		try {
//			finallyOverridesTryException();
			List<String> list = new ArrayList<>();
			while(true){
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
				list.add("");
			}
//			UnhandleException();
		} catch (Exception e) {
			// 在原先try拋出的exception會被finally裡面的exception蓋掉
			// 所以在finally的exception可以log起來
			e.printStackTrace();
		}

	}

}
