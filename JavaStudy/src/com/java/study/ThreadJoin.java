package com.java.study;

public class ThreadJoin {
    public static void main(String[] args) {
        Thread_6 tt = new Thread_6();
        Thread t = new Thread(tt);
        t.start();
        int i = 0;
        int end = 1000;
        for (int x = 0; x < end; x++) {
            if (i == 500) {
                try {
                    t.join(0,100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main Thread " + i++);
        }
    }
}

class Thread_6 implements Runnable {

    @Override
    public void run() {
        String str = new String();
        int i = 0;
        int end = 1000;
        for (int x = 0; x < end; x++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i++);
        }
    }
}
