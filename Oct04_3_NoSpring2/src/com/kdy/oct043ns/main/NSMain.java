package com.kdy.oct043ns.main;

import com.kdy.oct043ns.avengers.Avengers;
import com.kdy.oct043ns.avengers.Hulk;
import com.kdy.oct043ns.avengers.IronMan;

public class NSMain {
	public static void main(String[] args) {
		// 1. 의사소통 문제 해결
		// 2. 유지보수 양은 줄었지만 해결 X
		Avengers a = new IronMan();
		a.attack();
		a = new Hulk();
		a.attack();
	}
}
