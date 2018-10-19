package com.java.study;

import java.util.LinkedList;

public class SurgeryThreadPool {

    private static Runnable createTask(final int taskID) {
        return new Runnable() {
            @Override
            //创建手术任务
            public void run() {
                System.out.println("手术开始，编号为" + taskID);
                System.out.println("正在手术中~~");
                System.out.println("手术结束，编号为" + taskID);
            }
        };
    }

    //Java程序的入口
    public static void main(String[] args) {
        //创建3个任务线程的一个线程池
        ThreadTask threadpool = new ThreadTask(3);
        //休眠600ms，让线程池中的任务线程全部运行
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            //捕获异常情况
            e.printStackTrace();
        }
        //循环创建并执行任务
        for (int i = 0; i < 3; i++) {
            threadpool.addTask(createTask(i));
        }
        //等待所有的任务执行完毕
        threadpool.waitTaskClosed();
        //关闭线程池
        threadpool.closePool();
    }
}

/**
 * 继承线程组实现实现线程池功能
 * */
class ThreadTask extends ThreadGroup {

    //线程池是否关闭
    private boolean isStop = false;
    /**
     *工作任务队列
     */
    private LinkedList queue;
    /**
     *线程池的编号
     */
    private static int pooID = 1;

    private class SurgeryTask extends Thread {

        //任务编号
        private int id;

        /**
         *构造方法进行初始化
         */
        public SurgeryTask(int id) {
            //将线程加入当卡线程组中
            super(ThreadTask.this, id + "");
            this.id = id;
        }

        @Override
        public void run() {
            //判断线程是否被中断
            while (!isInterrupted()) {
                Runnable task = null;
                //取出任务
                task = getTask(id);
                //如果getTask()返回null或者线程执行getTask()被中断，则结束此线程
                if (task == null) {
                    return;
                }
                try {
                    //运行任务
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 构造方法传入线程池中的工作线程的数量
     * */
    public ThreadTask(int size) {
        //指定线程组的名称
        super(pooID + "");
        //继承线程组的方法用于设置是否守护线程池
        setDaemon(true);
        //创建工作队列
        queue = new LinkedList();
        //循环创建任务线程
        for (int i = 0; i < size; i++) {
            //根据线程池数据创建任务线程并启动线程
            new SurgeryTask(i).start();
        }
    }

    /**
     * 添加新任务并执行任务
     * */
    public synchronized void addTask(Runnable task) {
        //判断标识
        if (isStop) {
            //抛出不合理的状态异常
            throw new IllegalStateException();
        }
        if (task != null) {
            //向任务队列中加入一个任务
            queue.add(task);
            //唤醒等待任务的工作任务线程
            notify();
        }
    }

    /**
     * 取出任务
     * */
    private synchronized Runnable getTask(int id) {
        try {
            //循环使线程等待任务
            while (queue.size() == 0) {
                if (isStop) {
                    return null;
                }
                System.out.println("病人" + id + "正在等待手术....");
                //如果任务队列中没有任务，就等待任务
                wait();
            }
        } catch (InterruptedException e) {  //捕获异常
            System.out.println("等待治疗出现错误：" + e.getMessage());
        }
        System.out.println("病人" + id + "开始执行手术....");
        //返回第一个任务并从队列中删除
        return (Runnable) queue.removeFirst();
    }

    /**
     * 关闭线程池
     * */
    public synchronized void closePool() {
        //判断标识
        if (!isStop) {
            //等待任务线程执行完毕
            waitTaskClosed();
            //标识为真
            isStop = true;
            //任务队列清空
            queue.clear();
            //唤醒线程池中所有的工作线程
            interrupt();
        }
    }

    /**
     * 等待任务线程把所有的任务执行完毕
     * */
    public void waitTaskClosed() {
        synchronized (this) {
            //标识为真
            isStop = true;
            //唤醒等待任务的工作任务线程
            notifyAll();
        }
        //创建线程组中活动的线程组
        Thread[] threads = new Thread[activeCount()];
        //获得线程组中当前所有的活动的工作线程
        int count = enumerate(threads);
        //循环等待所有的工作线程结束
        for (int i = 0; i < count; i++) {
            try {
                //等待工作线程结束
                threads[i].join();
                //捕获拦截异常
            } catch (InterruptedException e) {
                System.out.println("手术失败" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
