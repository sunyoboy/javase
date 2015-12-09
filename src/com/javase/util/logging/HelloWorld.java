package com.javase.util.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloWorld {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(HelloWorld.class);
		logger.debug("Hello World.");
	}
	
	public void print(String name) {
		System.out.println(name + ",ƒ„‘⁄ π”√junit,logback");
	}
}
