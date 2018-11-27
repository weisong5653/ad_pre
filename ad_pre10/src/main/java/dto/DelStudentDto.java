package dto;

import entity.Student;

/**
 * 需要删除的对象Dto
 * @author weisong
 * @date 2018/11/27 12:42 PM
 */
public class DelStudentDto {
    private String message;
    private Student student;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "DelStudentDto{" +
                "message='" + message + '\'' +
                ", student=" + student +
                '}';
    }
}
