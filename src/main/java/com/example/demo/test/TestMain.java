package com.example.demo.test;

/**
 * @Description
 * @Author lph
 * @Date 2019/8/14 11:50
 */
public class TestMain {
    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        Thread t1 = new Thread(tt,"窗口1");
        Thread t2 = new Thread(tt,"窗口2");
        Thread t3 = new Thread(tt,"窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
