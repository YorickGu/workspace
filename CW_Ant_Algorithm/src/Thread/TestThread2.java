package Thread;

public class TestThread2 {
    public static void main(String[] args) throws InterruptedException {
        int end = 10;
        testthread t = new testthread();
        new Thread(t).start();
        for (int i = 0; i < end; i++) {
            System.out.println(Thread.currentThread().getName()+"      main线程正在运行");
            Thread.sleep(100);
        }
    }
}

class testthread implements Runnable {

    @Override
    public void run() {

        int end = 10;
        for (int i = 0; i < end; i++) {
            System.out.println(Thread.currentThread().getName()+"     thread正在运行");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}