package com.kdy.oct045sdi.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.kdy.oct045sdi.animal.Dog;

// dlbf 방식

public class SDIMain {
	public static void main(String[] args) {
		
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
		xbdr.loadBeanDefinitions(new ClassPathResource("beans.xml"));
		
		// beans.xml에 "d1" 이라는 개 만들어 놓고, 불러오기만
		// 최초로 부를 때 객체 실제 생성
		Dog d1 = dlbf.getBean("d1", Dog.class);
		d1.printInfo();
		Dog d2 = dlbf.getBean("d1", Dog.class);
		d2.printInfo();
		
		Dog dd3 = dlbf.getBean("d2", Dog.class);
		dd3.printInfo();
		
	}
}
