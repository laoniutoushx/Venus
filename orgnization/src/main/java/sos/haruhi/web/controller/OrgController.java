package sos.haruhi.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sos.haruhi.sys.dto.AjaxObj;
import sos.haruhi.sys.dto.TreeDto;
import sos.haruhi.sys.iservice.IOrgService;
import sos.haruhi.sys.iservice.IOrgTypeService;
import sos.haruhi.sys.iservice.IPersonService;
import sos.haruhi.sys.iservice.IPositionService;
import sos.haruhi.sys.model.Org;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/org")
public class OrgController {
	@Resource
	private IOrgService orgService;
	@Resource
	private IOrgTypeService orgTypeService;
	@Resource
	private IPersonService personService;
	@Resource
	private IPositionService positionService;
	
	@RequestMapping("/orgs")
	public String list() {
		return "org/list";
	}
	
	@RequestMapping("/treeAll")
	public @ResponseBody
	List<TreeDto> tree() {
		return orgService.tree();
	}
	
	@RequestMapping("/orgs/{id}")
	public String listChilds(@PathVariable int id, Integer typeId, Model model) {
		Org org = orgService.load(id);
		model.addAttribute("parent",org);
		if(typeId==null||typeId<0) typeId = -1;
		model.addAttribute("typeId", typeId);
		model.addAttribute("childs",orgService.findByParent(id,typeId));
		model.addAttribute("orgTypes", orgTypeService.listChildType(org.getTypeId()));
		return "org/listChilds";
	}
	
	private Map<Integer,String> initManagerType() {
		Map<Integer,String> types = new HashMap<Integer,String>();
		types.put(0, "默认类型");
		types.put(1, "所有类型");
		types.put(2, "自定义类型");
		types.put(-1,"不具备管理功能");
		return types;
	}
	
	@RequestMapping(value="/orgs/{id}/add",method= RequestMethod.GET)
	public String add(@PathVariable int id,Model model) {
		model.addAttribute("org", new Org());
		Org parent = orgService.load(id);
		model.addAttribute("parent", parent);
		model.addAttribute("orgTypes", orgTypeService.listChildType(parent.getTypeId()));
		model.addAttribute("managerTypes",initManagerType());
		return "org/add";
	}
	
	@RequestMapping(value="/orgs/{id}/add",method=RequestMethod.POST)
	public String add(@PathVariable int id, @Valid @ModelAttribute("org")Org org, BindingResult br, Integer pid, Model model) {
		if(br.hasErrors()) {
			return "org/add";
		}
		orgService.add(org,pid);
		return "redirect:/admin/org/orgs/"+id;
	}
	
	@RequestMapping(value="/orgs/{pid}/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable int pid,@PathVariable int id) {
		orgService.delete(id);
		return "redirect:/admin/org/orgs/"+pid;
	}
	
	@RequestMapping(value="/orgs/{pid}/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int pid,@PathVariable int id,Model model) {
		model.addAttribute("parent", orgService.load(pid));
		model.addAttribute("org", orgService.load(id));
		model.addAttribute("persons", personService.listPersonAndPosByOrg(id, null));
		return "org/show";
	}
	
	@RequestMapping(value="/orgs/{pid}/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable int pid,@PathVariable int id,Model model) {
		model.addAttribute("org", orgService.load(id));
		Org parent = orgService.load(pid);
		model.addAttribute("orgTypes", orgTypeService.listChildType(parent.getTypeId()));
		model.addAttribute("parent", parent);
		model.addAttribute("managerTypes",initManagerType());
		return "org/update";
	}
	
	@RequestMapping(value="/orgs/{pid}/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable int pid,@PathVariable int id,@Valid @ModelAttribute("org")Org org,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "org/update";
		}
		Org to = orgService.load(id);
		to.setAddress(org.getAddress());
		to.setAtt1(org.getAtt1());
		to.setAtt2(org.getAtt2());
		to.setAtt3(org.getAtt3());
		to.setManagerType(org.getManagerType());
		to.setName(org.getName());
		to.setOrderNum(org.getOrderNum());
		to.setPhone(org.getPhone());
		to.setTypeId(org.getTypeId());
		to.setTypeName(org.getTypeName());
		orgService.update(to);
		return "redirect:/admin/org/orgs/"+pid;
	}
	
	@RequestMapping(value="/setRule/{id}",method=RequestMethod.GET)
	public String setRule(@PathVariable int id,Model model) {
		model.addAttribute("org",orgService.load(id));
		model.addAttribute("mids", orgService.listManagerRuleIds(id));
		return "org/setRule";
	}
	
	@RequestMapping(value="/setRule",method=RequestMethod.POST)
	public @ResponseBody
	AjaxObj setRule(Integer id, @RequestParam("mids[]")Integer[] mids) {
		orgService.addRule(id, mids);
		return AjaxObj.success("成功设置规则");
	}
	
	@RequestMapping("/persons/{id}")
	public String showPerson(@PathVariable int id,Integer posId,Model model) {
		model.addAttribute("positions", positionService.listByOrg(id));
		if(posId!=null&&posId>0) {
			model.addAttribute("posId", posId);
		} else {
			posId = null;
		}
		model.addAttribute("persons", personService.findPersonAndPosByOrg(id, posId));
		Org org = orgService.load(id);
		model.addAttribute("org",org);
		model.addAttribute("parent", org);
		return "org/showPerson";
	}
	
	@RequestMapping("/personManagers/{id}")
	public String personManagers(@PathVariable int id,Model model) {
		model.addAttribute("person", personService.load(id));
		return "org/personManagers";
	}
	
	@RequestMapping("/personTree/{id}")
	public @ResponseBody List<TreeDto> personManagerTree(@PathVariable int id) {
		return personService.listOrgTree(id);
	}
	
}
