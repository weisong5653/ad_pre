package controller;

import com.alibaba.fastjson.JSON;
import entity.Thesis;
import service.ThesisService;
import service.impl.ThesisServiceImpl;
import util.AutoFillBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author weisong
 * @date 2018/11/25 6:13 PM
 */

@WebServlet(name = "ThesisModifierController",urlPatterns = "/ThesisModifierController")
public class ThesisModifierController extends HttpServlet {
    private ThesisService thesisService;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        thesisService = new ThesisServiceImpl();
//        String jsonThesis = request.getParameter("thesisModifion");
        Thesis thesis = AutoFillBeanUtil.fillBean(request,Thesis.class);
        thesisService.modifierThesis(thesis);
//        Thesis thesis = JSON.parseObject(jsonThesis,Thesis.class);
    }
}
