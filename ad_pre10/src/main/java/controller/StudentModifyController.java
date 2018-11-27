package controller;

import entity.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;
import util.AutoFillBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 修改学生个人信息控制器
 * @author weisong
 * @date 2018/11/27 10:15 AM
 */
@WebServlet(name = "StudentModifyController",urlPatterns = "/StudentModifyController")
public class StudentModifyController extends HttpServlet {
    StudentService studentService;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        studentService = new StudentServiceImpl();
        Student  student = AutoFillBeanUtil.fillBean(request, Student.class);
        if ("updateStudent".equals(message)){
            studentService.updateStudent(student);
        } else {
            studentService.delStudent(student);
        }
    }

}
