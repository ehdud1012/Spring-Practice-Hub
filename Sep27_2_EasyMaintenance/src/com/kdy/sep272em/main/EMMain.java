package com.kdy.sep272em.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

// 1% -> 0.5%로 바꾸기 용이하게 하자면 (유지보수 용이하게)
//		소스정리, OOP, AOP, ...
//		-> 애초에 유지보수가 필요없도록
//			java소스는 컴파일을 통하여 기계어로 바뀜 -> 수정 어려움
//		=> 수정당할만한 부분은 외부파일에 써놓고, Java소스로는 불러오기만

// 유지보수하기 좋게 프로그램 개발 : 개발 때는 더 오래걸림
// 유지보수하기 좋게 프로그램 만들게 해주는 framework

// library	 : 시키는대로 하면 자동으로 처리
// framework : library + 자체 툴 : 근데 대충 구별

// 제품 사용법을 배우는 거 (소스는 못봄)
//	- Spring
//	- MyBatis
//	- maven


// 1% -> 0.5%로 
//		메모장 수치만 변경하면 됨
public class EMMain {
	public static void main(String[] args) {
		Scanner ci = new Scanner(System.in);
		System.out.print("물건 가격 : ");
		int price = ci.nextInt();
		System.out.println("------------");
		
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\KDY\\point.txt");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			String s = br.readLine();
			
			int point = (int) Math.ceil(price * Double.parseDouble(s));
			System.out.printf("적립되는 포인트 : %d\n" ,point);
			
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {br.close();} catch (Exception e) {}
		ci.close();
	}
}
