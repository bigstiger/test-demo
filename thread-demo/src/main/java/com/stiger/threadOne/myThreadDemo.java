package com.stiger.threadOne;

/**
 * @author YZ
 * @create 2019-03-23-19:53
 * @copy 本项目归本人私有, 未经许可, 不得擅用, 有违必究
 */

/**
 * 创建线程方式1: 继承Thread类
 * 步骤:
 *      A: 自定义MyThread继承Thread类
 *      B: MyThread类里面重写run()
 *          为什么要重写run()方法?
 *              不是类中的所有代码都要被线程执行的.Java提供了Thread类中的run()用来包含那些被线程执行的代码
 *      C: 创建MyThread对象
 *      D: 启动线程
 */
public class myThreadDemo {
    public static void main(String[] args) {
        myThread my1 = new myThread();
        myThread my2 = new myThread();

        my1.start();
        my2.start();
    }
}
