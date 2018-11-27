package controller;

import entity.Student;
import entity.Thesis;
import service.ThesisService;
import service.impl.ThesisServiceImpl;
import util.AutoFillBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author weisong
 * @date 2018/11/24 12:06 AM
 */
@WebServlet(name = "createThesis",urlPatterns = "/createThesis")
public class ThesisController extends HttpServlet {
    ThesisService thesisService;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        thesisService = new ThesisServiceImpl();
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        Thesis thesis = AutoFillBeanUtil.fillBean(request,Thesis.class);
        thesis.setStudentId(student.getId());
        thesisService.insertThesis(thesis);
//        response.sendRedirect("loginsuccess.jsp");
    }
}
