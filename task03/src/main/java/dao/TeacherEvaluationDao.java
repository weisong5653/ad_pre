package dao;

import entity.TeacherEvaluation;
import entity.TeacherEvaluationRecords;
import org.apache.ibatis.annotations.Param;

public interface TeacherEvaluationDao {
    public int createTeacherEvaluation(@Param("teacherEvaluationRecords") TeacherEvaluationRecords teacherEvaluationRecords);
}
