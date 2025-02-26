package com.kdy.oct045sdi.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kdy.oct045sdi.animal.Dog;

//beans.xml에 "d1" 이라는 개 만들어 놓고, 불러오기만
// 		dldf 방식 : 최초로 부를 때 객체 실제 생성
//		 aac 방식 : 부르든지말든지 일단 객체 만들기

// Garbage Collecion : heap영역 자동 정리 시스템
//		더이상 접근할 값이 없어 사용할 수 없는 상태일 때 자동으로 지워주는거
//		dldf 방식 : 안부르면 안만들어지기 때문에 GC문제 없음
//		aac 방식 : 일단 불러
//			-> 기존의 GC방식 X, 메모리 영역 세는중
//				aac.registerShutdownHook();를 사용하여
// 				aac가 없어질 때, 만들어져있은 객체들 모두 삭제되도록 함
//				=> 메모리 정리
//			* 필수는 아니지만
//				aac.close(); 를 사용하여 빠른 메모리 정리

public class SDIMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans.xml");
		aac.registerShutdownHook(); // aac가 없어질 때, 만들어놓은 객체들 모두 삭제

		Dog ddd1 = aac.getBean("d1", Dog.class);
		ddd1.printInfo();
		
		aac.close(); // aac 삭제
	}
}
