package Thread_1;

public class Tickets {
    public static void main(String[] args) {

    }
}
class Company extends Thread{

}

/*
* 单例饿汉式设计模式
* */
class single{
    private static final single instance = new single();
    private single(){}
    public static single getinstance(){
        return instance;
    }
}

/**
 * 单例懒汉式设计模式
 * */
class singleton{
    private static singleton instance = null;
    private singleton(){}
    public static singleton getInstance(){
        if (instance ==null) {
            synchronized (singleton.class) {
                if (instance == null) {
                    instance = new singleton();
                }
            }
        }
        return instance;
    }
}