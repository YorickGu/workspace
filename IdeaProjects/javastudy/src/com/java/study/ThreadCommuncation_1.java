package com.java.study;

class Producer_1 implements Runnable {
    P_1 q = null;

    Producer_1(P_1 q) {
        this.q = q;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            if (i == 0) {
                q.set("张三","男");
            } else {
                q.set("李四","女");
            }
            i = (i + 1) % 2;
        }
    }
}

class Consuer_1 implements Runnable {
    P_1 p = null;

    Consuer_1(P_1 p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.get();
        }

    }
}

class P_1 {
    private String name = "张三";
    private String sex = "李四";
    boolean bFull = false;
    public synchronized void set(String name,String sex){
        if(bFull){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.sex = sex;
        bFull = true;
        notify();
    }

    public synchronized void get(){
        if (!bFull){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+"-->"+sex);
        bFull = false;
        notify();
    }
}

/**
 * @author pf_engineering
 * */
public class ThreadCommuncation_1 {
    public static void main(String[] args) {
        P_1 p = new P_1();
        new Thread(new Consuer_1(p)).start();
        new Thread(new Producer_1(p)).start();
    }
}
