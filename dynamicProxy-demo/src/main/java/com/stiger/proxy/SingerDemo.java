package com.stiger.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SingerDemo {
	
	public static void main(String[] args) {
		/**
		 * ����ڲ������ⲿ����,�������final�ؼ���
		 * ԭ��:
		 * 		1. �������� (�ӳ�hebe��������: ��ջ��ת�Ƴ�������,��֤��proxy��Ҫ��ʱ��,hebe������)
		 * 
		 * JDK1.8 ������:final������,JVM��������ʱ�ټ���
		 */
		final Hebe hebe = new Hebe();
		/**
		 * ��̬����: 
		 * 		1. �����ද̬���ص�(�ɱ����������(����)��Ȩ : ������,�ӿ�)
		 * 		2. ���������� �������� ��������  (���������ͷ���ʵ��ͬһ�׽ӿ�,���еĽӿڷ���,��Ҳ��)
		 * ����: ���޸�ԭ��,�������µ���,���Զ�̬����ӹ��ܻ������ط���
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
					System.out.println("������~~");
				}
				return null;
			}
		};
		// ����ת��
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
		System.out.println("hebe�ڳ���:С����");
	}
	@Override
	public void dance(int money) {
		System.out.println("hebe������");
	}
	@Override
	public void sleep() {
		System.out.println("hebe������,Zzzzz...");
	}
}