package sort;

interface hemain{
    public void setsex(String sex);

}

interface E{
    public void setsex(String sex);
}

class FatherClass implements hemain,E{
    private String name;
    private int age;
    private String sex;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say() {
        System.out.println("我是主函数，嘿嘿嘿");
    }

    public String getSex(){
        return sex;
    }


    @Override
    public void setsex(String sex) {
        this.sex = sex;
    }
}


class Son extends FatherClass {
    String school;

    /**
     * @return 返回学校名称
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school 设置学校名称
     */
    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public void say() {
        super.say();
        System.out.println("我是子函数，我最屌了！！");
    }

    public void talk() {
        System.out.println("我是子类独有的方法");
    }
}

/**
 * @author guyao
 */


public class test2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //新建一个对象
        Son s = new Son();
        s.setName("梨花");
        s.setAge(18);
        s.setSchool("中心小学");
        s.setsex("女");
        s.say();
        System.out.println(s.getName() + " " + s.getAge() + " " + s.getSchool()+" "+s.getSex());
//        FatherClass fa = new Son();
//        ((Son) fa).talk();
//        FatherClass f = new Son();
//        Son s = (Son) fa;
//        ((Son) fa).talk();
    }
}

