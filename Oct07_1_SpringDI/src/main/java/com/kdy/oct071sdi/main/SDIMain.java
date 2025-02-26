package com.kdy.oct071sdi.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kdy.oct071sdi.animal.Dog;
import com.kdy.oct071sdi.date.DateManager;
import com.kdy.oct071sdi.human.Human;

// Spring : Java OOP 전반적으로 유지보수 하기 좋게
// 
public class SDIMain {
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("oct071beans.xml");
		aac.registerShutdownHook();
		
		Human h2 = aac.getBean("human2", Human.class);
		h2.print();
		
		Human h3 = aac.getBean("human3", Human.class);
		h3.print();
		System.out.println("------------------");
		
		DateManager dm = aac.getBean("date1", DateManager.class);
		dm.printDate();
		
		Date now = new Date();
		SimpleDateFormat sdf = aac.getBean("sdf", SimpleDateFormat.class);
		String now2 = sdf.format(now);
		System.out.println(now2);
		
		System.out.println("------------------");
		
		Dog.printBarkSound();
		
		Human h4 = aac.getBean("human4", Human.class);
		h4.print();
		h4.getPet().print();
		
		Human h5 =  aac.getBean("human5", Human.class);
		String[] family = h5.getFamily();
		for (String string : family) {
			System.out.println(string);
		}
		
		ArrayList<String> nickname = h5.getNickname();
		for (String string : nickname) {
			System.out.println(string);
		}
		
		HashMap<String, Double> stat = h5.getStat();
		System.out.println(stat.get("키"));
		System.out.println(stat.get("몸무게"));
		aac.close();
	}
}
