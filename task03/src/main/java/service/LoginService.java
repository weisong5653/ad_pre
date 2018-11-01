package service;

import entity.*;

import java.util.List;

public interface LoginService {
    public int createLoginMark(String teacherName,String password);
    public List<Student> getAllStudent(String teacherName);
    public List<Evaluation> getAllEvaluation();
    public Teacher getTeacher(String teacherName);
    public int createTeacherEvaluation(TeacherEvaluationRecords teacherEvaluationRecords);
    public int createPropertyOfStudent(String userId,int property);
    public int createIntegraOfStudent(String userId,int integral);
}
