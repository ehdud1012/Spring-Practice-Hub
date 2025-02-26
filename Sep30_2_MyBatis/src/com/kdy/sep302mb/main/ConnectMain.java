package com.kdy.sep302mb.main;

import org.apache.ibatis.session.SqlSession;

import com.kdy.db.manager.KdyDBManager;


// MyBatis
//		서버정보	: xxxConfig.xml
//		SQL		: xxxMapper.xml

// 1) Maven 프로젝트로 바꾸고
// 2) ojdbc7 or 8 / mybatis /  KdyDBManager 가져오기
// 3) config.xml 가져오기 
// 4) mapper.xml 메뉴를 통해서 만들기 
// 5) config.xml mapper 이름 수정


public class ConnectMain {
	public static void main(String[] args) {
		SqlSession ss = null;
		try {
			KdyDBManager.getKdbm().newSSF("config.xml");
			ss = KdyDBManager.getKdbm().getSsf().openSession();
			System.out.println("성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
