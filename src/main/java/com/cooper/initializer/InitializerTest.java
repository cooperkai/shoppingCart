package com.cooper.initializer;

public class InitializerTest {
	static String id;
	static String name;
	
	InitializerTest () {
//		super();// 會最先執行這個
		System.out.println("建構子");
	}
	
	InitializerTest (int a) {
		System.out.println("參數建構子");
	}
	
	{
		id = "0";
		name = "哈哈";
		System.out.println("實例建構子");
	}
	
	static {
		id = "0";
		name = "哈哈";
	}
	
	public static void main(String[] args) {
		new InitializerTest();
		new InitializerTest(2);
	}

}
