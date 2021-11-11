package com.cooper.inner;

import com.cooper.inner.MyOutter.MyStatic;

public class InnerTest {

	public static void main(String[] args) {
		MyOutter.MyStatic a = new MyOutter.MyStatic();
		a.fooA();
		MyStatic.fooB();
		
	}
}

class MyOutter {
	private int x = 7;
	static private int sx = 9;

	static class MyStatic {
		private int x = 77;
		static private int sx = 99;

		public void fooA() {
			System.out.println(sx);
			System.out.println(MyOutter.sx);
			System.out.println(x);
			System.out.println(this.x);
			System.out.println(MyStatic.sx);
			// System.out.println(MyOutter.this.x);
		}

		public static void fooB() {
			System.out.println(MyStatic.sx);
			System.out.println(sx);
			System.out.println(MyOutter.sx);
		}
	}
}