package controller;

import dto.ResultDto;
import entity.Student;
import entity.Thesis;
import net.sf.json.JSONObject;
import service.ThesisService;
import service.impl.ThesisServiceImpl;
import util.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author weisong
 * @date 2018/11/24 7:12 PM
 */

@WebServlet(name="LoginSuccessController",urlPatterns = "/LoginSuccessController")
public class LoginSuccessController extends HttpServlet {
    ThesisService thesisService;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        thesisService = new ThesisServiceImpl();
        Student student = (Student)session.getAttribute("student");
        ResultDto<Thesis> listThesis = thesisService.getListThesis(student.getId());

//        System.out.println(student);
//        StringBuilder studentName = new StringBuilder(student.getStudentName());
        JSONObject data = new JSONObject();
        data.put("student",student);
        data.put("listThesis",listThesis.getData());

//        [Thesis{studentId=1, id=2, title='??????', content='??????????', publicTime='20181121'}, Thesis{studentId=1, id=3, title='李威松很帅哦', content='今天是阳光明媚的一天', publicTime='20181121'}, Thesis{studentId=1, id=4, title='李威松很帅哦', content='今天是阳光明媚的一天嗷嗷啥东西啊实打实多少啊打死大声点阿斯顿', publicTime='20181121'}, Thesis{studentId=1, id=8, title='啊啊啊啊', content='aaa', publicTime='2018-11-24 20:34:47'}, Thesis{studentId=1, id=9, title='aa', content='aa', publicTime='2018-11-24 21:32:04'}]
//        System.out.println(listThesis.getData());

//        {"student":{"age":21,"id":1,"password":"","sex":"man","studentName":"lws"},"listThesis":[{"content":"??????????","id":2,"publicTime":"20181121","studentId":1,"title":"??????"},{"content":"今天是阳光明媚的一天","id":3,"publicTime":"20181121","studentId":1,"title":"李威松很帅哦"},{"content":"今天是阳光明媚的一天嗷嗷啥东西啊实打实多少啊打死大声点阿斯顿","id":4,"publicTime":"20181121","studentId":1,"title":"李威松很帅哦"},{"content":"aaa","id":8,"publicTime":"2018-11-24 20:34:47","studentId":1,"title":"啊啊啊啊"},{"content":"aa","id":9,"publicTime":"2018-11-24 21:32:04","studentId":1,"title":"aa"}]}
//        System.out.println(data);

        ResponseUtil.OutputData(response,data);
    }
}
