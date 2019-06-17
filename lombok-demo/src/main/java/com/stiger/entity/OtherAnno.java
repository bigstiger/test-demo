package com.stiger.entity;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Cleanup：自动关闭资源，针对实现了java.io.Closeable接口的对象有效，如：典型的IO流对象
 * @SneakyThrows：可以对受检异常进行捕捉并抛出，可以改写上述的main方法如下
 */
public class OtherAnno {
    //@SneakyThrows //加上之后就不用抛出异常了
    public static void main(String[] args) throws Exception {
        File file = new File("d:\\test.txt");
        @Cleanup InputStream inputStream = new FileInputStream(file);
        int len = 0;
        byte[] bs = new byte[1024];
        while ((len = inputStream.read(bs)) != -1){
            System.out.println("content: " + new String(bs, 0, len));
        }
    }
}
