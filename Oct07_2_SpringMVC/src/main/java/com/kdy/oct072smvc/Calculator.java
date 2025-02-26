package com.kdy.oct072smvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

// 계산하는 M / DAO : singleton

// M쪽에 유지보수 거리가 있으면 1번 / 단순 singleton이면 2번
//	1번
// 		1-1) servlet-context.xml에 등록 
//			<beans:bean id="calculatorM" class="com.kdy.oct072smvc.Calculator"></beans:bean>
// 		1-2) C에서 연결
//			@Autowired
//			private Calculator c;
//	2번
//		2-1) @Service 를 써서 servlet-context.xml에 등록시킨 효과
//		2-2) 1-1과 동일


// 결과 처리 = 쓰던 그대로
@Service
public class Calculator {
	public void claculate(XYxy xy, HttpServletRequest req) {
		int result = xy.getX() + xy.getY();
		req.setAttribute("result", result);
	}
}