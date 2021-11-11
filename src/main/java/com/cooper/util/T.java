package com.cooper.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.springframework.beans.BeanUtils;

public class T {

	// type3:審核；5跳關；1審核中；0未審核
	public static void main(String[] args) {
		Person3 p0 = new Person3("MT001", "A", "TBA");
		Person3 p1 = new Person3("MT001", "D", "HOLA");
		Person3 p2 = new Person3("MT002", "B", "TLW");
		Person3 p3 = new Person3("MT002", "B", "HOLA");
		Person3 p4 = new Person3("MT003", "D", "HOLA");
		Person3 p6 = new Person3("MT005", "C", "HOLA");
		Person3 p5 = new Person3("MT004", "C", "CASA");

		List<Person3> list = new ArrayList<>(Arrays.asList(p0, p1, p2, p3, p4, p5, p6));
		List<Person3> list2 = new ArrayList<>(Arrays.asList(p3, p2));
		list.removeAll(list2);
		System.out.println("after remove first priority: " + list);

		List<Person3> finalList = new ArrayList<>();
		finalList.addAll(list2);
		finalList.addAll(list);
		System.out.println("排完順序後: " + finalList);

		List<PersonDetail> pD = deData();
		List<PersonDetail> listDetail = new ArrayList<>(pD);

		long st = System.currentTimeMillis();
		List<PersonFinal> resultList = new ArrayList<>();
		for (Person3 person : finalList) {
//			List<PersonDetail> detailList = useEventIdFindDetail(person.getEventId(), listDetail);
			List<PersonDetail> iteratorDetailList = useIteratorEventIdFindDetail(person.getEventId(), listDetail);
			Iterator<PersonDetail> iDetail = iteratorDetailList.iterator();
			while (iDetail.hasNext()) {
				PersonFinal personFinal = new PersonFinal();
				BeanUtils.copyProperties(person, personFinal);
				PersonDetail peDetail = iDetail.next();
				BeanUtils.copyProperties(peDetail, personFinal);
				resultList.add(personFinal);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("耗費: " + (end - st) / 1000);
		System.out.println(resultList);

	}

	private static List<PersonDetail> useEventIdFindDetail(String eventId, List<PersonDetail> listDetail) {
		Predicate<PersonDetail> condition = new Predicate<PersonDetail>() {
			public boolean evaluate(PersonDetail sample) {
				return (sample).getEventId().equals(eventId);
			}
		};

		return (List<PersonDetail>) CollectionUtils.select(listDetail, condition);
	}
	
	private static List<PersonDetail> useIteratorEventIdFindDetail(String eventNo, List<PersonDetail> listDetail) {
		List<PersonDetail> matchEventNoList = new ArrayList<>();
		Iterator<PersonDetail> iterator = listDetail.iterator();
		while (iterator.hasNext()) {
			PersonDetail condition = iterator.next();
			if (condition.getEventId().equals(eventNo)) {
				matchEventNoList.add(condition);
			}
		}
		return matchEventNoList;
	}

	private static List<PersonDetail> deData() {
		PersonDetail pD1 = new PersonDetail("MT001", "1", "1", "456");
		PersonDetail pD2 = new PersonDetail("MT001", "1", "1", "456");
		PersonDetail pD3 = new PersonDetail("MT001", "1", "1", "4567");
		PersonDetail pD4 = new PersonDetail("MT001", "1", "1", "4567");
		PersonDetail pD5 = new PersonDetail("MT002", "1", "1", "45");
		PersonDetail pD6 = new PersonDetail("MT002", "2", "1", "45");
		PersonDetail pD7 = new PersonDetail("MT003", "1", "1", "45");
		PersonDetail pD8 = new PersonDetail("MT003", "1", "1", "12");
		PersonDetail pD9 = new PersonDetail("MT004", "1", "1", "123");
		PersonDetail pD10 = new PersonDetail("MT004", "1", "1", "1234");
		PersonDetail pD11 = new PersonDetail("MT004", "1", "1", "12345");
		PersonDetail pD12 = new PersonDetail("MT004", "1", "1", "21");
		PersonDetail pD13 = new PersonDetail("MT004", "1", "1", "23");
		PersonDetail pD14 = new PersonDetail("MT004", "1", "1", "234");
		PersonDetail pD15 = new PersonDetail("MT004", "1", "1", "2345");
		PersonDetail pD16 = new PersonDetail("MT004", "1", "1", "34");
		PersonDetail pD17 = new PersonDetail("MT004", "1", "1", "345");
		PersonDetail pD18 = new PersonDetail("MT004", "1", "1", "45");
		PersonDetail pD19 = new PersonDetail("MT004", "1", "1", "43");
		PersonDetail pD20 = new PersonDetail("MT004", "2", "1", "432");
		PersonDetail pD21 = new PersonDetail("MT004", "2", "1", "4321");
		PersonDetail pD22 = new PersonDetail("MT004", "2", "1", "54");
		PersonDetail pD23 = new PersonDetail("MT004", "2", "1", "543");
		PersonDetail pD24 = new PersonDetail("MT004", "2", "1", "5432");
		PersonDetail pD25 = new PersonDetail("MT004", "2", "1", "54321");
		PersonDetail pD26 = new PersonDetail("MT004", "2", "1", "32");
		PersonDetail pD27 = new PersonDetail("MT004", "2", "1", "321");
		PersonDetail pD28 = new PersonDetail("MT004", "2", "1", "456");
		PersonDetail pD29 = new PersonDetail("MT004", "2", "1", "4567");
		PersonDetail pD30 = new PersonDetail("MT004", "2", "1", "567");
		PersonDetail pD31 = new PersonDetail("MT004", "2", "1", "56");
		PersonDetail pD32 = new PersonDetail("MT004", "2", "1", "765");
		PersonDetail pD33 = new PersonDetail("MT004", "2", "1", "75");
		PersonDetail pD34 = new PersonDetail("MT005", "2", "1", "76");
		PersonDetail pD35 = new PersonDetail("MT005", "2", "1", "74");
		PersonDetail pD36 = new PersonDetail("MT005", "2", "1", "73");
		PersonDetail pD37 = new PersonDetail("MT005", "2", "1", "62");
		PersonDetail pD38 = new PersonDetail("MT005", "2", "1", "52");
		PersonDetail pD39 = new PersonDetail("MT005", "2", "1", "51");
		PersonDetail pD40 = new PersonDetail("MT005", "2", "1", "511");
		PersonDetail pD41 = new PersonDetail("MT005", "2", "1", "532");
		return Arrays.asList(pD1, pD2, pD3, pD4, pD5, pD6, pD7, pD8, pD9, pD10, pD11, pD12, pD13, pD14, pD15, pD16,
				pD17, pD18, pD19, pD20, pD21, pD22, pD23, pD24, pD25, pD26, pD27, pD28, pD29, pD30, pD31, pD32, pD33,
				pD34, pD35, pD36, pD37, pD38, pD39, pD40, pD41);
	}

}

class Person3 {
	private String eventId;
	private String buyerCode;
	private String channelId;

	public Person3(String eventId, String buyerCode, String channelId) {
		super();
		this.eventId = eventId;
		this.buyerCode = buyerCode;
		this.channelId = channelId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getBuyerCode() {
		return buyerCode;
	}

	public void setBuyerCode(String buyerCode) {
		this.buyerCode = buyerCode;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buyerCode == null) ? 0 : buyerCode.hashCode());
		result = prime * result + ((channelId == null) ? 0 : channelId.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
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
		Person3 other = (Person3) obj;
		if (buyerCode == null) {
			if (other.buyerCode != null)
				return false;
		} else if (!buyerCode.equals(other.buyerCode))
			return false;
		if (channelId == null) {
			if (other.channelId != null)
				return false;
		} else if (!channelId.equals(other.channelId))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person3 [eventId=" + eventId + ", buyerCode=" + buyerCode + ", channelId=" + channelId + "]";
	}
}

class PersonDetail {
	private String eventId;
	private String category;
	private String grp;
	private String sku;

	public PersonDetail(String eventId, String category, String grp, String sku) {
		super();
		this.eventId = eventId;
		this.category = category;
		this.grp = grp;
		this.sku = sku;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGrp() {
		return grp;
	}

	public void setGrp(String grp) {
		this.grp = grp;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
}

class PersonFinal {
	private String eventId;
	private String buyerCode;
	private String channelId;
	private String category;
	private String grp;
	private String sku;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getBuyerCode() {
		return buyerCode;
	}

	public void setBuyerCode(String buyerCode) {
		this.buyerCode = buyerCode;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGrp() {
		return grp;
	}

	public void setGrp(String grp) {
		this.grp = grp;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Override
	public String toString() {
		return "PersonFinal [eventId=" + eventId + ", buyerCode=" + buyerCode + ", channelId=" + channelId
				+ ", category=" + category + ", grp=" + grp + ", sku=" + sku + "]";
	}
}