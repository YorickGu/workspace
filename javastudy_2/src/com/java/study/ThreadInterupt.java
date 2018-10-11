package com.java.study;

public class ThreadInterupt implements Runnable{
    @Override
    public void run(){
        System.out.println("在run方法中-这个线程休眠20秒");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            System.out.println("在run方法中中断该线程");
            return;
        }
        System.out.println("在run方法中-休眠之后继续完成任务");
        System.out.println("在run方法中-正常退出");
    }

    public static void main(String[] args) {
        ThreadInterupt ti = new ThreadInterupt();
        Thread t = new Thread(ti);
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("在main函数中-中断其他线程");
        t.interrupt();
        System.out.println("在main方法中-退出");
    }

}
