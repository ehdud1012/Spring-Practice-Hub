package com.kdy.oct071sdi.product;

import org.springframework.beans.factory.annotation.Autowired;

public class CVStore {
	
	// aac 방식
	// context:annotation-config
	// beans에 등록된 그 하나뿐인 도시락
	@Autowired 
	private LunchBox lunchBox;
	
	// 생성자 X
	// setter X
	
	public void print() {
		lunchBox.print();
	}
}
