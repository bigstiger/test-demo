package com.stiger.classd;

/**
 * 1. Class对象
	1. 反射：在运行时通过代码操作类。（无需知道具体的类，由调用者告知）
		1. 要想操作类必就必须先获得该类的字节码对象Class 对象
		2. 创建实例的两种方式：
			1. new 类名：通过方法区的类结构创建
			2. 反射：通过堆区的Class对象间接创建
	2. 获取Class对象的三种方式
		1. Class.forName(全限定名);			`包名 + 类名`
	 		1. 使用场景 : 加载外部的配置文件.
	 	2. 类名.class;
			1. 使用场景: 确定方法形参类型.
			2. 确定方法的两个条件（重载）: 1. 方法名.	2. 参数列表
		3. 对象名.getClass();
 			1. 使用场景 : 方法内部确定形参的真实类型.
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
