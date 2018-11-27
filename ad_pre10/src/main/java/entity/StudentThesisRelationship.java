package entity;

import java.util.Date;

public class StudentThesisRelationship {
    private int studentId;
    private int thesisId;
    private Date publicTime;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getThesisId() {
        return thesisId;
    }

    public void setThesisId(int thesisId) {
        this.thesisId = thesisId;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    @Override
    public String toString() {
        return "StudentThesisRelationship{" +
                "studentId=" + studentId +
                ", thesisId=" + thesisId +
                ", publicTime=" + publicTime +
                '}';
    }
}
