package web;

import dao.CreateDao;
import dao.LoginMarkDao;
import dao.Query;
import dao.TeacherEvaluationDao;
import entity.*;
import exception.EvaluateExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.LoginService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;


@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    LoginService loginService;
    @Resource
    Query query;
    @Resource
    TeacherEvaluationDao teacherEvaluationDao;
    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    public String dologin(Model model, HttpServletRequest request){

        try{
            request.setCharacterEncoding("utf-8");
            String teacherName=request.getParameter("teacherName");
            String password=request.getParameter("password");
            if(teacherName!=null&&password!=null){
                loginService.createLoginMark(teacherName,password);
                Teacher teacher = query.queryTeacher(teacherName);
                model.addAttribute("teacher",teacher);
                List<Student> students=query.queryAllStudents("监测");
                model.addAttribute("students",students);
                List<Evaluation> evaluations=query.queryEvaluations();
                model.addAttribute("evaluations",evaluations);
                Teach teach = query.queryTeach("fc3d297c-9073-43b0-b3c5-7ca017592639");
                model.addAttribute("teach",teach);
                return "loginSuccess";
            }
            else {
                throw new EvaluateExceptions("teacherName或password为空");
            }
        }catch (Exception e){
//            应该在catch块这列return而不是else里
            logger.debug("teacherName或password为空");
            return "loginFailure";
        }
    }

    @RequestMapping(value = "/createEvaluation",method = RequestMethod.POST)
    public String createEvaluation(@RequestBody Mark mark,Model model,HttpServletRequest request){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Evaluation evaluation = query.queryEvaluation(mark.getContent(),mark.getSubject());
        Teacher teacher = query.queryTeacher(mark.getTeacherName());
        TeacherEvaluationRecords teacherEvaluationRecords = new TeacherEvaluationRecords(mark.getTeacherId(),mark.getStudentId(),
                evaluation.getContent(),evaluation.getSubject(),evaluation.getScores(),"2",df.format(teacher.getNow()),"d23385fc-27b8-4657-81b2-1b6010f148cb");
        teacherEvaluationDao.createTeacherEvaluation(teacherEvaluationRecords);
        loginService.createIntegraOfStudent(mark.getStudentId(),evaluation.getScores());
        List<TeacherEvaluationRecords> list = query.queryTeacherEvaluation();
        System.out.println(list.toString());
        HttpSession session = request.getSession();
        session.setAttribute("teacherEvaluationRecords",list);
//        model.addAttribute("teacherEvaluationRecords",list);
        return "TeacherEvaluationRecords";
    }

}
