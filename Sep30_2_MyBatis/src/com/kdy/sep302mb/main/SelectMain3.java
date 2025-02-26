package com.kdy.sep302mb.main;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.kdy.db.manager.KdyDBManager;
import com.kdy.sep302mb.product.Product;

public class SelectMain3 {
	public static void main(String[] args) {
		SqlSession ss = null;
		Scanner s = new Scanner(System.in);
		try {
			KdyDBManager.getKdbm().newSSF("config.xml");
			ss = KdyDBManager.getKdbm().getSsf().openSession();
			System.out.print("가격 : ");
			
			int searchPrice = s.nextInt();
			// 기본형 -> BigDecimal
			BigDecimal bdPrice = new BigDecimal(searchPrice);
			
			// BigDecimal -> 기본형
			// int price3 = bdPrice.intValue();
			
			Product p = new Product(null, bdPrice);
			
			List<Product> products = ss.selectList("productMapper.searchPrice", p);
			for (Product product : products) {
				System.out.print(product.getP_name() + " : ");
				System.out.println(product.getP_price());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
