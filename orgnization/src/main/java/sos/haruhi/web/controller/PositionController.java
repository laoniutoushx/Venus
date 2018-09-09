package sos.haruhi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sos.haruhi.auth.annotation.AuthOper;
import sos.haruhi.auth.annotation.ModelMenu;
import sos.haruhi.auth.model.AuthFinalVal;
import sos.haruhi.sys.iservice.IPositionService;
import sos.haruhi.sys.model.Position;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin/position")
public class PositionController {
	@Resource
	private IPositionService positionService;

	@ModelMenu
	@AuthOper
	@RequestMapping("/positions")
	public String list(Model model) {
		model.addAttribute("datas", positionService.find());
		return "position/list";
	}

	@ModelMenu
	@AuthOper
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("position", new Position());
		return "position/add";
	}

	@AuthOper
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("position")Position position,BindingResult br,Model model) {
		if(br.hasFieldErrors()) {
			return "position/add";
		}
		positionService.add(position);
		return "redirect:/admin/position/positions";
	}

	@ModelMenu(menuPos=AuthFinalVal.MENU_MODEL_OPER)
	@AuthOper
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		model.addAttribute("position", positionService.load(id));
		return "position/update";
	}

	@AuthOper
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Valid @ModelAttribute("position")Position position,BindingResult br,Model model) {
		if(br.hasFieldErrors()) {
			return "position/update";
		}
		Position tp = positionService.load(id);
		tp.setManager(position.getManager());
		tp.setName(position.getName());
		tp.setSn(position.getSn());
		positionService.update(tp);
		return "redirect:/admin/position/positions";
	}

	@ModelMenu(menuPos= AuthFinalVal.MENU_MODEL_OPER)
	@AuthOper
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		positionService.delete(id);
		return "redirect:/admin/position/positions";
	}
}
