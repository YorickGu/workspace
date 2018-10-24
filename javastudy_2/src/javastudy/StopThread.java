package javastudy;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Set;

class ThreadTest implements Runnable {

    @Override
    public void run() {
        for (int x = 0; x < 2; x++) {
            System.out.println(Thread.currentThread().toString() + "......" + x);
            Thread.yield();
        }
    }
}

/**
 * @author guyao
 */
public class StopThread {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        Properties pro = System.getProperties();
        pro.list(System.out);
        pro.list(new PrintStream("logdemo.txt"));
        Set<String> names = pro.stringPropertyNames();
        for (String name : names) {
            System.out.println(name + ":" + pro.getProperty(name));
        }

        ThreadTest tt = new ThreadTest();
        Thread t1 = new Thread(tt);
        Thread t2 = new Thread(tt);

        t1.start();

        t2.start();

        for (int x = 0; x < 3; x++) {
            System.out.println(Thread.currentThread().toString() + "......" + x);
        }


    }
}