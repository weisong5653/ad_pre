package main;

public class Son extends Parent{

    private String sonName;

    public Son(String name,int age,String sonName) {
        super(name,age);
        this.sonName = sonName;
    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public void doSth(){
        System.out.println(super.getName());
        System.out.println(super.getAge());
    }
}
