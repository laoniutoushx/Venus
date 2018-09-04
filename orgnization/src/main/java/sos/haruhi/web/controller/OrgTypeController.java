package sos.haruhi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sos.haruhi.sys.iservice.IOrgTypeService;
import sos.haruhi.sys.model.OrgType;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RequestMapping("/admin/orgType")
@Controller
public class OrgTypeController {
	
	@Resource
	private IOrgTypeService orgTypeService;
	
	@RequestMapping("/orgTypes")
	public String list(Model model) {
		model.addAttribute("orgTypes", orgTypeService.list());
		return "orgType/list";
	}
	
	@RequestMapping(value="/add",method= RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("ot", new OrgType());
		return "orgType/add";
	}
	
	/**
	 * 进行验证时，br中默认的错误信息是orgType的，如果使用ot无法获取信息，
	 * 所以需要在@valid之后增加ModelAttribute来指定验证出错之后br中存储的model名称
	 * @param ot
	 * @param br
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("ot")OrgType ot, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "orgType/add";
		}
		orgTypeService.add(ot);
		return "redirect:/admin/orgType/orgTypes";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		model.addAttribute("ot", orgTypeService.load(id));
		return "orgType/update";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable int id, @Valid @ModelAttribute("ot") OrgType ot, BindingResult br, Model model) {
		if(br.hasFieldErrors()) {
			model.addAttribute("ot",ot);
			return "orgType/update";
		}
		OrgType tot = orgTypeService.load(id);
		tot.setName(ot.getName());
		tot.setSn(ot.getSn());
		orgTypeService.update(tot);
		return "redirect:/admin/orgType/orgTypes";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id,Model model) {
		orgTypeService.delete(id);
		return "redirect:/admin/orgType/orgTypes";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable int id,Model model) {
		model.addAttribute("ot",orgTypeService.load(id));
		model.addAttribute("childs",orgTypeService.listChildType(id));
		return "orgType/show";
	}
	
	@RequestMapping("/setRule/{id}")
	public String setRule(@PathVariable int id,Model model) {
		model.addAttribute("ot",orgTypeService.load(id));
		model.addAttribute("rules",orgTypeService.listOrgTypeRuleByOrg(id));
		return "orgType/setRule";
	}
	
	@RequestMapping("/deleteRule/{id}/{cid}")
	public String deleteRule(@PathVariable int id,@PathVariable int cid) {
		orgTypeService.deleteOrgTypeRule(id, cid);
		return "redirect:/admin/orgType/setRule/"+id;
	}
	
	@RequestMapping(value="/addRule",method=RequestMethod.POST)
	public void addRule(@RequestParam int cid, @RequestParam int pid, @RequestParam int num, HttpServletResponse reps) throws IOException {
		orgTypeService.addOrgTypeRule(pid, cid, num);
		reps.getWriter().println("ok");
	}
	
	@RequestMapping(value="/updateRule",method=RequestMethod.POST)
	public void updateRule(@RequestParam int cid,@RequestParam int pid,@RequestParam int num,HttpServletResponse reps) throws IOException {
		orgTypeService.updateOrgTypeRule(pid, cid, num);
		reps.getWriter().println("ok");
	}
	
}
