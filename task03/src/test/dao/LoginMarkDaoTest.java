package dao;

import entity.LoginResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class LoginMarkDaoTest {
    @Resource
    LoginMarkDao loginMarkDao;
    @Test
    public void insertloginResult() {

    }
    @Test
    public void getLoginResult(){
        LoginResult loginResult = loginMarkDao.getLoginResult("监测","123456");
        System.out.print(loginResult);
    }
}