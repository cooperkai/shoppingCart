package com.cooper.comparestring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompareString {

	private static final Logger log = LoggerFactory.getLogger(CompareString.class);

	public static void main(String[] args) {
		StringCompare s = new StringCompare(null, "1");
		StringCompare s2 = new StringCompare("", "2");
		StringCompare s3 = new StringCompare("1", "3");
		List<StringCompare> list = new ArrayList<>();
		list.add(s2);
		list.add(s3);
		list.add(s);
		
		Collections.sort(list, stringCompare);
		log.info(list.toString());
	}

	/**
	 *
	 * 從小到大排，null和空字串在最後
	 */
	public static Comparator<StringCompare> stringCompare = new Comparator<StringCompare>() {
		@Override
		public int compare(StringCompare o1, StringCompare o2) {
			if (StringUtils.isNotBlank(o1.getName()) && StringUtils.isNotBlank(o2.getName())) {
				return o1.getName().compareTo(o2.getName());
			} else {
				return StringUtils.isNotBlank(o1.getName()) ? -1 : 1;
			}
		}
	};
}
