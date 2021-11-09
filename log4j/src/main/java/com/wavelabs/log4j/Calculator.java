package com.wavelabs.log4j;

import org.apache.log4j.Logger;

//import java.util.logging.Logger;

public class Calculator {
	public static Logger logger=Logger.getLogger(Calculator.class.getName());
	public static void main(String[] args) {
		int a=10;
		int b=20;
//		logger.warning("We are using add method here,"+a+".."+b);
//		logger.error("We are using add method here,"+a+".."+b);
//		logger.debug("We are using add method here,"+a+".."+b);
		logger.fatal("We are using add method here,"+a+".."+b);
		System.out.println(add(a,b));

	}
	public static int add(int a,int b) {
//		logger.warning("We are inside add method");
//		logger.error("We are inside add method");
//		logger.debug("We are inside add method");
//		logger.fatal("We are inside add method");
		return a+b;
	}

}
