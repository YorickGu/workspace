package sort;

class Person{
    String name;
    int age;
    @Override
    public String toString(){
        return("好的吧，你又赢了，整天就是一生气的时候就在和我想着要朝着要分手"+this.name+" "+this.age);
    }
    public void saysay(){
        System.out.println();
    }
}
public class ToStringTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "顾垚江";
        p.age = 25;
        System.out.println(p);
    }
}
