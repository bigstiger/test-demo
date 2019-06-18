package com.stiger.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ��Ʒ����: ����
 *	0. ����: �����������,���Ǿ�Ҫȥ�޸����ǵ���
 *	        ����������Ѿ��ڱ�ĵط�������,�޷��޸�!!
 *	1. ���: �̳�
 *	   ����:  ��Ϊ����������,�ඨ��һ����(��д4������,�ǳ��鷳)
 *
 *  2. ���: ��̬���� (����ģʽ)
 *  	1. ���Բ��޸�ԭ��������,�����ڲ����������ǰ����,������ӹ���
 *  
 *  ����Ա : ��Ʒ����      	 ����(�ҳ�Խ��bug)
 *        ��Ʒ��������  ->   bug����  ->  ����
 *        	��Ŀ����		
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
		 * (ʹ��ǰ��: ������������нӿ�)
		 * 				(��������, ԭ�಻�˽���������ط��е���)
		 * ʹ�ó���:������ඨ��һ�����Ҳ��޸�ԭ�������,�޸�ԭ��Ĺ���
		 * ��̬���� 
		 * ����: ����һ�����������,�Ա����������(����)���з�������,Ȼ�������Ӧ�������޸�֮��,�����Ƿ��÷���ִ��
		 * 	1. ��̬: �������ǳ��������ж�̬���ص� 
		 * 		1. ����� �� + �ӿ� 
		 * 	2. ����
		 * 		1. �Է������еķ������д���,����(��Ӷ���Ĳ���)
		 * 		2. ���ʽӿڵ�ʵ����
		 * 
		 * ����                      �н�                             ����ʹ��ͬһ�׽ӿ�
		 * 
		 * ֪ʶ��:
		 * 		1. ����
		 * 		2. ��̬(�ӿڻص�)
		 *
		 * 	ע��: ��Debug״̬��idea����ñ��������toString()������
		 * 	�����������������з���������toString������˻��ظ������
		 * 	�Ų�: ��invoke������method.getName()�����ͺ����Կ�����������Ǽ��ζ���toString������
		 */
		ClassLoader loader = ac.getClass().getClassLoader(); // ����˭,����˭��������ͽӿ�
		Class<?>[] interfaces = ac.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				System.out.println("�ú�,�����ϸ�����");
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
		 * ����: ����ԭ��
		 * ����һ�����������ʵ��
		 * 
		 * loader: �������  (�������������������)
		 * interfaces: �ӿ�    (�����������Ľӿ�)
		 * 			�������  + �ӿ�  -> ��̬���ش����� (ʵ�ֽӿ�)
		 * h : InvocationHandler ���ô�����
		 * 
		 *  ��̬���� (����ģʽ)
 *  		0. ����: ���Բ��޸�ԭ��������,�����ڲ����������ǰ����,������ӹ���
 *  		1. Ϊʲô?
 *  			����                           �н� (���������)               
 *  		    �ⷿ\����                   �ⷿ\����                                   �н���������,�÷����ɻ�
 *  				
 *  		2. ��̬����
 *  			1. ���� : (ӵ�б�����������ķ���)
 *  				1. �ӿ�(ͨ���ӿڵ���ʽ������Ȩ����)
 *  				2. �����Ǵ���Ľӿ�ʵ����(ӵ�нӿڷ���)
 *  			2. ��̬: ������û�ж���,�ǳ������й����ж�̬���ص�
 *  				1. �������
		 */
		//ac�Ƿ���  -> �н� (��Ҫ����,��̬����)
		ClassLoader loader = ac.getClass().getClassLoader();
		Class<?>[] interfaces = ac.getClass().getInterfaces();
		/**
		 * ���������� : ��������������õķ���
		 */
		InvocationHandler h = new InvocationHandler() {
			/**
			 * ������������һ�η���,invoke��ִ��һ��
			 * proxy : �����������(�����ò���)
			 * method : ���������ǰ���õķ���
			 * args: ���������ǰ���õķ�����ʹ�õĲ���
			 * return : ���÷���֮��ķ���ֵ
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
				//�н�̸������(��Ʒ��������������)
				System.out.println("^-^���㿪ʼ��Ŷ~~");
				//Ӧ���÷����ɻ�
				Object invoke = method.invoke(ac, args);
				return invoke;
			}
		};
		//�ӿ� = ���������(�ӿ��Ǵ�����ĸ��ӿ�)   ����������ת��
		ArithInte proxy = (ArithInte) Proxy.newProxyInstance(loader, interfaces, h);
		int add = proxy.add(2, 3);
		System.out.println(add);
		int minus = proxy.minus(3, 2);
		System.out.println(minus);
	}
}











