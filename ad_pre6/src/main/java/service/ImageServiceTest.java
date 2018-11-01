package service;

import image.entity.Image;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class ImageServiceTest {
    @Autowired
    ImageService imageService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void createimg() {
    }

    @Test
    public void queryAll() {
        List<Image> list=imageService.queryAll();
        System.out.println(list.size());

    }
}