package service;

import dao.CreateDao;
import org.apache.ibatis.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class LoginServiceTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    LoginService loginService;
    @Resource
    CreateDao createDao;
    @Test
    public void createLoginMark() {
        int update = loginService.createLoginMark("监测","123456");

        logger.debug("插入了"+update+"条数据");
    }
    @Test
    public void createIntegraOfStudent(){
        int mark = createDao.createIntegraOfStudent("fa587f57-c073-4f66-8992-45bee5ce1199",-2);
    }
}