package enums;

public enum SexEnum {
    MAN("man"),
    WOMAN("woman");

    private String sex;

    SexEnum(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
