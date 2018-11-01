package dao;

import entity.LoginResult;
import org.apache.ibatis.annotations.Param;

public interface LoginMarkDao {
//    只为了获取teacherId,每次获取LoginResult后要手动输入password
    public LoginResult getLoginResult(@Param("teacherName") String teacherName,@Param("password") String password);
    public int insertloginResult(@Param("loginResult") LoginResult loginResult);
}
