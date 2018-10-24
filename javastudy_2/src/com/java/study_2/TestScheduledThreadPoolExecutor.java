package com.java.study_2;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * ThreadPool_Demo
 *
 * @author gyj
 * */
public class TestScheduledThreadPoolExecutor {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("===========");
            }
        },1000,5000, TimeUnit.MICROSECONDS);

        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.nanoTime());
            }
        },1000,2000,TimeUnit.MICROSECONDS);
    }
}
