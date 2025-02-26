package com.kdy.sep301mb.main;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//		   						    서버	   SQL
// Java : JDBC (v1.0)			: .java / .java 
// JSP  : ConnectionPool (v2.0)	: .xml  / .java
// eGov : MyBatis				: .xml  / .xml 

// JDBC 에 비해 ConnectionPool은  
//	- 미리 연결해놓기에 속도가 빠름
//	- 유지보수에 용이
//		JDBC는 .java에 써놓으면 기계어로 바뀌니 수정불가
//		 -> 외부 파일에 써놓자

// MyBatis
//		- 서버 연결 정보, SQL 둘 다 외부 파일에 써서 
//			-> 유지보수 용이
//		- DB ORM(Object Relationship Mapping) Framework
//			-> 자동으로 Java 객체로
//		- 자체적으로 ConnectionPool 내장

// Maven에 넣기 (복붙 이용)
// 		ojdbc7 or 8
//		mybatis 
public class ConnectMain {
	public static void main(String[] args) {
		SqlSession ss = null; // 기존의 Connection
		
		// 예외처리 안해도 됨 -> 근데 할거임
		try {
			InputStream is = Resources.getResourceAsStream("aaa.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			ss = ssf.openSession();
			
			System.out.println("연결성공");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// ss만 닫으면 됨
		ss.close();
		
	}
}
