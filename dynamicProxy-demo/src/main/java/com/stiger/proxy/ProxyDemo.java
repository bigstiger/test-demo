package com.stiger.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 产品经理: 需求
 *	0. 问题: 如果更改需求,我们就要去修改我们的类
 *	        但是这个类已经在别的地方被引用,无法修改!!
 *	1. 解决: 继承
 *	   问题:  因为这样的需求,多定义一个类(重写4个方法,非常麻烦)
 *
 *  2. 解决: 动态代理 (代理模式)
 *  	1. 可以不修改原类的情况下,而且在不定义新类的前提下,就能添加功能
 *  
 *  程序员 : 产品经理      	 测试(找出越多bug)
 *        产品需求满足  ->   bug测试  ->  上线
 *        	项目经理		
 *        	
 */
public class ProxyDemo {
	
	public static void main(String[] args) {
//		ArithClass ac = new ArithClass();
//		int add = ac.add(1, 2);
//		System.out.println(add);
//		
//		int minus = ac.minus(3, 2);
//		System.out.println(minus);
//		
//		int multiply = ac.multiply(2, 3);
//		System.out.println(multiply);
//		
//		int devide = ac.devide(6, 3);
//		System.out.println(devide);
		
		final ArithClass ac = new ArithClass();
//		method(ac);
		/**
		 * (使用前提: 被代理类必须有接口)
		 * 				(代理冗余, 原类不了解或者其他地方有调用)
		 * 使用场景:在无需多定义一个类且不修改原类情况下,修改原类的功能
		 * 动态代理 
		 * 本质: 创建一个代理类对象,对被代理类对象(房东)进行方法拦截,然后跟着相应的需求修改之后,决定是否让房东执行
		 * 	1. 动态: 代理类是程序运行中动态加载的 
		 * 		1. 类加载 器 + 接口 
		 * 	2. 代理
		 * 		1. 对房东所有的方法进行代理,拦截(添加额外的部分)
		 * 		2. 本质接口的实现类
		 * 
		 * 房东                      中介                             至少使用同一套接口
		 * 
		 * 知识点:
		 * 		1. 反射
		 * 		2. 多态(接口回调)
		 *
		 * 	注意: 在Debug状态下idea会调用被代理类的toString()方法。
		 * 	代理类会代理该类的所有方法（包括toString），因此会重复输出。
		 * 	排查: 在invoke里边输出method.getName()方法就很明显看到多输出的那几次都是toString方法。
		 */
		ClassLoader loader = ac.getClass().getClassLoader(); // 代理谁,就用谁类加载器和接口
		Class<?>[] interfaces = ac.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				System.out.println("好好,我马上给你算");
				Object invoke = method.invoke(ac, args);
				System.out.println(method.getName());
				return invoke;
			}
		};
		ArithInte proxy = (ArithInte) Proxy.newProxyInstance(loader, interfaces, h);
		int multiply = proxy.multiply(2, 3);
		System.out.println(multiply);
	}

	private static void method(final ArithClass ac) {
		/**
		 * 代理: 代理原类
		 * 创建一个代理类对象实例
		 * 
		 * loader: 类加载器  (被代理类对象的类加载器)
		 * interfaces: 接口    (被代理类对象的接口)
		 * 			类加载器  + 接口  -> 动态加载代理类 (实现接口)
		 * h : InvocationHandler 调用处理器
		 * 
		 *  动态代理 (代理模式)
 *  		0. 作用: 可以不修改原类的情况下,而且在不定义新类的前提下,就能添加功能
 *  		1. 为什么?
 *  			房东                           中介 (代理类对象)               
 *  		    租房\卖房                   租房\卖房                                   中介商量完了,让房东干活
 *  				
 *  		2. 动态代理
 *  			1. 代理 : (拥有被被代理类核心方法)
 *  				1. 接口(通过接口的形式进行授权方法)
 *  				2. 本质是传入的接口实现类(拥有接口方法)
 *  			2. 动态: 代理类没有定义,是程序运行过程中动态加载的
 *  				1. 类加载器
		 */
		//ac是房东  -> 中介 (需要构建,动态加载)
		ClassLoader loader = ac.getClass().getClassLoader();
		Class<?>[] interfaces = ac.getClass().getInterfaces();
		/**
		 * 方法处理器 : 处理代理类对象调用的方法
		 */
		InvocationHandler h = new InvocationHandler() {
			/**
			 * 代理类对象调用一次方法,invoke就执行一次
			 * proxy : 代理类对象本身(基本用不上)
			 * method : 代理类对象当前调用的方法
			 * args: 代理类对象当前调用的方法所使用的参数
			 * return : 调用方法之后的返回值
			 * 
			 * proxy.add(2, 3);
			 * 
			 * method.getName = add;
			 * args = {2,3};
			 * 
			 * proxy.minus(3, 2);
			 * method.getname = minus
			 * args = {3,2};
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				//中介谈判完了(产品经理的需求加上了)
				System.out.println("^-^运算开始了哦~~");
				//应该让房东干活
				Object invoke = method.invoke(ac, args);
				return invoke;
			}
		};
		//接口 = 代理类对象(接口是代理类的父接口)   本质是向上转型
		ArithInte proxy = (ArithInte) Proxy.newProxyInstance(loader, interfaces, h);
		int add = proxy.add(2, 3);
		System.out.println(add);
		int minus = proxy.minus(3, 2);
		System.out.println(minus);
	}
}











