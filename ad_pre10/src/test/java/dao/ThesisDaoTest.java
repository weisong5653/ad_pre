package dao;

import dao.impl.ThesisDaoImpl;
import entity.Thesis;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.AutoFillBeanUtil;
import util.JDBCUtil;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author weisong
 * @date 2018/11/23 11:32 PM
 */
public class ThesisDaoTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    ThesisDao thesisDao;
    @Test
    public void insertThesis() {
        thesisDao = new ThesisDaoImpl();
        Thesis thesis = new Thesis();
        thesis.setContent("李威松很帅哦");
        thesis.setTitle("今天是阳光明媚的一天嗷嗷啥东西啊实打实多少啊打死大声点阿斯顿");
        thesis.setPublicTime("20181121");
        thesis.setStudentId(1);
        thesisDao.insertThesis(thesis);
    }

    @Test
    public void listThesis(){
        Connection conn = JDBCUtil.getConnection();
        String sql = "select student_id, id, title, content, public_time from thesis where student_id=?";
        List<Thesis> thesisList = AutoFillBeanUtil.fillBeanFromSQL(conn, Thesis.class, sql,1);
        System.out.println(thesisList);
    }

    @Test
    public void delThesis(){
        List<Integer> list = new ArrayList<>();
        thesisDao = new ThesisDaoImpl();
        list.add(5);
        list.add(6);
        Integer count = thesisDao.delThesis(list);
        logger.debug(count.toString());
    }
    @Test
    public void modifierThesis(){
        thesisDao = new ThesisDaoImpl();
        Date date = new Date();
        SimpleDateFormat sdf =  new SimpleDateFormat();
        Thesis thesis = new Thesis();
        thesis.setId(2);
        thesis.setStudentId(1);
        thesis.setTitle("修改1");
        thesis.setContent("内容1");
        thesis.setPublicTime(sdf.format(date));
        thesisDao.modifierThesis(thesis);
        System.out.println(111);
    }
}