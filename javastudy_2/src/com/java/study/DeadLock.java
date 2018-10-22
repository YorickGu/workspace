package com.java.study;

class A {
    synchronized void funA(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + "进入A.foo");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "调用B类中的last（）方法");
        b.last();
    }

    synchronized void last() {
        System.out.println("A类中的last（）方法");
    }
}

class B {
    synchronized void funB(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + "进入B.foo");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "调用A类中的last（）方法");
        a.last();
    }

    synchronized void last() {
        System.out.println("B类中的last（）方法");
    }
}

public class DeadLock implements Runnable {

    A a = new A();
    B b = new B();

    DeadLock() {
        Thread.currentThread().setName("main->Thread");
        new Thread(this).start();
        a.funA(b);
        System.out.println("main线程运行完毕");
    }

    public static void main(String[] args) {
        new DeadLock();
    }

    @Override
    public void run() {
        Thread.currentThread().setName("test->Thread");
        b.funB(a);
        System.out.println("其他线程运行完毕");
    }
}
