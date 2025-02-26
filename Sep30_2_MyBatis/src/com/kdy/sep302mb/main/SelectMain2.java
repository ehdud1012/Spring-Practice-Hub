package com.kdy.sep302mb.main;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.kdy.db.manager.KdyDBManager;
import com.kdy.sep302mb.product.Product;

public class SelectMain2 {
	public static void main(String[] args) {
		SqlSession ss = null;
		Scanner s = new Scanner(System.in);
		try {
			KdyDBManager.getKdbm().newSSF("config.xml");
			ss = KdyDBManager.getKdbm().getSsf().openSession();
			System.out.print("검색 : ");
			String searchWord = s.next();
			
			Product p = new Product(searchWord, null);
			
			List<Product> products = ss.selectList("productMapper.search", p);
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
