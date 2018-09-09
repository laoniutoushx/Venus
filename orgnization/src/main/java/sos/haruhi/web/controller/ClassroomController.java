package sos.haruhi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sos.haruhi.auth.annotation.AuthOper;
import sos.haruhi.auth.annotation.ModelMenu;
import sos.haruhi.auth.annotation.NavMenu;
import sos.haruhi.auth.annotation.Res;
import sos.haruhi.auth.model.AuthFinalVal;
import sos.haruhi.student.iservice.IClassroomService;
import sos.haruhi.student.model.Classroom;
import sos.haruhi.sys.dto.TreeDto;
import sos.haruhi.sys.iservice.IOrgService;
import sos.haruhi.sys.model.Org;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@NavMenu(name="班级信息管理",href="/classrooms",orderNum=2,psn="school_root",icon="icon-user-grey")
@Res(name="班级信息管理",orderNum=1,psn="school_root",sn="classroom")
@RequestMapping("/admin/classroom")
public class ClassroomController {
	@Resource
	private IClassroomService classroomService;
	
	@Resource
	private IOrgService orgService;

	@ModelMenu
	@AuthOper
	@RequestMapping("/classrooms")
	public String list(Model model, Integer pid) {
		return "classroom/list";
	}

	@AuthOper
	@RequestMapping("/tree")
	public @ResponseBody
	List<TreeDto> tree() {
		return orgService.listParentTreeByOrgType(Classroom.ZZLX);
	}

	@AuthOper
	@RequestMapping("/classrooms/{id}")
	public String listChilds(@PathVariable int id, Model model) {
		Org org = orgService.load(id);
		model.addAttribute("parent",org);
		model.addAttribute("childs",classroomService.find(id));
		return "classroom/listChilds";
	}

	@ModelMenu
	@AuthOper
	@RequestMapping(value="/classrooms/{id}/add",method= RequestMethod.GET)
	public String add(@PathVariable int id,Model model) {
		model.addAttribute("classroom", new Classroom());
		Org parent = orgService.load(id);
		model.addAttribute("parent", parent);
		return "classroom/add";
	}

	@AuthOper
	@RequestMapping(value="/classrooms/{id}/add",method=RequestMethod.POST)
	public String add(@PathVariable int id, @Valid @ModelAttribute("classroom")Classroom classroom, BindingResult br, Integer pid, Model model) {
		if(br.hasErrors()) {
			return "classroom/add";
		}
		classroomService.add(classroom,pid);
		return "redirect:/admin/classroom/classrooms/"+id;
	}

	@ModelMenu(menuPos= AuthFinalVal.MENU_MODEL_OPER)
	@AuthOper
	@RequestMapping(value="/classrooms/{pid}/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable int pid,@PathVariable int id) {
		classroomService.delete(id);
		return "redirect:/admin/classroom/classrooms/"+pid;
	}

	@ModelMenu(menuPos=AuthFinalVal.MENU_MODEL_OPER)
	@AuthOper
	@RequestMapping(value="/classrooms/{pid}/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable int pid,@PathVariable int id,Model model) {
		model.addAttribute("classroom", classroomService.load(id));
		Org parent = orgService.load(pid);
		model.addAttribute("parent", parent);
		return "classroom/update";
	}

	@AuthOper
	@RequestMapping(value="/classrooms/{pid}/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable int pid, @PathVariable int id, @Valid @ModelAttribute("classroom") Classroom classroom, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "classroom/update";
		}
		Classroom tc = classroomService.load(id);
		tc.setGrade(classroom.getGrade());
		tc.setName(classroom.getName());
		tc.setOrderNum(classroom.getOrderNum());
		tc.setStatus(classroom.getStatus());
		tc.setType(classroom.getType());
		classroomService.update(tc);
		return "redirect:/admin/classroom/classrooms/"+pid;
	}
}
