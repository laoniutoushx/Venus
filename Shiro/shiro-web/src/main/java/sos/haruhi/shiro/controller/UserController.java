package sos.haruhi.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sos.haruhi.shiro.vo.User;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/10/8 20:12
 * @Version 10032
 **/
@Controller
public class UserController {

    @RequestMapping(value = "/subLogin", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String subLogin(User user){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return e.getMessage();
        }

        return "登陆成功";
    }
}
