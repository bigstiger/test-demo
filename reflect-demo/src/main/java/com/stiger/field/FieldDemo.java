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
		//1. Class����
		Class<?> clazz = Student.class;
		Field nameField = clazz.getDeclaredField("name");
		nameField.setAccessible(true);
		
//		Student s = new Student();
		Student s = (Student)clazz.newInstance();
		nameField.set(s, "��ԲԲ");
		
		System.out.println(s);
	}
	@Test
	public void demo1() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException{
		//1. Class����
		Class<?> clazz = Student.class;
		//2. ��ȡ���Զ���
		//name: ��Ӧ�����Զ���ı�����
		Field field = clazz.getField("number");
		/**
		 * obj: �ĸ�������Ҫ���ø�����ֵ
		 * value: ���õ�����ֵ
		 */
		Object obj = clazz.newInstance();
		field.set(obj, 9537);
		
		System.out.println(obj);
		
	}
}
