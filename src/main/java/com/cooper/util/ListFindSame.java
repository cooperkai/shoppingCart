package com.cooper.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListFindSame {
	private static final String START = "start";
	private static final String NMDPRT = "NMDPRT";
	private static final String NMDMKWID = "NMDMKWID";
	private static final String NMDMKPRT = "NMDMKPRT";
	private static final String NMDMKVP = "NMDMKVP";
	private static final String NMDBIZVP = "NMDBIZVP";
	private static final String NMDMDVP = "NMDMDVP";
	private static final String NMDFSMG = "NMDFSMG";
	private static final String NMDFSVP = "NMDFSVP";
	private static final String NMDRTGM = "NMDRTGM";
	private static final String NMDCEO = "NMDCEO";

	// type3:審核；5跳關；1審核中；0未審核
	public static void main(String[] args) throws CloneNotSupportedException {
		Person2 p0 = new Person2(ListFindSame.START,	"A", "3");
		Person2 p1 = new Person2(ListFindSame.NMDPRT,	"B", "3");
//		Person2 s1 = new Person2(ListFindSame.NMDPRT,	"C", "3");
//		Person2 c1 = new Person2(ListFindSame.NMDPRT,	"C", "3");
		Person2 p2 = new Person2(ListFindSame.NMDMKWID, "B", "5");
//		Person2 s2 = new Person2(ListFindSame.NMDMKWID, "C", "5");
//		Person2 c2 = new Person2(ListFindSame.NMDMKWID, "D", "5");
		Person2 p3 = new Person2(ListFindSame.NMDMKPRT, "D", "5");
//		Person2 s3 = new Person2(ListFindSame.NMDMKPRT, "E", "5");
		Person2 p4 = new Person2(ListFindSame.NMDMKVP,	"D", "1");
//		Person2 s4 = new Person2(ListFindSame.NMDMKVP,	"E", "0");
		Person2 p5 = new Person2(ListFindSame.NMDBIZVP, "F", "0");
//		Person2 s5 = new Person2(ListFindSame.NMDBIZVP, "G", "0");
		Person2 p6 = new Person2(ListFindSame.NMDMDVP, 	"E", "0");
//		Person2 s6 = new Person2(ListFindSame.NMDMDVP, 	"E", "0");
		Person2 p7 = new Person2(ListFindSame.NMDFSMG, 	"E", "0");
//		Person2 s7 = new Person2(ListFindSame.NMDFSMG, 	"E", "0");
		Person2 p8 = new Person2(ListFindSame.NMDFSVP, 	"E", "0");
//		Person2 s8 = new Person2(ListFindSame.NMDFSVP, 	"E", "0");
		Person2 p9 = new Person2(ListFindSame.NMDRTGM, 	"E", "0");
//		Person2 s9 = new Person2(ListFindSame.NMDRTGM, 	"E", "0");
		Person2 p10 = new Person2(ListFindSame.NMDCEO, 	"F", "0");
//		Person2 s10 = new Person2(ListFindSame.NMDCEO, 	"E", "0");
		List<Person2> startList = Arrays.asList(p0);
//		List<Person2> node = Arrays.asList(p1, s1, c1);
//		List<Person2> nextNode = Arrays.asList(p2, s2, c2);
//		List<Person2> next2Node = Arrays.asList(p3, s3);
//		List<Person2> next3Node = Arrays.asList(p4, s4);
//		List<Person2> next4Node = Arrays.asList(p5, s5);
//		List<Person2> next5Node = Arrays.asList(p6, s6);
//		List<Person2> next6Node = Arrays.asList(p7, s7);
//		List<Person2> next7Node = Arrays.asList(p8, s8);
//		List<Person2> next8Node = Arrays.asList(p9, s9);
//		List<Person2> next9Node = Arrays.asList(p10, s10);
		List<Person2> node = Arrays.asList(p1);
		List<Person2> nextNode = Arrays.asList(p2);
		List<Person2> next2Node = Arrays.asList(p3);
		List<Person2> next3Node = Arrays.asList(p4);
		List<Person2> next4Node = Arrays.asList(p5);
		List<Person2> next5Node = Arrays.asList(p6);
		List<Person2> next6Node = Arrays.asList(p7);
		List<Person2> next7Node = Arrays.asList(p8);
		List<Person2> next8Node = Arrays.asList(p9);
		List<Person2> next9Node = Arrays.asList(p10);
		
		List<Person2> totalNode = Arrays.asList(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
//		List<Person2> totalNode2 = Arrays.asList(p0, p1, s1, p2, s2, p3, s3, p4, s4, p5, s5, p6, s6, p7, s7, p8, s8, p9, s9, p10, s10);
//		List<Person2> finishNode = Arrays.asList(p0, p1);
//		List<Person2> finishNode2 = Arrays.asList(p0, p1, s1);
//		String[] channels = {"TLW", "HOLA"};
		
		Map<String, List<String>> map = new LinkedHashMap<>();
		map.put(startList.get(0).getNodeId(), getApproverWithSort(startList));
		if (node != null && node.size() > 0) {
			map.put(node.get(0).getNodeId(), getApproverWithSort(node));
		}
		if (nextNode != null && nextNode.size() > 0) {
			map.put(nextNode.get(0).getNodeId(), getApproverWithSort(nextNode));
		}
		if (next2Node != null && next2Node.size() > 0) {
			map.put(next2Node.get(0).getNodeId(), getApproverWithSort(next2Node));
		}
		if (next3Node != null && next3Node.size() > 0) {
			map.put(next3Node.get(0).getNodeId(), getApproverWithSort(next3Node));
		}
		if (next4Node != null && next4Node.size() > 0) {
			map.put(next4Node.get(0).getNodeId(), getApproverWithSort(next4Node));
		}
		if (next5Node != null && next5Node.size() > 0) {
			map.put(next5Node.get(0).getNodeId(), getApproverWithSort(next5Node));
		}
		if (next6Node != null && next6Node.size() > 0) {
			map.put(next6Node.get(0).getNodeId(), getApproverWithSort(next6Node));
		}
		if (next7Node != null && next7Node.size() > 0) {
			map.put(next7Node.get(0).getNodeId(), getApproverWithSort(next7Node));
		}
		if (next8Node != null && next8Node.size() > 0) {
			map.put(next8Node.get(0).getNodeId(), getApproverWithSort(next8Node));
		}
		if (next9Node != null && next9Node.size() > 0) {
			map.put(next9Node.get(0).getNodeId(), getApproverWithSort(next9Node));
		}
		System.out.println("map: " + map);

		// 已完成關卡
		List<String> finishNodeStr = 
				totalNode.stream()
					.filter(e -> "3".equals(e.getType()) || "5".equals(e.getType()))
					.map(Person2::getNodeId)
					.collect(Collectors.toList());
		System.out.println("已完成關卡" + finishNodeStr);

		Map<String, List<String>> finishNodeApproverMap = new LinkedHashMap<>();
		for (String s : finishNodeStr) {
			for (Map.Entry<String, List<String>> entry : map.entrySet()) {
				if (s.equals(entry.getKey())) {
					finishNodeApproverMap.put(s, entry.getValue());
				}
			}
		}
		System.out.println("已完成關卡審核者" + finishNodeApproverMap);
		
		// Reverse HashMap keys and values
		// https://stackoverflow.com/questions/20412354/reverse-hashmap-keys-and-values-in-java
		// https://www.techiedelight.com/sort-map-java-reverse-ordering-keys/
		
		// duplicate key map
		// https://stackoverflow.com/questions/32312876/ignore-duplicates-when-producing-map-using-streams
		// (oldVal, newVal) -> newVal 取前面value的值，或者取後面放入的value值，覆蓋先前的value值
		// https://blog.csdn.net/kingmax54212008/article/details/98489696?utm_medium=distribute.pc_relevant.none-task-blog-baidujs-1
		
		// map tomap to LinkedHashMap java
		// https://stackoverflow.com/questions/29090277/how-do-i-keep-the-iteration-order-of-a-list-when-using-collections-tomap-on-a
		
		// 去重複審核者
		Map<List<String>, String> mapInversed = 
			    map.entrySet()
			       .stream()
			       .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (oldVal, newVal) -> newVal, LinkedHashMap::new));
		Map<String, List<String>> afterMap = 
				mapInversed.entrySet()
							.stream()
							.collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (oldVal, newVal) -> newVal, LinkedHashMap::new));
		System.out.println("去重複審核者: " + afterMap);

		// 排除已經審核的關卡
		Map<String, List<String>> jumpMap = new LinkedHashMap<>();
		for (Map.Entry<String, List<String>> entry : afterMap.entrySet()) {
			boolean approverCheck = checkApproverContain(finishNodeApproverMap, entry.getValue());
			if (!finishNodeStr.contains(entry.getKey()) && !approverCheck) {
				jumpMap.put(entry.getKey(), entry.getValue());
			}
		}
		System.out.println("jumpMap: " + jumpMap);
		
		// 抓出未審核關卡的人
		Map<String, List<String>> newMap = new LinkedHashMap<>();
		List<String> keyList = new ArrayList<>();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			for (Map.Entry<String, List<String>> entry2 : jumpMap.entrySet()) {
				if (entry2.getValue().equals(entry.getValue())) {
					keyList.add(entry.getKey());
					newMap.put(entry.getKey(), entry.getValue());
				}
			}
		}
		System.out.println("newMap: " + newMap);
		System.out.println("keyList: " + keyList);
		nextNode = getNextNode(totalNode);
		Map<String, Object> flowConstantMap = finalNode2(keyList, newMap, totalNode, nextNode);
		Object a = flowConstantMap.get("position2");
		List<Person2> result = new ArrayList<Person2>();
	    if (a instanceof List){
	        for(int i = 0; i < ((List<?>)a).size(); i++){
	            Object item = ((List<?>) a).get(i);
	            if(item instanceof Person2){
	                result.add((Person2) item);
	            }
	        }
	    }
		System.out.println("flowConstantMap: " + flowConstantMap);
		System.out.println("a: " + a);
	}

	private static List<Person2> getNextNode(List<Person2> totalNode) {
		List<Person2> pList = new ArrayList<>();
		int index = IntStream.range(0, totalNode.size())
				.filter(i -> totalNode.get(i).getType().equals("1"))
				.findFirst()
				.orElse(-1);
		for (int i = 0; i < totalNode.size(); i++) {
			if (index + 1 == i) {
				pList.add(totalNode.get(i));
			}
		}
		return pList;
	}

	private static boolean checkApproverContain(Map<String, List<String>> finishNodeApproverMap, List<String> value) {
		// Check if one list contains element from the other
		// https://stackoverflow.com/questions/11796371/check-if-one-list-contains-element-from-the-other
//		return finishNodeApproverMap.stream().anyMatch(element -> value.contains(element));
		boolean check = false;
		for (Map.Entry<String, List<String>> entry : finishNodeApproverMap.entrySet()) {
			if (entry.getValue().equals(value)) {
				check = true;
				break;
			}
		}
		return check;
	}

	private static Map<String, Object> finalNode2(List<String> keyList, Map<String, List<String>> newMap, List<Person2> totalNode, List<Person2> nextNode) {
		Map<String, Object> flowConstantMap = new HashMap<>();
		String position2 = "";// 最大關卡
		String approver2 = "";// 最大關卡審核者
		Integer maxP = 0;// 最大關卡位址
		Integer[] sameApproverPosition2 = {};
		List<Person2> finalNodeList = new ArrayList<Person2>();
		int i = 0;
		
		// 判斷下一步關卡相同的人位置
		// 如果下一關審核者沒有連續相同，直接離開判斷
		if (totalNode.size() > 0) {
			sameApproverPosition2 = new Integer[totalNode.size()];
			List<String> strList = newMap.get(keyList.get(0));
			String key = "";
			for (Map.Entry<String, List<String>> entry : newMap.entrySet()) {
				if (strList.equals(entry.getValue())) {
					sameApproverPosition2[i] = i;
					key = entry.getKey();
				} else {
					break;
				}
				strList = entry.getValue();
				i++;
			}

			// 判斷審核者最大關卡是哪一關
			boolean empty2 = true;
			sameApproverPosition2 = Arrays.stream(sameApproverPosition2).filter(j -> j != null).toArray(Integer[]::new);
			if (0 == sameApproverPosition2.length) {
				empty2 = false;
			}

			// 取得最大關卡以及審核者
			if (empty2 && sameApproverPosition2.length > 0 && sameApproverPosition2.length > 1) {
				maxP = Arrays.stream(sameApproverPosition2).max(integerCompare).get();
				approver2 = newMap.get(key).toString();
				position2 = key;
				String node = position2;
				finalNodeList = totalNode.stream().filter(e -> e.getNodeId().equals(node)).collect(Collectors.toList());
			}
		}
		
		if (finalNodeList.size() == 0) {
			finalNodeList = nextNode;
		}
		
		flowConstantMap.put("maxP", maxP);
		flowConstantMap.put("position2", position2);
		flowConstantMap.put("approver2", approver2);
		flowConstantMap.put("finalNodeList", finalNodeList);
		return flowConstantMap;
	}
	
	public static Comparator<Integer> integerCompare = new Comparator<Integer>() {
		@Override
		public int compare(Integer i1, Integer i2) {
			int result = 0;
			if (null == i1 && null != i2) {
				result = -1;
			} else if (null != i1 && null == i2) {
				result = 1;
			} else if (null == i1 && null == i2) {
				result = 0;
			} else {
				result = i1.compareTo(i2);
			}
			return result;
		}
    };
    
	private static List<String> getApproverWithSort(List<Person2> list) {
		List<String> strList = new ArrayList<>();
		for (Person2 person2 : list) {
			strList.add(person2.getApprover());
		}
		Collections.sort(strList);
		return strList;
	}
}

class Person2 {
	private String nodeId;
	private String approver;
	private String type;

	public Person2(String nodeId, String approver, String type) {
		super();
		this.nodeId = nodeId;
		this.approver = approver;
		this.setType(type);
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approver == null) ? 0 : approver.hashCode());
		result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person2 other = (Person2) obj;
		if (approver == null) {
			if (other.approver != null)
				return false;
		} else if (!approver.equals(other.approver))
			return false;
		if (nodeId == null) {
			if (other.nodeId != null)
				return false;
		} else if (!nodeId.equals(other.nodeId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person2 [nodeId=" + nodeId + ", approver=" + approver + ", type=" + type + "]";
	}
}