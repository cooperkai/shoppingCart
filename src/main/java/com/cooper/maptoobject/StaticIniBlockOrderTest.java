package com.cooper.maptoobject;

public class StaticIniBlockOrderTest {
	int p = 9;
	public static void main(String[] args) {
//		OuterClass.innerClass a = new OuterClass().new innerClass();
//		a.sysout();
		int w;
		w = 2;
		sysout();
	}

	static void sysout() {
		int c = 2;
		class b {
			void sysout() {
				System.out.println(c);

			}
		}
		b bb = new b();
		bb.sysout();
	}
}

class OuterClass {
	private String a = "123";
	private static String ab = "123";
	
	class innerClass {
		public void sysout() {
			int c = 2;
			a = "2";
			System.out.println("Hi I'm inner");
			System.out.println(OuterClass.this.a);
			System.out.println(OuterClass.ab);
			class b {
				public void sysout() {
					System.out.println(OuterClass.ab);
					System.out.println(OuterClass.this.a);
					System.out.println(c);

				}
			} 
		}
	}
	innerClass b = new innerClass();
}