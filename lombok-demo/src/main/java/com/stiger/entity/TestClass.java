package com.stiger.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @Getter/@Setter:
 * 作用类上，生成所有成员变量的getter/setter方法；
 * 作用于成员变量上，生成该成员变量的getter/setter方法。
 * 可以设定访问权限及是否懒加载等。
 */
@SuppressWarnings("unused")
public class TestClass {

    public static void main(String[] args) {

    }

    @Getter(value = AccessLevel.PUBLIC)
    @Setter(value = AccessLevel.PUBLIC)
    public static class Person {
        private String name;
        private int age;
        private boolean friendly;
    }

    /**
     * 只funny对外提供公共接口
     */
    public static class Animal {
        private String name;
        private int age;
        @Getter @Setter private boolean funny;
    }

}
