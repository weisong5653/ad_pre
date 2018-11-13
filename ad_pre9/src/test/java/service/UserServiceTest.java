package service;

import dto.QueryResultDto;
import entity.User;
import org.apache.poi.hssf.usermodel.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-service.xml","classpath:spring/spring-dao.xml"})
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void exportUsersDetail() {


    }

    @Test
    public void createUserExcel() {
        QueryResultDto<User> list = userService.getUsers();
        List<User> data = list.getData();
        HSSFWorkbook wb = new HSSFWorkbook();
//        创建一页
        HSSFSheet sheet = wb.createSheet("用户表");
//        创建表头
        HSSFRow row = sheet.createRow((int)0);
//        设置样式
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//        每列进行设置
        HSSFCell cell = row.createCell((short)0);
        cell.setCellValue("序号");
        cell.setCellStyle(style);
        cell = row.createCell((short)1);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);
        cell = row.createCell((short)2);
        cell.setCellValue("类型");
        cell.setCellStyle(style);
        cell = row.createCell((short)3);
        cell.setCellValue("性别");
        cell.setCellStyle(style);
        cell = row.createCell((short)4);
        cell.setCellValue("年龄");
        cell.setCellStyle(style);
        int i = 1;
        for(User user:data){
            row = sheet.createRow(i++);
            cell = row.createCell((short)0);
            cell.setCellStyle(style);
            cell.setCellValue(user.getId());
            cell = row.createCell((short)1);
            cell.setCellStyle(style);
            cell.setCellValue(user.getName());
            cell = row.createCell((short)2);
            cell.setCellStyle(style);
            cell.setCellValue(user.getType());
            cell = row.createCell((short)3);
            cell.setCellStyle(style);
            cell.setCellValue(user.getSex().equals("1")?"男":"女");
            cell = row.createCell((short)4);
            cell.setCellStyle(style);
            cell.setCellValue(user.getAge());
        }

//        String unloadPath = request.getSession().getServletContext().getRealPath("/")+"/download/Excel/";
        String unloadPath = "/Users/weisong5653/Desktop/download/";
        File file = new File(unloadPath);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String title = sdf.format(new Date());
        String filepath = unloadPath+title+".xls";
        if(!file.exists()||!file.isDirectory()){
            file.mkdirs();
        }
        try {
            wb.write(new FileOutputStream(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUsers() {
    }
}