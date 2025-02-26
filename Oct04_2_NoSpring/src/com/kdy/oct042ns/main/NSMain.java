package com.kdy.oct042ns.main;

import com.kdy.oct042ns.avengers.Hulk;

// 팀장
public class NSMain {
	public static void main(String[] args) {
		
		// 1. 의사소통 문제
//		IronMan i = new IronMan();
//		i.shootBim(); // 내가 지은 메소드명이 맘에 안들어 흥!
		 
		// 2. 유지보수 문제  (자바 소스를 전부 고쳐야함)
		Hulk h = new Hulk(); // 아이언맨 -> 헐크
		h.punch();
	}
}
