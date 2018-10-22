package Thread;
/**
 * @author guyao
 *
 * */
public class TestThread_3 {
    public static void main(String[] args) {
        new thread3().start();
        new thread3().start();
        new thread3().start();
        new thread3().start();
    }
}

class thread3 extends Thread {
    private int tickets = 20;
    @Override
    public void run(){
        while (true){
            if (tickets>0){
                System.out.println(Thread.currentThread().getName()+"出票"+tickets--);
            }
        }
    }
}