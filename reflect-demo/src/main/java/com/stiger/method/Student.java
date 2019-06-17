package com.stiger.method;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * JavaBean
 * 1. private 属性
 * 2. 空参构造
 * 3. public get set方法
 *
 */
@Getter
@Setter
@ToString
public class Student {
	public static String name;
	private int age;
	public int number;
	
	public Student(){
		
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	private Student(String name, int age, int number) {
		super();
		this.name = name;
		this.age = age;
		this.number = number;
	}
	
	public  void show(){
		System.out.println("show");
	}
	private void speak(String msg,int age){
		System.out.println("speak:" + msg);
	}
	
}
