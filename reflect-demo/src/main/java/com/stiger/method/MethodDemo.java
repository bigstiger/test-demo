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
		//暴力访问
		method.setAccessible(true);
		method.invoke(s, "柳岩",18);
	}
	@Test
	public void demo1() throws Exception{
		//让方法反射
		Class<?> clazz = Class.forName("com.stiger.method.Student");
		//1. 获取方法对象
		/**
		 * 唯一确定一个方法
		 * name : 方法名
		 * 	parameterTypes : 形参列表的Class对象
		 */
		Method method = clazz.getMethod("show");
		Object obj = clazz.newInstance();
		/**
		 * 普通方法调用,需要依赖对象(静态不需要)
		 */
		method.invoke(obj);
		
	}
}
