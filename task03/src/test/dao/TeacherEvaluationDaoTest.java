package dao;

import entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class TeacherEvaluationDaoTest{
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    TeacherEvaluationDao teacherEvaluationDao;
    @Resource
    Query query;
    @Test
    public void createTeacherEvaluation() {
        TeacherEvaluationRecords teacherEvaluationRecords = new TeacherEvaluationRecords("fc3d297c-9073-43b0-b3c5-7ca017592639",
                "a0dbffe7-8f49-4117-895d-7742f259598d","长大了身体变化是正常的，男孩女孩有区别。","心理健康",
                5,"2","2018-10-28 11:34:29.903","d23385fc-27b8-4657-81b2-1b6010f148cb");
        int update = teacherEvaluationDao.createTeacherEvaluation(teacherEvaluationRecords);
        logger.debug("插入了"+update+"条评价记录");
    }
}