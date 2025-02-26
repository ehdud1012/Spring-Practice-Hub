package com.kdy.oct082smvc;

public class UCResult {
	private String num;
	private String unit1;
	private double result;
	private String unit2;
	private String unit;
	
	public UCResult() {
		// TODO Auto-generated constructor stub
	}

	public UCResult(String num, String unit1, double result, String unit2, String unit) {
		super();
		this.num = num;
		this.unit1 = unit1;
		this.result = result;
		this.unit2 = unit2;
		this.unit = unit;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getUnit1() {
		return unit1;
	}

	public void setUnit1(String unit1) {
		this.unit1 = unit1;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public String getUnit2() {
		return unit2;
	}

	public void setUnit2(String unit2) {
		this.unit2 = unit2;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	
}
