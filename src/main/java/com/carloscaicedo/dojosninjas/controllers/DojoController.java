package com.carloscaicedo.dojosninjas.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.carloscaicedo.dojosninjas.models.Dojo;
import com.carloscaicedo.dojosninjas.services.DojoService;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("dojo")Dojo dojo, 
			BindingResult result) {
		return "dojos.jsp";
	}
	
	@GetMapping("/dojos")
	public String dojos(@ModelAttribute("dojo")Dojo dojo, 
			BindingResult result) {				
		return "dojos.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String displayDojosAndNinjas(@PathVariable("id") 
		Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "display.jsp";
	}
	
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo")Dojo dojo, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "dojos.jsp";
		} else {
			Dojo newDojo = dojoService.createDojo(dojo);
			return "redirect:/dojos/"+newDojo.getId();
		}
	}

}