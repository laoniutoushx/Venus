package sos.haruhi.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName IndexController
 * @Description 登陆控制
 * @Author Suzumiya Haruhi
 * @Date 2018/9/20 21:28
 * @Version 10032
 **/
@Controller
@RequestMapping(value="/index")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("index");
    }
}
