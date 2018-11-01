package entity;

public class Mark {
    private String content;
    private String studentId;
    private String teacherName;
    private String teacherId;
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "content='" + content + '\'' +
                ", studentId='" + studentId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
