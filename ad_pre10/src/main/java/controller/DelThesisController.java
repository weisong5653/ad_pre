package controller;

import net.sf.json.JSONObject;
import org.apache.commons.lang3.ArrayUtils;
import service.ThesisService;
import service.impl.ThesisServiceImpl;
import util.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author weisong
 * @date 2018/11/25 1:45 PM
 */
@WebServlet(name = "DelThesisController",urlPatterns = "/DelThesisController")
public class DelThesisController extends HttpServlet {
    private ThesisService thesisService;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        thesisService = new ThesisServiceImpl();
        String[] data = request.getParameterValues("delList");
        int[] datatoint = new int[data.length];
        for (int i = 0;i < data.length;i++){
            datatoint[i] = Integer.valueOf(data[i]);
        }
//        利用apache commons-lang3将int数组转list<Integer>
        Integer[] is = ArrayUtils.toObject(datatoint);
        List<Integer> asList = Arrays.asList(is);
        thesisService.deleteThesis(asList);
//        返回删除成功的论文号
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("delListThesised",asList);

//        {"delListThesised":[2,3,4]}
//        System.out.println(jsonObject.toString());

        ResponseUtil.OutputData(response,jsonObject);
    }
}
