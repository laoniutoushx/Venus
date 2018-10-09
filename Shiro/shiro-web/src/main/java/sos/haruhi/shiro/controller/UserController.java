package sos.haruhi.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sos.haruhi.shiro.vo.User;

import java.rmi.activation.ActivationGroup_Stub;

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

        if(subject.hasRole("ADMIN")){
            return "有 admin 权限";
        }

        return "登陆成功";
    }

    @RequiresRoles("ADMIN")
    @RequestMapping(value = "/testRole", method = RequestMethod.GET)
    @ResponseBody
    public String testRole(){
        return "teatRole_success";
    }

    @RequiresRoles("ADMIN1")
    @RequestMapping(value = "/testRole1", method = RequestMethod.GET)
    @ResponseBody
    public String testRole1(){
        return "teatRole_success";
    }

    @RequiresPermissions("xxx")
    @RequestMapping(value = "/testPermission", method = RequestMethod.GET)
    @ResponseBody
    public String testPermission(){
        return "testPermission_success";
    }


}
