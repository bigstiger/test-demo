package com.stiger.threadOne;

import java.util.Date;

/**
 * @author YZ
 * @create 2019-03-23-19:51
 * @copy 本项目归本人私有, 未经许可, 不得擅用, 有违必究
 */
public class myThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++){
            System.out.println(getName() + "---" + i + new Date());
            try {
                //线程睡眠,但不太精确,受电脑性能的影响
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //线程礼让:一定程度上让线程执行的更和谐(cpu的使用时间更均匀),但不能保证完全一致
            //Thread.yield();
        }
    }
}
