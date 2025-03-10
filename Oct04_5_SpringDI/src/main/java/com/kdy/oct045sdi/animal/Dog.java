package com.kdy.oct045sdi.animal;

public class Dog {
	private String name;
	private int age;
	
	public Dog() {
		System.out.println("기본 생성자");
	}

	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("오버로딩된 생성자");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("셋네임");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
	}
}
