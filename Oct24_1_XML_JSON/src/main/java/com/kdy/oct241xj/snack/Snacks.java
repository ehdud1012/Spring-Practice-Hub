package com.kdy.oct241xj.snack;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// JavaBean 생성 - DB에 있는 테이블를 표현가능한

@XmlRootElement
public class Snacks {
	private List<Snack> snack; // 변수명 : 단수형 추천
	
	public Snacks() {
		// TODO Auto-generated constructor stub
	}

	public List<Snack> getSnack() {
		return snack;
	}

	@XmlElement
	public void setSnack(List<Snack> snack) {
		this.snack = snack;
	}

	public Snacks(List<Snack> snack) {
		super();
		this.snack = snack;
	}
}
