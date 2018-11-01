package main;

public class Parent {

    private String name;
    private int age;

    public Parent(String name,int age) {
        this.age = age;
        this.name = name;
    }

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

    public void doSth(){
        System.out.println(name);
    }
}
