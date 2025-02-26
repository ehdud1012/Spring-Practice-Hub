package com.kdy.sep271bm.main;

import java.util.Scanner;

// 만약 포인트 적립률이 바뀐다면
//	개발자에게 연락 -> 연락이 안되면?
// 	된다 해도 복잡
// 		=> 유지보수가 쉬울려면? = eGovFramework 
public class BMMain {
	public static void main(String[] args) {
		Scanner ci = new Scanner(System.in);
		
		System.out.print("물건 가격 : ");
		int price = ci.nextInt();
		System.out.println("------------");
		
		
		int point = (int) Math.ceil(price * 0.01);
		System.out.printf("적립되는 포인트 : %d\n" ,point);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ci.close();
	}
}
