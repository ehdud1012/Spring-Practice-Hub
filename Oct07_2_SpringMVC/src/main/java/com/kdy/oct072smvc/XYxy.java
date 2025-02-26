package com.kdy.oct072smvc;

// Spring이 req param 받아서 JavaBean객체로 만들어줌

//	멤버변수명  = req param
public class XYxy {
	private int x;
	private int y;
	
	public XYxy() {
		// TODO Auto-generated constructor stub
	}

	public XYxy(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
