package Thread;

public class RunnableThread {

    public static void main(String[] args) {
        Thread_4 t1 = new Thread_4();

        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
    }

}

class Thread_4 implements Runnable{
private int Tickets =20;
    @Override
    public void run() {
        while (true){
            while (Tickets>0){
                System.out.println(Thread.currentThread().getName()+"正在出票"+Tickets--);
                System.out.println(Thread.activeCount());
            }
        }
    }
}