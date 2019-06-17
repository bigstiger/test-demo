package com.stiger.classd;

import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * 	1. java类加载机制: -> Class对象
 * 
 * 	反射:
 * 		是运行时操作类(Class对象)
 * 
 * 	2. 三种类加载器
		1. 引导类加载器（Bootstrap ClassLoader）
			1. 负责加载$JAVA_HOME中jre/lib/rt.jar里所有的class，由C++实现，不是ClassLoader子类
		2. 扩展类加载器（Extension ClassLoader）
			1. 负责加载java平台中扩展功能的一些jar包，包括$JAVA_HOME中jre/lib/*.jar（jre/lib/ext)
			2. Properties -> BuildPath -> Library  -> JRE System -> Access rules -> Edit -> add -> sun/** 
		3. 应用类加载器：（Application ClassLoader）
			1. 加载编写的代码
				
		4. 继承关系
			1. 引导类加载器由C++实现，不是ClassLoader子类（属于JVM的一部分）
			2. 扩展类加载器是引导类加载器子类 (组合形式)
			3. 应用类加载器是扩展类加载器子类 
 *
 *		String.class : 获取String的Class对象
 *		Class对象是jvm加载类的过程创建的,我们无法创建,一个类只有一个Class对象
 *
 *  JVM如何保证一个类只被加载一次? -> 三种类加载器是如何分配任务的!
 *  	双亲委派机制
 *  	1. 如果一个类加载器收到了类加载的请求，它首先不会自己去尝试加载这个类，而是把这个请求委派给父类加载器去完成，每一个层次的加载器都是如此，因此所有的类加载请求都会传给顶层的启动类加载器
		2. 只有当父加载器反馈自己无法完成该加载请求（该加载器的搜索范围中没有找到对应的类）时，子加载器才会尝试自己去加载。
		
	类加载只会被加载一次,static代码块只执行,Class对象就只会有一个!(锁对象)
 */
public class ClassDemo {
	
	public static void main(String[] args) {
		ClassLoader classLoader = String.class.getClassLoader();
		//null  -> 引导类加载器(C/C++)  -> 加载核心包
		System.out.println(classLoader);
		
		ClassLoader classLoader2 = DNSNameService.class.getClassLoader();
		//sun.misc.Launcher$ExtClassLoader 扩展类加载器(java)->加载扩展包
		System.out.println(classLoader2);
		System.out.println("2f:" + classLoader2.getParent());
		
		ClassLoader classLoader3 = ClassDemo.class.getClassLoader();
		//sun.misc.Launcher$AppClassLoader 应用类加载器(java) -> 前两者不加载的,都加载(第三方)
		System.out.println(classLoader3);
		System.out.println("3f:" + classLoader3.getParent());
		
	}
}
