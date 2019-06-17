package com.stiger.classd;

/**
 * 1. Class����
	1. ���䣺������ʱͨ����������ࡣ������֪��������࣬�ɵ����߸�֪��
		1. Ҫ�������ؾͱ����Ȼ�ø�����ֽ������Class ����
		2. ����ʵ�������ַ�ʽ��
			1. new ������ͨ������������ṹ����
			2. ���䣺ͨ��������Class�����Ӵ���
	2. ��ȡClass��������ַ�ʽ
		1. Class.forName(ȫ�޶���);			`���� + ����`
	 		1. ʹ�ó��� : �����ⲿ�������ļ�.
	 	2. ����.class;
			1. ʹ�ó���: ȷ�������β�����.
			2. ȷ���������������������أ�: 1. ������.	2. �����б�
		3. ������.getClass();
 			1. ʹ�ó��� : �����ڲ�ȷ���βε���ʵ����.
 */
public class ClassObjectDemo {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> forName = Class.forName("com.stiger.classd.Student");
		System.out.println(forName); //class com.stiger.classd.Student
		
		Class<?> clazz =  Student.class;
		System.out.println(clazz); //class com.stiger.classd.Student
		
		Student s = new Student();
		Class<? extends Student> clazz2 = s.getClass();
		System.out.println(clazz2); //class com.stiger.classd.Student

	}
}
