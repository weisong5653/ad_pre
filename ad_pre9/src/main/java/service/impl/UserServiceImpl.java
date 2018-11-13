package service.impl;

import dao.UserDao;
import dto.QueryResultDto;
import entity.User;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;
import util.FileUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 2018.11.13
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    /**
     * 实现下载Excel业务功能
     * @param request
     * @param response
     */
    public void exportUsersDetail(HttpServletRequest request, HttpServletResponse response) {
        QueryResultDto<User> data = getUsers();
        String filepath = createUserExcel(data.getData(),request);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String filename = sdf.format(new Date())+".xls";
        FileUtil.dowload(filepath,filename,request,response);
    }


    /**
     * 创建Excel表格
     * @param data
     * @param request
     * @return
     */
    public String createUserExcel(List<User> data, HttpServletRequest request){

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

        String unloadPath = request.getSession().getServletContext().getRealPath("/")+"/download/Excel/";
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
        return filepath;
    }

    public QueryResultDto<User> getUsers() {
        List<User> data = userDao.getUsers();
        return new QueryResultDto<User>(data);
    }


}
