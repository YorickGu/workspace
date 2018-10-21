package com.java.study_2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
                try {
                    q.set("张三", "男");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    q.set("李四", "女");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i = (i + 1) % 2;
        }
    }
}

class Consumer implements Runnable {
    P q = null;

    public Consumer(P q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            try {
                q.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class P {

    boolean flag = false;
    private String name = "李四";
    private String sex = "女";

    private Lock lock = new ReentrantLock();
    private Condition pro = lock.newCondition();
    private Condition com = lock.newCondition();

    public void set(String name, String sex) throws InterruptedException {
        lock.lock();
        try {
            while (flag) {
                pro.await();
            }
            this.name = name;
            this.sex = sex;
            flag = true;
            com.signal();
        } finally {
            lock.unlock();//释放锁的动作一定要执行
        }
    }

    public void get() throws InterruptedException {
        lock.lock();
        try {
            while (!flag) {
                com.await();
            }
            System.out.println(this.name + "-->" + this.sex);
            flag = false;
            pro.signal();
        } finally {
            lock.unlock();
        }
    }
}

public class ThreadCommmuncation_2 {
    public static void main(String[] args) {
        P q = new P();
        Producer p1 = new Producer(q);
        Producer p2 = new Producer(q);
        Consumer c1 = new Consumer(q);
        Consumer c2 = new Consumer(q);
        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}
