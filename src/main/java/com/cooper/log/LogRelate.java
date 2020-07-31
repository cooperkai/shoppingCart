package com.cooper.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogRelate {
	private static final Logger logger = LoggerFactory.getLogger(LogRelate.class);

	public static void main(String[] args) {
		logger.warn("Example log from {}", LogRelate.class.getSimpleName());
	}

}
