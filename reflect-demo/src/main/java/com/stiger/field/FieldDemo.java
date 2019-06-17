package com.stiger.field;

import org.junit.Test;

import java.lang.reflect.Field;

public class FieldDemo {
	public static void main(String[] args) {
		Student s = new Student();
		s.number = 9527;
	}
	@Test
	public void demo2() throws Exception{
		//1. Class对象
		Class<?> clazz = Student.class;
		Field nameField = clazz.getDeclaredField("name");
		nameField.setAccessible(true);
		
//		Student s = new Student();
		Student s = (Student)clazz.newInstance();
		nameField.set(s, "高圆圆");
		
		System.out.println(s);
	}
	@Test
	public void demo1() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException{
		//1. Class对象
		Class<?> clazz = Student.class;
		//2. 获取属性对象
		//name: 对应的属性对象的变量名
		Field field = clazz.getField("number");
		/**
		 * obj: 哪个对象想要设置该属性值
		 * value: 设置的属性值
		 */
		Object obj = clazz.newInstance();
		field.set(obj, 9537);
		
		System.out.println(obj);
		
	}
}
