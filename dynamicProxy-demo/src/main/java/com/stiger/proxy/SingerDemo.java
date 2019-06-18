package com.stiger.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SingerDemo {
	
	public static void main(String[] args) {
		/**
		 * 类的内部调用外部属性,必须添加final关键字
		 * 原因:
		 * 		1. 生命周期 (延长hebe生命周期: 从栈中转移常量池中,保证在proxy需要的时候,hebe还存在)
		 * 
		 * JDK1.8 及以上:final被隐藏,JVM会在运行时再加上
		 */
		final Hebe hebe = new Hebe();
		/**
		 * 动态代理: 
		 * 		1. 代理类动态加载的(由被代理类对象(房东)授权 : 加载器,接口)
		 * 		2. 代理类对象对 房东进行 方法拦截  (代理类对象和房东实现同一套接口,你有的接口方法,我也有)
		 * 作用: 不修改原类,不增加新的类,可以动态的添加功能或者拦截方法
		 */
		ClassLoader loader = hebe.getClass().getClassLoader();
		Class<?>[] interfaces = hebe.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				String name = method.getName();
				if("sing".equals(name)){
					int money = (int) args[0];
					if(money > 500){
						method.invoke(hebe, args);
					}
				}else if("dance".equals(name)){
					int money = (int) args[0];
					if(money > 10000){
						method.invoke(hebe, args);
					}
				}else if("sleep".equals(name)){
					System.out.println("滚犊子~~");
				}
				return null;
			}
		};
		// 向上转型
		Singer proxy = (Singer) Proxy.newProxyInstance(loader, interfaces, h);
//		proxy.sing(1000);
//		proxy.dance(20000);
//		proxy.sleep();
	}
}

interface Singer{
	void sing(int money);
	void dance(int money);
	void sleep();
}

class Hebe implements Singer{
	@Override
	public void sing(int money) {
		System.out.println("hebe在唱歌:小幸运");
	}
	@Override
	public void dance(int money) {
		System.out.println("hebe在跳舞");
	}
	@Override
	public void sleep() {
		System.out.println("hebe很累了,Zzzzz...");
	}
}