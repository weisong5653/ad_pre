package dao;

import entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Query {
    public List<Student> queryAllStudents(@Param("teacherName") String teacherName);
    public Teacher queryTeacher(@Param("teacherName") String teacherName);
    public List<Evaluation> queryEvaluations();
    public Teach queryTeach(@Param("teacherId") String teacherId);
    public Student queryStudent(@Param("name") String studentName);
    public Evaluation queryEvaluation(@Param("content") String content,@Param("subject") String subect);
    public List<TeacherEvaluationRecords> queryTeacherEvaluation();
}
