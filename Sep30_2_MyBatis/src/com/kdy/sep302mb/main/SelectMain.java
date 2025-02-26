package com.kdy.sep302mb.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kdy.db.manager.KdyDBManager;
import com.kdy.sep302mb.product.Product;

public class SelectMain {
	public static void main(String[] args) {
		SqlSession ss = null;
		try {
			KdyDBManager.getKdbm().newSSF("config.xml");
			ss = KdyDBManager.getKdbm().getSsf().openSession();
			 
			List<Product> products = ss.selectList("productMapper.gettt");
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
