package com.kdy.sep302mb.main;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.kdy.db.manager.KdyDBManager;
import com.kdy.sep302mb.product.Product;

public class InsertMain {
	public static void main(String[] args) {
		SqlSession ss = null;
		Scanner s = new Scanner(System.in);
		try {
			KdyDBManager.getKdbm().newSSF("config.xml");
			ss = KdyDBManager.getKdbm().getSsf().openSession();
			System.out.print("이름 : ");
			String name = s.next();
			System.out.print("가격 : ");
			int price = s.nextInt();
			// 기본형 -> BigDecimal
			BigDecimal bdPrice = new BigDecimal(price);
			
			// BigDecimal -> 기본형
			// int price3 = bdPrice.intValue();
			
			Product p = new Product(name, bdPrice);
			int row = ss.insert("productMapper.insert", p);
			
			if (row == 1) {
				System.out.println("등록성공");
				ss.commit(); // 수동 commit
				// DB 작업은 위험
				// 	작업이 서버에 바로 반영 X
				//	확인해보고 정상이면 commit해서 실제 반영
				//	확인해보고 문제 있으면 roll-back해서 취소
				
				// -> auto commit이 아니기에 수동으로 해야함
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		s.close();
		ss.close();
	}
}
