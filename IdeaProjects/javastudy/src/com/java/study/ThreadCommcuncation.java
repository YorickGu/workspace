package com.java.study;

class Producer implements Runnable {
    P q = null;

    Producer(P q) {
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

class Consuer implements Runnable {
    P p = null;

    Consuer(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.get();
        }

    }
}

class P {
    private String name = "张三";
    private String sex = "李四";
    public void set(String name,String sex){
        this.name = name;
        this.sex = sex;
    }
    public void get(){
        System.out.println(name+"-->"+sex);
    }
}

public class ThreadCommcuncation {
    public static void main(String[] args) {
        P p = new P();
        new Thread(new Consuer(p)).start();
        new Thread(new Producer(p)).start();
    }
}
