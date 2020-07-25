package com.cooper.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
public class Ex_Generic7 {
	public static void main(String[] args) {
		 
        ArrayList<Coupon> persons = new ArrayList<Coupon>();
        persons.add(new Coupon(13,0,new BigDecimal(40)));
        persons.add(new Coupon(13,0,new BigDecimal(50)));
        persons.add(new Coupon(13,0,new BigDecimal(45)));
        persons.add(new Coupon(1,0,new BigDecimal(20)));
        persons.add(new Coupon(13,1,new BigDecimal(30)));
        persons.add(new Coupon(1,0,new BigDecimal(25)));
//        persons.add(new Coupon(11,0,new BigDecimal(50)));
//        persons.add(new Coupon(11,1,new BigDecimal(40)));
        System.out.println("排序之前：");
        for (int i = 0; i <persons.size(); i++) {
            System.out.println(persons.get(i));
        }
        System.out.println();
        Collections.sort(persons, new Comparator<Coupon>() {
            //按可用升序，券类型降序，面额降序
            public int compare(Coupon o1, Coupon o2) {
                if (o1.valueAble.compareTo(o2.valueAble)==0){
                	if(o2.themeType.compareTo(o1.themeType)==0){
                		System.out.println(o2.amount.compareTo(o1.amount)>0?1:-1);
                		return o2.amount.compareTo(o1.amount)>0?1:-1;
                	}else{
                		System.out.println(o2.themeType-o1.themeType);
                		return o2.themeType-o1.themeType;
                	}
                }else{
                	System.out.println(o1.valueAble-o2.valueAble);
                    return o1.valueAble-o2.valueAble ;
                }
            }
        });
        System.out.println("排序后结果：");
        for (int i = 0; i <persons.size(); i++) {
            System.out.println(persons.get(i));
        }
    }
    
    
    static class Coupon{
        public Integer themeType;  //优惠券类型
        public Integer valueAble; //可用  ，0 可用，1不可用
        public BigDecimal amount;  //面额
 
        @Override
        public String toString() {
            return "Person{" +
                    "themeType=" + themeType +
                    ", valueAble=" + valueAble +
                    ", amount=" + amount +
                    '}';
        }
 
		public Coupon(Integer themeType, Integer valueAble, BigDecimal amount) {
			super();
			this.themeType = themeType;
			this.valueAble = valueAble;
			this.amount = amount;
		}
        
    }
}
