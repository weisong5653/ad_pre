package entity;

public class TeacherEvaluationRecords {
    private String teacherId;
    private String studentId;
    private String content;
    private String subject;
    private int score;
    private String contentId;
    private String time;
    private String classId;

    public TeacherEvaluationRecords() {
    }

    public TeacherEvaluationRecords(String teacherId, String studentId, String content, String subject, int score,
                                    String contentId, String time, String classId) {
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.content = content;
        this.subject = subject;
        this.score = score;
        this.contentId = contentId;
        this.time = time;
        this.classId = classId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "TeacherEvaluationRecords{" +
                "teacherId='" + teacherId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", content='" + content + '\'' +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                ", contentId='" + contentId + '\'' +
                ", time='" + time + '\'' +
                ", classId='" + classId + '\'' +
                '}';
    }
}
