package com.stiger.test;

import org.junit.Test;

/**
 * @author YZ
 * @create 2019-04-16-20:01
 * @copy 本项目归本人私有, 未经许可, 不得擅用, 有违必究
 */
public class testDemo {
    public static void main(String[] args) {
    }
    @Test
    public void test01(){
        Integer i1 = new Integer(5);
        Integer i2 = new Integer(5);
        Integer i3 = 5;
        int i4 = 5;
        System.out.println("i3 == i1 = " + (i3 == i1));
        System.out.println("(i1 == i2) = " + (i1 == i2));
        System.out.println("(i1 == i4) = " + (i1 == i4));
        System.out.println("(i3 == i4) = " + (i3 == i4));
        //System.out.println("(i1.equals(i2)) = " + (i1.equals(i2)));
    }

    /**
     * 测试Integer与int
     */
    @Test
    public void test02(){
        Integer i = 10;
        Integer j = 10;
        System.out.println(i == j);

        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);

        int k = 10;
        System.out.println(k == i);
        int kk = 128;
        System.out.println(kk == a);

        Integer m = new Integer(10);
        Integer n = new Integer(10);
        System.out.println(m == n);

        System.out.println(m == k);
    }
}
