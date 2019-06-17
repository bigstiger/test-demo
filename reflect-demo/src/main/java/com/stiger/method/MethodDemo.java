package com.stiger.method;

import org.junit.Test;

import java.lang.reflect.Method;

public class MethodDemo {
	public static void main(String[] args) {
		Student s = new Student();
		s.show();
	}
	@Test
	public void demo2() throws Exception{
		Student s = new Student();
		Class<?> clazz = s.getClass();
		Method method = clazz.getDeclaredMethod("speak", String.class,int.class);
		//��������
		method.setAccessible(true);
		method.invoke(s, "����",18);
	}
	@Test
	public void demo1() throws Exception{
		//�÷�������
		Class<?> clazz = Class.forName("com.stiger.method.Student");
		//1. ��ȡ��������
		/**
		 * Ψһȷ��һ������
		 * name : ������
		 * 	parameterTypes : �β��б��Class����
		 */
		Method method = clazz.getMethod("show");
		Object obj = clazz.newInstance();
		/**
		 * ��ͨ��������,��Ҫ��������(��̬����Ҫ)
		 */
		method.invoke(obj);
		
	}
}
