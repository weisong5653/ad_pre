package entity;

public class TeacherEvaluation {

    private Teacher teacher;
    private Student student;
    private Evaluation evaluation;
    private Teach teach;
//这个应该属于Dto(数据传输对象)
    public Teach getTeach() {
        return teach;
    }

    public void setTeach(Teach teach) {
        this.teach = teach;
    }

    public TeacherEvaluation(Teacher teacher, Student student, Evaluation evaluation,Teach teach) {
        this.teacher = teacher;
        this.student = student;
        this.evaluation = evaluation;
        this.teach = teach;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public String toString() {
        return "TeacherEvaluation{" +
                "teacher=" + teacher +
                ", student=" + student +
                ", evaluation=" + evaluation +
                ", teach=" + teach +
                '}';
    }
}
