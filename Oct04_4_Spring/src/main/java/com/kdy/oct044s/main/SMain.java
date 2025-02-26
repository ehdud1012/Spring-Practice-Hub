package com.kdy.oct044s.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.kdy.oct044s.avengers.Avengers;

// EJB			vs		Spring
// JavaBean에 설정			POJO
// 

// Spring : Java DI, IoC Framework
//		Java진영에서 IoC로  DI 지원해주는 Framework
//		-> 자바 객체를 자바소스가 아닌 외부파일에
//	DI (Dependency Injection - 의존성 주의)
//		객체 만들고, 값 넣고...
//	IoC (Inversion of Control - 제어의 역전)
//		프로그램으로 파일 제어 	: 프로그램 -> 파일에 저장
//		파일로 프로그램 제어	: 
// POJO (Plain Old Java Object)
//		기본적으로 java에서 쓰는 객체
//		평소에 쓰는 자바 객체

public class SMain {
	public static void main(String[] args) {
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
		xbdr.loadBeanDefinitions(new ClassPathResource("abcd.xml"));
		// Avengers a = (Avengers) dlbf.getBean("a"); // 형변환
		Avengers a = dlbf.getBean("a", Avengers.class); // 이렇게도 함  : 강사님
		
		a.attack();
	}
}
