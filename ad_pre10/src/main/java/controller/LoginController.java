package controller;

import dao.cache.TokenCache;
import dto.LoginDto;
import dto.UserTokenDto;
import entity.Student;
import enums.LoginState;
import jdk.nashorn.internal.scripts.JS;
import net.sf.json.JSONObject;
import service.StudentService;
import service.impl.StudentServiceImpl;
import util.AutoFillBeanUtil;
import util.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author weisong
 * @date 2018/11/24 11:46 AM
 */
@WebServlet(name = "LoginController", urlPatterns = "/LoginController")
public class LoginController extends HttpServlet {
    StudentService studentService;
    JSONObject permission;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        studentService = new StudentServiceImpl();
        LoginDto loginDto = AutoFillBeanUtil.fillBean(request,LoginDto.class);
        HttpSession session = request.getSession();
        String studentId = request.getParameter("studentId");
        UserTokenDto userTokenDto;
//        result存了状态和student
        Map<String, Object> result = studentService.getStuedntByNameAndPassWord(loginDto);
        permission = new JSONObject();
        if(((LoginState)result.get("loginState")).getState()){
            userTokenDto = studentService.setStudentToken(studentId);
            permission.put("isLoginSuccess","true");
            permission.put("token",userTokenDto.getToken());
            session.setAttribute("student",result.get("student"));
            System.out.println(userTokenDto);
        } else {
            permission.put("isLoginSuccess","failure");
        }
        ResponseUtil.OutputData(response,permission);
    }

//    /**
//     * 设置响应的类型
//     * @param response
//     * @return
//     */
//    private PrintWriter OutputData(HttpServletResponse response){
//        response.setContentType("text/html");
//        response.setContentType("text/plain; charset=utf-8");
//        PrintWriter out= null;
//        try {
//            out = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return out;
//    }
}
