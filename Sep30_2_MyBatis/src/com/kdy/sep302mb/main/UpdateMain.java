package com.kdy.sep302mb.main;

import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.kdy.db.manager.KdyDBManager;
import com.kdy.sep302mb.product.Product2;

public class UpdateMain {
	public static void main(String[] args) {
		SqlSession ss = null;
		Scanner s = new Scanner(System.in);
		try {
			KdyDBManager.getKdbm().newSSF("config.xml");
			ss = KdyDBManager.getKdbm().getSsf().openSession();
			
			System.out.print("찾을 가격 : ");
			int searchprice = s.nextInt();
			BigDecimal bdSPrice = new BigDecimal(searchprice);
			
			System.out.print("수정할 가격 : ");
			int price = s.nextInt();
			BigDecimal bdPrice = new BigDecimal(price);
			
			Product2 p = new Product2(bdPrice, bdSPrice);
			
			if (ss.update("productMapper.update", p) >= 1) {
				System.out.println("수정성공");
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		s.close();
		ss.close();
	}
}
