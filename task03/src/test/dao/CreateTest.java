package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;



import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class CreateTest {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Resource
    CreateDao create;
    @Test
    public void createPropertyOfStudent() {
        int update = create.createPropertyOfStudent("281da54d-1cd0-497c-8cc2-7fe85576993a",5);
        logger.debug("更新了"+update+"条数据");
    }

    @Test
    public void createIntegraOfStudent() {
        int update = create.createIntegraOfStudent("281da54d-1cd0-497c-8cc2-7fe85576993a",5);
        logger.debug("更新了"+update+"条数据");
    }


}