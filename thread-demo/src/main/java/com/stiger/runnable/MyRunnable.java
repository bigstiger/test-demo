package com.stiger.runnable;

/**
 * @author YZ
 * @create 2019-04-16-23:03
 * @copy 本项目归本人私有, 未经许可, 不得擅用, 有违必究
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
