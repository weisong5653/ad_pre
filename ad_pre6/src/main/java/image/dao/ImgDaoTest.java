package image.dao;

import image.entity.Image;
import org.apache.ibatis.annotations.Param;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ImgDaoTest {
    @Autowired
    private ImgDao imgDao;
    @org.junit.Test
    public void queryAll() {
        List<Image> list = imgDao.queryAll();
        System.out.println(list.toString());
    }

    @org.junit.Test
    public void createimg() {
        String imgpath = "2013062213342.jpg";
        String imgtitle= "minions";
        String imgissuer="liweisong";
        imgDao.createimg(imgpath,imgtitle,imgissuer);
    }
    @org.junit.Test
    public void queryimage(){
        Image image = imgDao.queryimage(1);
        System.out.print(image);
    }
}