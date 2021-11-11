package com.cooper.proxy;

public class HelloSpeaker implements IHello {

	public void hello(String name) {
        System.out.println("Hello, " + name); 
    }

}
