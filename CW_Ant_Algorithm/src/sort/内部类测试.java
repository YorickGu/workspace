package sort;

interface A {
    public void fun1();
}

class B {
    int i = 10;

    class C implements A {
        @Override
        public void fun1() {
            System.out.println(i);
        }
    }

    public void get(C c) {

        c.fun1();
    }

    public void test() {

        this.get(new C());
    }
}

public class 内部类测试 {
    public static void main(String[] args) {
        B b = new B();
        b.test();
    }
}
