package com.kdy.oct071sdi.main;

import java.util.HashMap;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kdy.oct071sdi.product.CVStore;
import com.kdy.oct071sdi.product.LunchBox;

public class SDIMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("oct071beans2.xml");
		aac.registerShutdownHook();
		
//		LunchBox lb1 = aac.getBean("lunchbox1", LunchBox.class);
//		lb1.print();
		
		CVStore c = aac.getBean("c", CVStore.class);
		c.print();
		
		aac.close();
		
		
	}
}
