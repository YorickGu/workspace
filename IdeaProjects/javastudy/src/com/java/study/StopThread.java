package com.java.study;

class ThreadDemo_8 implements Runnable{
boolean flag = true;
public void stopMe(){
    flag = false;
}
    @Override
    public void run() {
        while (flag){
            Thread.currentThread().setName("TestThread");
            System.out.println(Thread.currentThread().getName()+"正在运行");
        }
    }
}

public class StopThread {
    public static void main(String[] args) {
        ThreadDemo_8 t8 = new ThreadDemo_8();
        Thread t = new Thread(t8);
        t.start();
        for(int i = 0;i<10;i++){
            if (i==5){
                t8.stopMe();
            }
            System.out.println("main Thread is running");

        }
    }
}
