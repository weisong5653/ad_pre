package service;

import dto.UserTokenDto;
import org.junit.Test;
import service.impl.StudentServiceImpl;

import static org.junit.Assert.*;

/**
 * @author weisong
 * @date 2018/12/10 9:58 PM
 */
public class StudentServiceTest {
    StudentService studentService;
    @Test
    public void insertStudent() {
    }

    @Test
    public void getStuedntByNameAndPassWord() {
    }

    @Test
    public void updateStudent() {
    }

    @Test
    public void delStudent() {
    }

    @Test
    public void setStudentToken() {
        studentService = new StudentServiceImpl();
        UserTokenDto userTokenDto = studentService.setStudentToken("11");
        System.out.println(userTokenDto);
    }
}