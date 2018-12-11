package service;

import dto.LoginDto;
import dto.UserTokenDto;
import entity.Student;
import enums.LoginState;

import java.util.Map;

/**
 * @author weisong
 * @date 2018/11/23 4:56 PM
 */
public interface StudentService {

    /**
     * 注册学生
     * @param student
     * @return
     */
    int insertStudent(Student student);

    /**+
     * 检查用户名和密码是否正确存在
     * @param loginDto
     * @return
     */
    Map<String,Object> getStuedntByNameAndPassWord(LoginDto loginDto);

    void updateStudent(Student student);

    void delStudent(Student student);

    UserTokenDto setStudentToken(String studentId);

    UserTokenDto verifyUserToken(String token);
}
