package com.kdy.oct101sm.menu;

import java.util.List;

public interface MenuMapper {
	// insert / update / delete : int
	// select : resultType 맞춰서
	
	// 메소드명 : mapper.xml의 id랑 같게
	// parameter : mapper.xml의 parameterType랑 같게
	public abstract int menuReg(Menu m);
	public abstract List<Menu> menuSelect();
}
