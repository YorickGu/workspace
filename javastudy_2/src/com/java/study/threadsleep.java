package com.java.study;

/**
 * @author guyao
 */
public class threadsleep extends Thread {
    @Override
    public void run() {
        try {
            loop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void loop() throws InterruptedException {
        String name = Thread.currentThread().getName();
        System.out.println(name + "-->>刚进入loop方法");
        int end = 20;
        for (int i = 0; i < end; i++) {
            Thread.sleep(2000);
            System.out.println("name=  "+name);
        }
        System.out.println(name + "-->>离开方法");

    }

    public static void main(String[] args) throws InterruptedException {
        threadsleep ts = new threadsleep();
        ts.setName("my worker thread");
        ts.start();
        Thread.sleep(700);
        ts.loop();
    }
}


