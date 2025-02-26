package com.kdy.oct071sdi.human;

import java.util.ArrayList;
import java.util.HashMap;

import com.kdy.oct071sdi.animal.Dog;

public class Human {
	// 기본형 급
	private String name;
	private int age;
	
	// 객체 급
	private Dog pet;
	
	// 컬렉션 급
	private String[] family;
	private ArrayList<String> nickname;
	private HashMap<String, Double> stat;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("생성자");
	}
	
	public Human(String name, int age, Dog pet) {
		super();
		this.name = name;
		this.age = age;
		this.pet = pet;
	}
	
	public Human(String name, int age, Dog pet, String[] family, ArrayList<String> nickname,
			HashMap<String, Double> stat) {
		super();
		this.name = name;
		this.age = age;
		this.pet = pet;
		this.family = family;
		this.nickname = nickname;
		this.stat = stat;
	}

	public String[] getFamily() {
		return family;
	}

	public void setFamily(String[] family) {
		this.family = family;
	}

	public ArrayList<String> getNickname() {
		return nickname;
	}

	public void setNickname(ArrayList<String> nickname) {
		this.nickname = nickname;
	}

	public HashMap<String, Double> getStat() {
		return stat;
	}

	public void setStat(HashMap<String, Double> stat) {
		this.stat = stat;
	}

	public Dog getPet() {
		return pet;
	}

	public void setPet(Dog pet) {
		this.pet = pet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("setter");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public void print() {
		System.out.println(name);
		System.out.println(age);
	}
	
}
