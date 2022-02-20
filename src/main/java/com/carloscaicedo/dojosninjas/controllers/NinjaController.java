package com.carloscaicedo.dojosninjas.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.carloscaicedo.dojosninjas.models.Dojo;
import com.carloscaicedo.dojosninjas.models.Ninja;
import com.carloscaicedo.dojosninjas.services.DojoService;
import com.carloscaicedo.dojosninjas.services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	private DojoService dojoService;

	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "ninjas.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String processNinjaForm(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojo", dojos);
			return "ninjas.jsp";
		} else {
			Ninja newNinja = ninjaService.createNinja(ninja);
			return "redirect:/dojos/"+newNinja.getDojo().getId();			
		}				
	}
	
}


