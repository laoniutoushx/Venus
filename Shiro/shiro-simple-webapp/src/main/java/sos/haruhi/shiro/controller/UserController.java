package sos.haruhi.shiro.controller;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sos.haruhi.shiro.dto.RoleDto;
import sos.haruhi.shiro.model.Role;
import sos.haruhi.shiro.model.User;
import sos.haruhi.shiro.service.IRoleService;
import sos.haruhi.shiro.service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/23 14:40
 * @Version 10032
 **/
@Controller
@RequestMapping(value = "/admin/user")
public class UserController {

    @Resource
    private IUserService userService;

    @Resource
    private IRoleService roleService;

    @RequestMapping(value = "/list")
    public String list(Model model){
        List<User> users = userService.list();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.list());
        return "user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user, HttpServletRequest request, Model model){
        String[] ridStrs = request.getParameterValues("rids");
        List<Integer> rids = new ArrayList<>();

        Arrays.asList(ridStrs).forEach(rid -> rids.add(Integer.parseInt(rid)));

        userService.add(user, rids);
        return "redirect:/admin/user/list";
    }

    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.GET)
    public String updateStatus(@PathVariable int id){
        User u = userService.load(id);
        u.setStatus(u.getStatus() == 1 ? -1 : 1);
        userService.update(u);
        return "redirect:/admin/user/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model){
        model.addAttribute("user", userService.load(id));
        List<Role> allRoles = roleService.list();
        List<Role> roles = roleService.listRolesOfUser(id);
        List<RoleDto> roleDtos = new ArrayList<>();
        allRoles.forEach(role -> {if(CollectionUtils.containsAny(roles, Arrays.asList(role))){
            roleDtos.add(new RoleDto(role, true));
        }else{
            roleDtos.add(new RoleDto(role, false));
        }});

        model.addAttribute("roles", roleDtos);
        return "user/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, User user, HttpServletRequest request, Model model){
        User oldUser = userService.load(id);
        oldUser.setUsername(user.getUsername());
        oldUser.setNickname(user.getNickname());
        oldUser.setStatus(user.getStatus());
        String[] ridStrs = request.getParameterValues("rids");
        List<Integer> rids = new ArrayList<>();
        if(ridStrs != null) {
            Arrays.asList(ridStrs).forEach(rid -> rids.add(Integer.parseInt(rid)));
        }

        userService.update(oldUser, rids);
        return "redirect:/admin/user/list";
    }

}
