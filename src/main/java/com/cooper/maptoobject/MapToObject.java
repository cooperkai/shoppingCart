package com.cooper.maptoobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MapToObject {

	private static final Logger log = LoggerFactory.getLogger(MapToObject.class);

	public static void main(String[] args) {
		// 要對map進行增加的操作
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "cjj");
		map.put("say", "走在路上的碼農");
		list.add(map);

		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map2 = list.get(i);
			map2.put("age", "新加的引數");
		}
		String age = list.get(0).get("age").toString();
		log.info("輸出下新新增的 age:+++++{}", age);
	}
}
