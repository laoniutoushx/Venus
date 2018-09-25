package sos.haruhi.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
@RequestMapping(value="/admin")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequiresRoles("ADMIN")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("redirect:/index.jsp");
    }
}
