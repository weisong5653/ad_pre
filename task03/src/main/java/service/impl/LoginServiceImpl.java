package service.impl;

import dao.CreateDao;
import dao.LoginMarkDao;
import dao.Query;
import dao.TeacherEvaluationDao;
import entity.*;
import exception.EvaluateExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import service.LoginService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    TeacherEvaluationDao teacherEvaluationDao;
    @Resource
    LoginMarkDao loginMarkDao;
    @Resource
    Query query;
    @Resource
    CreateDao createDao;
    public int createLoginMark(String teacherName,String password) {
        LoginResult loginResult = loginMarkDao.getLoginResult(teacherName,password);
        loginResult.setTeacherName(teacherName);
        loginResult.setPassword(password);
        int update = loginMarkDao.insertloginResult(loginResult);
        return update;
    }

    public List<Student> getAllStudent(String teacherName) {
        List<Student> list = query.queryAllStudents(teacherName);
        try{
            if(list==null){
                throw new Exception();
            }
            else {
                return list;
            }
        }catch (Exception e){
                logger.debug(e.getMessage());
                throw new EvaluateExceptions("获取到的Student列表为null");
        }

    }

    public List<Evaluation> getAllEvaluation() {
        List<Evaluation> list = query.queryEvaluations();
        try{
            if(list==null){
                throw new Exception();
            }
            else {
                return list;
            }
        }catch (Exception e){
            logger.debug(e.getMessage());
            throw new EvaluateExceptions("获取到的Evaluation列表为null");
        }
    }

    public Teacher getTeacher(String teacherName) {
        Teacher teacher = query.queryTeacher(teacherName);
        try{
            if(teacher==null){
                throw new Exception();
            }
            else {
                return teacher;
            }
        }catch (Exception e){
            logger.debug(e.getMessage());
            throw new EvaluateExceptions("获取到的为teacher为null");
        }
    }


    public int createTeacherEvaluation(TeacherEvaluationRecords teacherEvaluationRecords) {
        int mark = teacherEvaluationDao.createTeacherEvaluation(teacherEvaluationRecords);
        if(mark==0){
            logger.debug("创建了0条评价记录");
        }else{
            logger.debug("创建了"+mark+"条评价记录");
        }
        return mark;
    }

    public int createPropertyOfStudent(String userId, int property) {
        int mark=0;
        if(property>=0){
            mark = createDao.createPropertyOfStudent(userId,property);
        }
        logger.debug("插入了"+mark+"条财产记录");
        return mark;
    }

    public int createIntegraOfStudent(String userId, int integral) {
        int mark=0;
        if(integral>=0){
            mark = createDao.createPropertyOfStudent(userId,integral);
            logger.debug("修改了"+mark+"条财产记录");
        }
        mark = createDao.createIntegraOfStudent(userId,integral);
        logger.debug("修改了"+mark+"条积分记录");
        return mark;
    }


}
