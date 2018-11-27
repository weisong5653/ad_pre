package controller;

import entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.StudentService;
import service.impl.StudentServiceImpl;
import util.AutoFillBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 2018.11.20
 * 注册控制器
 */
@WebServlet(name = "RegisteController",urlPatterns = "/RegisteController",loadOnStartup=1)
public class RegisteController extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    StudentService studentService;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        studentService = new StudentServiceImpl();
        HttpSession session = request.getSession();
        Student student = AutoFillBeanUtil.fillBean(request,Student.class);
        int studentId = studentService.insertStudent(student);
        student.setId(studentId);
        session.setAttribute("student",student);
        request.getRequestDispatcher("loginsuccess.jsp").forward(request,response);
    }
}
