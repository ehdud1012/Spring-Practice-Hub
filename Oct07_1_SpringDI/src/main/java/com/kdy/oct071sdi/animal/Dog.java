package com.kdy.oct071sdi.animal;

public class Dog {
	private String name;
	private int age;

	private static String barkSound = "멍";
	
	public Dog() {
		
	}

	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public static void printBarkSound() {
		System.out.println(barkSound);
	}
	
	public void print() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(barkSound);
	}
}
