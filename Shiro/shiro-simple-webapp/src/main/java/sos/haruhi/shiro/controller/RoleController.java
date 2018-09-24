package sos.haruhi.shiro.controller;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.AnyPredicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sos.haruhi.shiro.dto.ResDto;
import sos.haruhi.shiro.model.Res;
import sos.haruhi.shiro.model.Role;
import sos.haruhi.shiro.service.IResService;
import sos.haruhi.shiro.service.IRoleService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName RoleController
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/23 14:41
 * @Version 10032
 **/
@Controller
@RequestMapping(value = "/admin/role")
public class RoleController {
    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Resource
    private IRoleService roleService;

    @Resource
    private IResService resService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("roles", roleService.list());
        return "role/list"; // 代指 jsp 资源文件地址
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model){
        Role role = new Role();
        List<Res> reses = resService.list();
        model.addAttribute("role", role);
        model.addAttribute("reses", reses);
        return "role/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Role role, HttpServletRequest request){
        roleService.add(role);
        String[] resStrIds = request.getParameterValues("resids");
        List<Integer> resids = new ArrayList<>();
        if(resStrIds != null)
            Arrays.asList(resStrIds).forEach(rid -> roleService.addRoleRes(role.getId(), Integer.parseInt(rid)));
        return "redirect:/admin/role/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model){
        model.addAttribute("role", roleService.load(id));
        List<Res> allReses = resService.list();
        Set<Res> ownReses = new HashSet<Res>(roleService.listResesByRole(id));
        List<ResDto> reses = new ArrayList<>();
        allReses.forEach(allRes -> {
            if(!ownReses.add(allRes)){
                reses.add(new ResDto(allRes, true));
            }else{
                reses.add(new ResDto(allRes, false));
            }
        });
        model.addAttribute("reses", reses);
        return "role/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, HttpServletRequest request, Role role){
        Role oldRole = roleService.load(id);
        oldRole.setSn(role.getSn());
        oldRole.setRolename(role.getRolename());
        roleService.add(oldRole);
        String[] resids = request.getParameterValues("resids");
        if(resids == null) resids = new String[]{};
        List<Integer> newResIds = Arrays.stream(resids)
                .map(resid -> {return Integer.parseInt(resid);}).collect(Collectors.toList());
        List<Integer> oldResIds = roleService.listResesByRole(id)
                .stream().map(Res::getId).collect(Collectors.toList());

        CollectionUtils.subtract(oldResIds, newResIds).forEach(resId -> roleService.deleteRoleRes(id, (Integer) resId));
        CollectionUtils.subtract(newResIds, oldResIds).forEach(resId -> roleService.addRoleRes(id, (Integer) resId));

        return "redirect:/admin/role/list";
    }

}
