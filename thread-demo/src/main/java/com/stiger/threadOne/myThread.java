package com.stiger.threadOne;

/**
 * @author YZ
 * @create 2019-03-23-19:51
 * @copy 本项目归本人私有, 未经许可, 不得擅用, 有违必究
 */
public class myThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++){
            System.out.println(getName() + "---" + i);
        }
    }
}
