package dao;

import entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class QueryTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    Query query;
    @Test
    public void queryAllStudents() {
        List<Student> list = query.queryAllStudents("监测");
        if(list!=null){
            for(Student student:list){
                logger.debug(student.toString());
            }
        }
        else {
            logger.debug("返回的学生列表为null");
        }
    }
    @Test
    public void queryTeacher() {
        Teacher teacher = query.queryTeacher("监测");
        if(teacher!=null){
            logger.debug(teacher.toString());
        }
        else {
            logger.debug("返回的teacher为null");
        }
    }
    @Test
    public void queryEvaluations(){
        List<Evaluation> list = query.queryEvaluations();
        if(list!=null){
            for(Evaluation eva:list){
                logger.debug(eva.toString());
            }
        }
        else {
            logger.debug("返回的Evalutions为null");
        }
    }
    @Test
    public void queryTeach(){
        Teach teach = query.queryTeach("fc3d297c-9073-43b0-b3c5-7ca017592639");
        if(teach!=null){
                logger.debug(teach.toString());
        }
        else {
            logger.debug("返回的Evalutions为null");
        }
    }
    @Test
    public void queryEvaluation(){
        Evaluation evaluation= query.queryEvaluation("积极参与校内的艺术活动。","书法");
        if(evaluation!=null){
            logger.debug(evaluation.toString());
        }
        else {
            logger.debug("返回的Evalutions为null");
        }
    }

    @Test
    public void queryTeacherEvaluation(){
        List<TeacherEvaluationRecords> list= query.queryTeacherEvaluation();
        if(list!=null){
            for(TeacherEvaluationRecords teacherEvaluationRecords:list){
                logger.debug(teacherEvaluationRecords.toString());
            }
        }
        else {
            logger.debug("返回的TeacherEvalutions为null");
        }
    }
}