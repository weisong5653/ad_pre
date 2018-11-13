package web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User控制器
 */
@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/printUsers",method = RequestMethod.POST)
    public void printUsers(HttpServletRequest request, HttpServletResponse response){
        userService.exportUsersDetail(request,response);
    }

}
