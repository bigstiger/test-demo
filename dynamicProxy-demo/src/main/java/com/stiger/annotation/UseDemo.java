package com.stiger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 运行时的注解要发挥作用   +  反射
 */
public class UseDemo {
	
	public static void main(String[] args) throws Exception {
//		Student s = new Student();
//		System.out.println(s);
		
		/**
		 * 1.获取类上面的注解
		 */
		Class<?> clazz = Student.class;
		Object obj = clazz.newInstance();
		//类上面是否存在MyAnnotation注解,存在为true
		boolean result = clazz.isAnnotationPresent(MyAnnotation.class);
		if(result){
			//获取类上面MyAnnotation注解
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

//使用范围
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
//保留策略(运行阶段)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
	String value();
}
