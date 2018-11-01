package entity;

import java.util.Date;

public class Teacher {
    private String className;
    private String teacherName;
    private Date now = new Date();

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "className='" + className + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", now=" + now +
                '}';
    }
}
