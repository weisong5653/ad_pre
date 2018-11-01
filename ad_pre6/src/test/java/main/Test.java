package main;

public class Test {
    public static void main(String[] args) {
        Parent parent = new Parent("123",2);
        parent.setAge(4);
        parent.doSth();

        Parent son = new Son("1",3,"2");
        son.doSth();
    }
}
