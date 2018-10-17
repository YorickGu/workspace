package com.java.study;

class Producer implements Runnable {
    P q = null;

    public Producer(P q) {
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

class P{
    private String name = "李四";
    private String sex = "女";

    public synchronized void set(String name,String sex){
        this.name = name;
        this.sex = sex;
    }

    public synchronized void get(){
        System.out.println(this.name+"-->"+this.sex);
    }
}

class Consumer implements Runnable{
     P q = null;
     public Consumer(P q){
         this.q =q;
     }
    @Override
    public void run() {
        while (true){
            q.get();
        }
    }
}

public class ThreadCommuncation {
    public static void main(String[] args) {
        P q = new P();
        Producer p1 = new Producer(q);
        Consumer c1 = new Consumer(q);
        new Thread(p1).start();
        new Thread(c1).start();
    }
}
