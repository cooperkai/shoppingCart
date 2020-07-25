package com.cooper.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListRemoveSameConiditon {
	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1 = new Person(1, "jack");
		Person p2 = new Person(1, "jack");
		Person p3 = new Person(2, "tom");
		Person p4 = new Person(4, "hanson");
		Person p5 = new Person(5, "膠布蟲");
		List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5);
//		List<Person> personList = new ArrayList<>();
//		// 全部相同去重複
//		persons.stream().forEach(p -> {
//			if (!personList.contains(p)) {
//				personList.add(p);
//			}
//		});
//		System.out.println("全部相同去重複" + personList);
//		
//		List<Person> unique = persons.stream()
//				.collect(Collectors.collectingAndThen(
//						Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingInt(Person::getId))), ArrayList<Person>::new));
//		System.out.println("單一相同去重複" + unique);
//		
//		
//		Map<String, List<Person>> collect = persons.stream().collect(Collectors.groupingBy(Person::getName));
//		for (Entry<String, List<Person>> entry : collect.entrySet()) {
//			if (entry.getValue().size() > 1) {
//				System.out.println(
//						entry.getValue().get(0).getName()+ " 和" + entry.getValue().get(1).getName() + "重複");
//			}
//		}
//		
//		// 找最大數值
//		Integer [] sameApproverPosition = {2, 1000000000, null};
//		Optional<Integer> a = Arrays.stream(sameApproverPosition).max(integerCompare);
//		Integer result = Integer.valueOf(a.get());
//		System.out.println("最大數值: " + result);
		
		// 判斷陣列空值
//		Integer[] arr = {null, null, null};
//		arr = Arrays.stream(arr).filter(i -> i != null).toArray(Integer[]::new);
//		System.out.println("是否為空值: " + arr.length);
		
		// 找list裡面有重複的值
//		String firstName = persons.get(0).getName();
//		boolean allSameName = persons.stream().allMatch(x -> x.getName().equals(firstName));
//		System.out.println("是否名字全部相同: " + allSameName);
		// https://stackoverflow.com/questions/48031665/check-whether-list-of-custom-objects-have-same-value-for-a-property-in-java-8
		
		// 刪除map 條件:key結尾是xxx
		Map<String, String> map = new HashMap<String, String>();
		map.put("aResult", "Y");
		map.put("bResult", "Y");
		map.put("cResult", "Y");
		map.put("a", "Y");
//		map.entrySet().removeIf(entry -> entry.getKey().endsWith("Result"));
//		map.entrySet().stream().forEach(System.out::println);
		// https://blog.csdn.net/z69183787/article/details/95949765 刪除map值
		// https://stackoverflow.com/questions/29523711/how-can-i-find-a-key-in-a-map-based-on-a-pattern-matching-in-java 如何抓取map key
		
		// 過濾list位址大於某個數字才輸出
		IntStream.range(0, persons.size())
		.filter(i -> i > 2)
		.mapToObj(i -> persons.get(i)).collect(Collectors.toList())
		.forEach(System.out::println);
		//https://stackoverflow.com/questions/18552005/is-there-a-concise-way-to-iterate-over-a-stream-with-indices-in-java-8
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
}

class Person implements Cloneable {
	private Integer id;
	private String name;

	public Person(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	@Override
	public Person clone() throws CloneNotSupportedException {
		Person clone = null;
		try {
			clone = (Person) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
		return clone;
	}
}