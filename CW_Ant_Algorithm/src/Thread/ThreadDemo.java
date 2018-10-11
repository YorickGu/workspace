package Thread;

public class ThreadDemo extends Thread{
    public static void main(String[] args) {
        int end = 10;
        new TestThread().start();
        for (int i = 0; i < end; i++) {
            System.out.println("main函数正在运行");
            
        }
    }

}

class TestThread extends Thread {
    @Override
    public void run() {
        int end = 10;
        for (int i = 0; i < end; i++) {
            System.out.println("TestThread正在运行");
        }
    }
}

