package com.cooper.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.time.DateFormatUtils;

public class ExportCsv {
	public static void main(String args[]) {
		exportCsv();
	}

	static void exportCsv() {
		List<String> dataList = new ArrayList<String>();

		List<People> dataList2 = new ArrayList<People>();
		People people = new People();
		people.setCompanyId("1010");
		people.setChannelId("TLW");
		people.setMemberId("20090201000423");
		people.setLineId("");
		people.setCreateTime(new Date());
		people.setCreator("LIFF");
		people.setModifyTime(new Date());
		people.setModifier("AIM");
		people.setIsfollow("Y");

		People people2 = new People();
		people2.setCompanyId("1010");
		people2.setChannelId("TLW");
		people2.setMemberId("1111111111111");
		people2.setLineId("");
		people2.setCreateTime(new Date());
		people2.setCreator("LIFF");
		people2.setModifyTime(new Date());
		people2.setModifier("AIM");
		people2.setIsfollow("Y");
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				dataList2.add(people);
			} else {
				dataList2.add(people2);
			}
		}

		for (People p : dataList2) {
			dataList.add(p.toCsvRow2());
		}

		long timeTemp1 = System.currentTimeMillis();
		String recordAsCsv = dataList2.stream().map(People::toCsvRow)
				.collect(Collectors.joining(System.getProperty("line.separator")));
		dataList.add(recordAsCsv);

		File myDir = new File("./myDir/123.csv");
		Path p = Paths.get("./myDir/");
		if (!Files.exists(p)) {
			myDir.mkdir();
		}
		boolean isSuccess = exportCsv(myDir, dataList);
		long timeTemp2 = System.currentTimeMillis();

		System.out.println("csv " + isSuccess);
		System.out.println((timeTemp2 / 1000));
		System.out.println((timeTemp1 / 1000));
		System.out.println((timeTemp2 - timeTemp1) / 1000);
	}

	public static boolean exportCsv(File file, List<String> dataList) {
		boolean isSucess = false;
		FileOutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			out = new FileOutputStream(file);
			osw = new OutputStreamWriter(out, "big5");
			bw = new BufferedWriter(osw, 100000);
			if (dataList != null && !dataList.isEmpty()) {
				for (String data : dataList) {
					bw.append(data).append("\r");
				}
			}
			isSucess = true;
		} catch (Exception e) {
			isSucess = false;
		} finally {
			if (bw != null) {
				try {
					bw.close();
					bw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (osw != null) {
				try {
					osw.close();
					osw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
					out = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return isSucess;
	}
}

class People {
	private String companyId;
	private String channelId;
	private String memberId;
	private String lineId;
	private Date createTime;
	private String creator;
	private Date modifyTime;
	private String modifier;
	private String isfollow;

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getIsfollow() {
		return isfollow;
	}

	public void setIsfollow(String isfollow) {
		this.isfollow = isfollow;
	}

	// after java7
	public String toCsvRow() {
		return Stream
				.of(companyId, channelId, memberId, lineId, DateFormatUtils.format(createTime, "yyyy/MM/dd HH:mm:ss"),
						creator, DateFormatUtils.format(modifyTime, "yyyy/MM/dd HH:mm:ss"), modifier, isfollow)
				.map(value -> value.replaceAll("\"", "\"\""))
				.map(value -> Stream.of("\"", ",").anyMatch(value::contains) ? "\"" + value + "\"" : value)
				.collect(Collectors.joining(","));
	}

	// before java8
	public String toCsvRow2() {
		String csvRow = "";
		for (String value : Arrays.asList(companyId, channelId, memberId, lineId,
				DateFormatUtils.format(createTime, "yyyy/MM/dd HH:mm:ss"), creator,
				DateFormatUtils.format(modifyTime, "yyyy/MM/dd HH:mm:ss"), modifier, isfollow)) {
			String processed = value;
			if (value.contains("\"") || value.contains(",")) {
				processed = "\"" + value.replaceAll("\"", "\"\"") + "\"";
			}
			csvRow += "," + processed;
		}
		return csvRow.substring(1);
	}
}