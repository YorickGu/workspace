package sort;

class Person_1 {
    static int num = 0;
    String name;
    int age;

    public Person_1() {
        this.name = "heihei";
        this.age =13;
        num++;
    }
}

public class TestStatic {
    public static void main(String[] args) {
        Person_1 p1 = new Person_1();
        Person_1 p2 = new Person_1();
        Person_1 p3 = new Person_1();
        System.out.println(Person_1.num);
    }


}
