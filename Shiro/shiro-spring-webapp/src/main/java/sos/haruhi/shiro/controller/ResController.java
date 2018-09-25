package sos.haruhi.shiro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sos.haruhi.shiro.service.IResService;
import sos.haruhi.shiro.service.IRoleService;

import javax.annotation.Resource;

/**
 * @ClassName ResController
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/23 14:42
 * @Version 10032
 **/
@Controller
@RequestMapping(value = "/admin/res")
public class ResController {
    private Logger logger = LoggerFactory.getLogger(ResController.class);

    @Resource
    private IRoleService roleService;

    @Resource
    private IResService resService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("reses", resService.list());
        return "res/list";
    }

}
