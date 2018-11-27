package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dao.impl.StudentDaoImpl;
import entity.Student;
import org.junit.Test;
import util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoTest {

    @Test
    public void addStudent() {
        Student student = new Student();
        student.setPassword("1223322");
        student.setStudentName("1梦啊");
        student.setAge(21);
        student.setSex("man");

        StudentDao studentDao = new StudentDaoImpl();
        int a = studentDao.addStudent(student);
        System.out.println(a);
    }

    @Test
    public void isExist() {
        String studentName="lw";
        StudentDao studentDao = new StudentDaoImpl();
        boolean exist = studentDao.isExist(studentName);
        System.out.println(exist);

    }

    @Test
    public void isLoginSuccess(){
        StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.getStudent("lws","1223322");
        System.out.println(student);
    }

    @Test
    public void changeStudent(){
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(5);
        student.setAge(11);
        student.setSex("woman");
        student.setPassword("123");
        student.setStudentName("meme");
        studentDao.updateStudent(student);
    }

    @Test
    public void delStudent(){
        Student student = new Student();
        student.setId(38);
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.delStudent(student);
    }
}