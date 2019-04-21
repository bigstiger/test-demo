package com.stiger.runnable;

/**
 * @author YZ
 * @create 2019-04-16-22:59
 * @copy 本项目归本人私有, 未经许可, 不得擅用, 有违必究
 */

/**
 * 创建线程方式2: 实现Runnable接口
 * 步骤:
 *      A: 自定义MyRunnable实现Runnable接口
 *      B: 重写run()方法
 *      C: 创建MyRunnable类的对象
 *      D: 创建Thread类的对象, 并把C步骤的对象作为构造参数传递
 */
public class MyRunnableDemo {
    public static void main(String[] args) {
        MyRunnable my = new MyRunnable();

        Thread t1 = new Thread(my);
        Thread t2 = new Thread(my);

        t1.start();
        t2.start();
    }
}
