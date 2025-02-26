package com.kdy.sep275m.main;

import org.xmlpull.v1.XmlPullParser;

import com.kdy.db.manager.KdyDBManager;

import oracle.jdbc.driver.OracleDriver;

// 늘 하던거 하기 때문에
//	-> 늘 비슷한 라이브러리 사용

// 이번 프로젝트에도 kxml사용
// - 저번 프로젝트에서 Maven 시스템 써서 로컬저장소에 kxml 받아놨음

// 한번이라도 Maven 사용한 파일이라면 
// pom.xml 아래 탭의 dependencies에서 add해서 찾아서 넣기
// 	실전 - 그냥 많이 쓰는 파일들 메모장에 저장해놓음

// Maven 중앙저장소에 없는거 (자체 제작한거)
//		- 자체 제작한거
//			메이븐과 수동관리 병행 불가
//			자체 제작한걸 메이븐 시스템에 넣어서 사용
//		- 진짜 없는거
//			따로 받는거 메이븐 시스템에 넣어서 사용
//			or 
//			사설 저장소에서 따로 가져오기

public class MMain {
	public static void main(String[] args) {
		XmlPullParser x;
		KdyDBManager.close(null, null, null);
		OracleDriver od;
	}
}
