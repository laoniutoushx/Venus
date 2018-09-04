package sos.haruhi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sos.haruhi.student.iservice.IClassroomService;
import sos.haruhi.student.model.Classroom;
import sos.haruhi.sys.dto.TreeDto;
import sos.haruhi.sys.iservice.IOrgService;
import sos.haruhi.sys.model.Org;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/classroom")
public class ClassroomController {
	@Resource
	private IClassroomService classroomService;
	
	@Resource
	private IOrgService orgService;

	@RequestMapping("/classrooms")
	public String list(Model model, Integer pid) {
		return "classroom/list";
	}
	
	@RequestMapping("/tree")
	public @ResponseBody
	List<TreeDto> tree() {
		return orgService.listParentTreeByOrgType(Classroom.ZZLX);
	}
	
	@RequestMapping("/classrooms/{id}")
	public String listChilds(@PathVariable int id, Model model) {
		Org org = orgService.load(id);
		model.addAttribute("parent",org);
		model.addAttribute("childs",classroomService.find(id));
		return "classroom/listChilds";
	}
	
	@RequestMapping(value="/classrooms/{id}/add",method= RequestMethod.GET)
	public String add(@PathVariable int id,Model model) {
		model.addAttribute("classroom", new Classroom());
		Org parent = orgService.load(id);
		model.addAttribute("parent", parent);
		return "classroom/add";
	}
	
	@RequestMapping(value="/classrooms/{id}/add",method=RequestMethod.POST)
	public String add(@PathVariable int id, @Valid @ModelAttribute("classroom")Classroom classroom, BindingResult br, Integer pid, Model model) {
		if(br.hasErrors()) {
			return "classroom/add";
		}
		classroomService.add(classroom,pid);
		return "redirect:/admin/classroom/classrooms/"+id;
	}
	
	@RequestMapping(value="/classrooms/{pid}/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable int pid,@PathVariable int id) {
		classroomService.delete(id);
		return "redirect:/admin/classroom/classrooms/"+pid;
	}
	
	@RequestMapping(value="/classrooms/{pid}/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable int pid,@PathVariable int id,Model model) {
		model.addAttribute("classroom", classroomService.load(id));
		Org parent = orgService.load(pid);
		model.addAttribute("parent", parent);
		return "classroom/update";
	}
	
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
