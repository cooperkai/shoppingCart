package com.cooper.util;

import java.util.Calendar;

public class TimeUtils {
	public static void main(String[] args) {
		System.out.println(isFirstDatOfMonth());
	}

	// 每個月的第一天日期
	public static Calendar getFirstDayofMonth(Calendar calendar) {
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
		return calendar;
	}

	public static void removeTime(Calendar calendar) {
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}
	
	private static boolean isFirstDatOfMonth() {
		Calendar now = Calendar.getInstance();
		removeTime(now);
		Calendar now2 = Calendar.getInstance();
		removeTime(now2);
		Calendar firstDayofMonth = getFirstDayofMonth(now2);
		if (now.compareTo(firstDayofMonth) == 0) {
			return true;
		} else {
			return false;
		}
	}
}
