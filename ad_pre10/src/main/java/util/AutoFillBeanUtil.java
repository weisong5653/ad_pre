package util;

import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 自动填充bean
 * @author weisong
 * @date 2018/11/23 2:23 PM
 */

public class AutoFillBeanUtil {
    public static <T>T fillBean(HttpServletRequest request, Class<T> cls) {
        T bean = null;
        try {
            bean = cls.newInstance();
//            属性数组,注意方法参数的类型，String,Integer
            Field[] fields = cls.getDeclaredFields();
            String requestURL = request.getRequestURL().toString();
            for(Field field : fields) {
                String fieldName = field.getName();
//                注意传进来的参数是否为null，因为用到的studentId在创建论文时传进来的studentId为null，所以略过，在controller里进行赋值
//                if (fieldName.equals("id") || fieldName.equals("studentId")) {
////                    因为前端没有传id进来，并且后台的id是自增的，所以略过id的赋值
//                    if (requestURL.indexOf("ThesisModifierController") != -1 ) {
//                    } else {
//                        continue;
//                    }
//                }
                Class type = field.getType();
//                if(!fieldName.equals("id") && !fieldName.equals("age") && !fieldName.equals("studentId")){
                Method method = cls.getDeclaredMethod("set"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1),type);
                if (type.getName().equals("java.lang.String")) {
                    String value = request.getParameter(fieldName);
                    method.invoke(bean, value);
                } else {
                    Integer value;
                    String fieldValue = request.getParameter(fieldName);
                    if (fieldValue == null){
                        value = null;
                    } else {
                        value = Integer.valueOf(fieldValue);
                    }
                    method.invoke(bean, value);
                }
//                } else if (fieldName.equals("age")){
//                    Method method = cls.getDeclaredMethod("set"
//                            + fieldName.substring(0, 1).toUpperCase()
//                            + fieldName.substring(1),type);
//                    Integer value = Integer.valueOf(request.getParameter(fieldName));
//                    method.invoke(bean, value);
//                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 判断是否为数字
     * @param str
     * @return
     */
    private static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    /**
     * 数据库查询结果封装到bean中
     */
    public static <T> List<T> fillBeanFromSQL(Connection connection, Class<T> cls, String sql, Integer id){
        T bean;
        List<T> data = null;
        try {
            data= new ArrayList<>();
            Field[] fields = cls.getDeclaredFields();
            PreparedStatement pstmt;
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                bean = cls.newInstance();
                for(Field field : fields){
                    String fieldName = field.getName();
                    Class type = field.getType();

                    Method method = cls.getDeclaredMethod("set"
                            + fieldName.substring(0, 1).toUpperCase()
                            + fieldName.substring(1),type);
                    if (fieldName.equals("id")){
                        method.invoke(bean,rs.getInt("id"));
                    } else if(fieldName.equals("studentId")) {
                        method.invoke(bean,rs.getInt("student_id"));
                    } else if (fieldName.equals("publicTime")){
                        method.invoke(bean,rs.getString("public_time"));
                    } else {
                        method.invoke(bean,rs.getString(fieldName));
                    }
                }
                data.add(bean);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return data;

    }

}
