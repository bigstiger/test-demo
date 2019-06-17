package com.stiger.entity;

import lombok.*;
import lombok.extern.java.Log;

/**
 * @ToString：作用于类，覆盖默认的toString()方法，可以通过of属性限定显示某些字段，
 * 通过exclude属性排除某些字段。
 * @EqualsAndHashCode：作用于类，覆盖默认的equals和hashCode
 * @NonNull：主要作用于成员变量和参数中，标识不能为空，否则抛出空指针异常。
 * @NoArgsConstructor, @RequiredArgsConstructor, @AllArgsConstructor：
 * 作用于类上，用于生成构造函数。有staticName、access等属性。
 * staticName属性一旦设定，将采用静态方法的方式生成实例，access属性可以限定访问权限。
 * @NoArgsConstructor：生成无参构造器；
 * @RequiredArgsConstructor：生成包含final和@NonNull注解的成员变量的构造器；
 * @AllArgsConstructor：生成全参构造器。
 * @Data：作用于类上，是以下注解的集合：
 *  @ToString @EqualsAndHashCode @Getter @Setter @RequiredArgsConstructor
 * @Builder：作用于类上，将类转变为建造者模式
 * @Log：作用于类上，生成日志变量。针对不同的日志实现产品，有不同的注解
 */
@ToString(of = {"name", "age"}, exclude = {"friendly"})
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@EqualsAndHashCode
@NoArgsConstructor(staticName = "of", access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Log
public class Person {
    @NonNull
    private String name;
    private int age;
    private boolean friendly;
}
