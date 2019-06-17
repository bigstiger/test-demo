package com.stiger.reflect;

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
	private String name;
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

}
