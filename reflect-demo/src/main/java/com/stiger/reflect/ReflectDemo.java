package com.stiger.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射: 程序运行过程中操作类
 * 0. 基于Class对象
 * 1. 作用
 * 		1. 框架
 * 		2. 访问私有方法和属性
 */
public class ReflectDemo {
	
	public static void main(String[] args) {
//		Student s = new Student();
//		System.out.println(s);
		Student s2 = new Student("柳岩", 18);
		
	}
	@Test
	public void demo3() throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		//1.获取Student的Class对象
		Class<?> clazz = Student.class;
		//2.获取Class对象的构造方法,并实现化对象
		//只能public的构造器对象
//		clazz.getConstructor(parameterTypes)
		//Declared声明过的构造器都能访问,包括私有
		Constructor<?> c = clazz.getDeclaredConstructor(String.class,int.class,int.class);
		//访问私有方法,给我开放访问权限(暴力访问)
		c.setAccessible(true);
		
		Object oc = c.newInstance("高圆圆",19,9527);
		System.out.println(oc);
	}
	@Test
	public void demo2() throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		//1.获取Student的Class对象
		Class<?> clazz = Student.class;
		//2.获取Class对象的构造方法,并实现化对象
		/**
		 * parameterTypes : 参数类型的Class对象
		 * 不同的形参列表 -> 对应的构造方法
		 */
		Constructor<?> c = clazz.getConstructor(String.class,int.class);
		//3. 创建对象
		Object ly = c.newInstance("柳岩",18);
		System.out.println(ly);
	}
	@Test
	public void demo1() throws InstantiationException, IllegalAccessException{
		//1.获取Student的Class对象
		Class<?> clazz = Student.class;
		//2.获取Class对象的构造方法,并实现化对象(默认调用空参构造)
		Student s = (Student) clazz.newInstance();
		System.out.println(s);
	}
}
