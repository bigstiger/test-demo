package com.stiger.classd;

import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * 	1. java����ػ���: -> Class����
 * 
 * 	����:
 * 		������ʱ������(Class����)
 * 
 * 	2. �����������
		1. �������������Bootstrap ClassLoader��
			1. �������$JAVA_HOME��jre/lib/rt.jar�����е�class����C++ʵ�֣�����ClassLoader����
		2. ��չ���������Extension ClassLoader��
			1. �������javaƽ̨����չ���ܵ�һЩjar��������$JAVA_HOME��jre/lib/*.jar��jre/lib/ext)
			2. Properties -> BuildPath -> Library  -> JRE System -> Access rules -> Edit -> add -> sun/** 
		3. Ӧ�������������Application ClassLoader��
			1. ���ر�д�Ĵ���
				
		4. �̳й�ϵ
			1. �������������C++ʵ�֣�����ClassLoader���ࣨ����JVM��һ���֣�
			2. ��չ������������������������ (�����ʽ)
			3. Ӧ�������������չ����������� 
 *
 *		String.class : ��ȡString��Class����
 *		Class������jvm������Ĺ��̴�����,�����޷�����,һ����ֻ��һ��Class����
 *
 *  JVM��α�֤һ����ֻ������һ��? -> ���������������η��������!
 *  	˫��ί�ɻ���
 *  	1. ���һ����������յ�������ص����������Ȳ����Լ�ȥ���Լ�������࣬���ǰ��������ί�ɸ����������ȥ��ɣ�ÿһ����εļ�����������ˣ�������е���������󶼻ᴫ������������������
		2. ֻ�е��������������Լ��޷���ɸü������󣨸ü�������������Χ��û���ҵ���Ӧ���ࣩʱ���Ӽ������Ż᳢���Լ�ȥ���ء�
		
	�����ֻ�ᱻ����һ��,static�����ִֻ��,Class�����ֻ����һ��!(������)
 */
public class ClassDemo {
	
	public static void main(String[] args) {
		ClassLoader classLoader = String.class.getClassLoader();
		//null  -> �����������(C/C++)  -> ���غ��İ�
		System.out.println(classLoader);
		
		ClassLoader classLoader2 = DNSNameService.class.getClassLoader();
		//sun.misc.Launcher$ExtClassLoader ��չ�������(java)->������չ��
		System.out.println(classLoader2);
		System.out.println("2f:" + classLoader2.getParent());
		
		ClassLoader classLoader3 = ClassDemo.class.getClassLoader();
		//sun.misc.Launcher$AppClassLoader Ӧ���������(java) -> ǰ���߲����ص�,������(������)
		System.out.println(classLoader3);
		System.out.println("3f:" + classLoader3.getParent());
		
	}
}
