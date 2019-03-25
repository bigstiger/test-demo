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
        myThread my3 = new myThread();

        //给线程起名字
        my1.setName("线程1");
        my2.setName("线程2");
        my3.setName("线程3");

        //设置线程优先级,最大10,最小1,默认5
        //my1.setPriority(10);
        //my2.setPriority(1);

        //my1.start();
        //线程加入,写在其他线程start之前,当前线程执行完成再执行下面线程
        try {
            my1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        my2.start();
        my3.start();

        //System.out.println("主线程:" + Thread.currentThread().getName());
    }
}
