package com.kdy.oct071sdi.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class LunchBox {
	private String name;
	private int price;
	private HashMap<String, Double> sideDishes;
	
	public LunchBox() {
		// TODO Auto-generated constructor stub
	}

	public LunchBox(String name, int price, HashMap<String, Double> sideDishes) {
		super();
		this.name = name;
		this.price = price;
		this.sideDishes = sideDishes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public HashMap<String, Double> getSideDishes() {
		return sideDishes;
	}

	public void setSideDishes(HashMap<String, Double> sideDishes) {
		this.sideDishes = sideDishes;
	}
	public void print() {
		System.out.println(name);
		System.out.println(price);
		Set<String> what = sideDishes.keySet();
		ArrayList<String> what2 = new ArrayList<String>(what);
		for (String string : what2) {
			System.out.println(string + " : " +sideDishes.get(string));
		}
	}

}
