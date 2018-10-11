package com.java.study;

public class ThreadDemo_6 {
    public static void main(String[] args) {
        TestThread tt = new TestThread();
//        Thread t = new Thread(tt);
        new Thread(tt).start();
        new Thread(tt).start();
        new Thread(tt).start();
        new Thread(tt).start();
    }
}

class TestThread implements Runnable{
    private int tickets = 50;
    @Override
    public void run() {

        while (true){
            while (tickets>0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("正在售出第"+tickets--+"张票");
            }
        }



    }
}