package com.stiger.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ����: �������й����в�����
 * 0. ����Class����
 * 1. ����
 * 		1. ���
 * 		2. ����˽�з���������
 */
public class ReflectDemo {
	
	public static void main(String[] args) {
//		Student s = new Student();
//		System.out.println(s);
		Student s2 = new Student("����", 18);
		
	}
	@Test
	public void demo3() throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		//1.��ȡStudent��Class����
		Class<?> clazz = Student.class;
		//2.��ȡClass����Ĺ��췽��,��ʵ�ֻ�����
		//ֻ��public�Ĺ���������
//		clazz.getConstructor(parameterTypes)
		//Declared�������Ĺ��������ܷ���,����˽��
		Constructor<?> c = clazz.getDeclaredConstructor(String.class,int.class,int.class);
		//����˽�з���,���ҿ��ŷ���Ȩ��(��������)
		c.setAccessible(true);
		
		Object oc = c.newInstance("��ԲԲ",19,9527);
		System.out.println(oc);
	}
	@Test
	public void demo2() throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		//1.��ȡStudent��Class����
		Class<?> clazz = Student.class;
		//2.��ȡClass����Ĺ��췽��,��ʵ�ֻ�����
		/**
		 * parameterTypes : �������͵�Class����
		 * ��ͬ���β��б� -> ��Ӧ�Ĺ��췽��
		 */
		Constructor<?> c = clazz.getConstructor(String.class,int.class);
		//3. ��������
		Object ly = c.newInstance("����",18);
		System.out.println(ly);
	}
	@Test
	public void demo1() throws InstantiationException, IllegalAccessException{
		//1.��ȡStudent��Class����
		Class<?> clazz = Student.class;
		//2.��ȡClass����Ĺ��췽��,��ʵ�ֻ�����(Ĭ�ϵ��ÿղι���)
		Student s = (Student) clazz.newInstance();
		System.out.println(s);
	}
}
