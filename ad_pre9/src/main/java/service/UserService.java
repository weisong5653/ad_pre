package service;

import dto.QueryResultDto;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 2018.11.13
 * User业务功能
 */
public interface UserService {
    /**
     *
     * 实现下载Excel业务功能
     * @param request
     * @param response
     */
    public  void exportUsersDetail(HttpServletRequest request, HttpServletResponse response);

    /**
     * 将List<User> 转化为 QueryResultDto<User>统一格式
     * @return
     */
    public QueryResultDto<User> getUsers();
}
