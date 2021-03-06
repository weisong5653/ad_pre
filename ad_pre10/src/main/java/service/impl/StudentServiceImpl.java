package service.impl;

import dao.StudentDao;
import dao.cache.TokenCache;
import dao.impl.StudentDaoImpl;
import dto.LoginDto;
import dto.UserTokenDto;
import entity.Student;
import enums.LoginState;
import exception.StudentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.StudentService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weisong
 * @date 2018/11/23 4:57 PM
 */
public class StudentServiceImpl implements StudentService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    StudentDao studentDao;
    TokenCache tokenCache;
    @Override
    public int insertStudent(Student student) {
        studentDao = new StudentDaoImpl();
        studentDao.addStudent(student);
        int insertStudentId = studentDao.getInsertStudentId(student.getStudentName());
        logger.debug("注册了"+insertStudentId+"号学生");
        return insertStudentId;
    }

    @Override
    public Map<String,Object> getStuedntByNameAndPassWord(LoginDto loginDto) {
        studentDao = new StudentDaoImpl();
        Student student= studentDao.getStudent(loginDto.getStudentName(),loginDto.getPassword());
        Map<String,Object> result = new HashMap<>();
        if (student==null){
            result.put("loginState",LoginState.LOGIN_FAILURE);
            result.put("student",null);
            logger.debug(loginDto.getStudentName()+"不存在或密码"+loginDto.getPassword()+"错误");
            return result;
        } else {
            result.put("loginState",LoginState.LOGIN_SUCCESS);
            result.put("student",student);
            logger.debug(student.getStudentName()+"登陆成功");
            return result;
        }
    }

    @Override
    public void updateStudent(Student student){
        studentDao = new StudentDaoImpl();
        int count = studentDao.updateStudent(student);
        if (count == 1) {
            logger.debug("更新了"+student.getStudentName()+"学生的信息");
        } else {
            logger.debug("没有更新"+student.getStudentName()+"学生的信息");
        }
    }

    @Override
    public void delStudent(Student student){
        studentDao = new StudentDaoImpl();
        int count = studentDao.delStudent(student);
        if (count == 1) {
            logger.debug("删除了"+student.getStudentName()+"学生信息");
        } else {
            logger.debug("没有找到"+student.getStudentName());
        }
    }

    @Override
    public UserTokenDto setStudentToken(String studentId) {
        tokenCache = new TokenCache();
        UserTokenDto userTokenDto = null;
        if (studentId != null) {
            userTokenDto = tokenCache.setUserTokenDto(studentId);
        } else {
            throw new StudentException("设置token时，studentId为null");
        }
        return userTokenDto;
    }

    @Override
    public UserTokenDto verifyUserToken(String token) {
        tokenCache = new TokenCache();
        UserTokenDto userTokenDto = null;
        userTokenDto = tokenCache.verifyUserToken(token);
        if (userTokenDto != null) {
            logger.debug("token有效"+token);
        } else {
            logger.debug("token无效"+token);
        }
        return userTokenDto;
    }
}
