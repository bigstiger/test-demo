package com.stiger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ����ʱ��ע��Ҫ��������   +  ����
 */
public class UseDemo {
	
	public static void main(String[] args) throws Exception {
//		Student s = new Student();
//		System.out.println(s);
		
		/**
		 * 1.��ȡ�������ע��
		 */
		Class<?> clazz = Student.class;
		Object obj = clazz.newInstance();
		//�������Ƿ����MyAnnotationע��,����Ϊtrue
		boolean result = clazz.isAnnotationPresent(MyAnnotation.class);
		if(result){
			//��ȡ������MyAnnotationע��
			MyAnnotation mt = clazz.getAnnotation(MyAnnotation.class);
			String value = mt.value();
			System.out.println(value);
		}
		
		Field field = clazz.getField("name");
		if(field.isAnnotationPresent(MyAnnotation.class)){
			MyAnnotation mt = field.getAnnotation(MyAnnotation.class);
			String value = mt.value();
//			System.out.println(value);
			field.set(obj, value);
		}
		System.out.println(obj);
		
		Method method = clazz.getMethod("show",String.class);
		if(method.isAnnotationPresent(MyAnnotation.class)){
			MyAnnotation mt = method.getAnnotation(MyAnnotation.class);
			String value = mt.value();
			method.invoke(obj, value);
			
		}
	}
}

@MyAnnotation("clazz222")
class Student{
	@MyAnnotation("zs")
	public String name;
	
	@MyAnnotation("meizi")
	@Deprecated
	public void show(String msg){
		System.out.println("show:" + msg);
	}
	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	
}

//ʹ�÷�Χ
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
//��������(���н׶�)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
	String value();
}
