package com.stiger.threadOne;

/**
 * @author YZ
 * @create 2019-03-23-19:53
 * @copy 本项目归本人私有, 未经许可, 不得擅用, 有违必究
 */
public class myThreadDemo {
    public static void main(String[] args) {
        myThread my1 = new myThread();
        myThread my2 = new myThread();

        my1.start();
        my2.start();
    }
}
