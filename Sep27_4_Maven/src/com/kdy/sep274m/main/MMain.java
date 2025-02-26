package com.kdy.sep274m.main;

import org.json.simple.parser.JSONParser;
import org.xmlpull.v1.XmlPullParser;

// Java : 개발자들이 작업물을 공유하는 문화
//		남이 만든거 프로젝트에 넣고 개발..
//	=> 발전해 중앙제어시스템 (Maven, Gradle, ...) 

// Maven
//	1) .jar 수동관리 -> Maven으로 관리하게 바꾸기
//			=> pom.xml
//	2) 쓰고싶은 라이브러리의 maven 소스를 구하기
//		mvnrepository.com
//		알아서 구하기
//	3) pom.xml에 
//		<dependencies>
//			2)를 여기에 붙이기
//		</dependencies>
//		=> maven 중앙 저장소에서 자동으로 .jar 받아와서
//			PC의 로컬 저장소에 저장 
//				C:\사용자\계정\.m2\repository ( C:\Users\soldesk\.m2\repository )
//			프로젝트에 쓸 수 있게 세팅해줌

public class MMain {
	public static void main(String[] args) {
		XmlPullParser x;
		JSONParser jp;
	}
}
