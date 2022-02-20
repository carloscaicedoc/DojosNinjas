package com.carloscaicedo.dojosninjas.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.carloscaicedo.dojosninjas.models.Dojo;
import com.carloscaicedo.dojosninjas.models.Ninja;
import com.carloscaicedo.dojosninjas.services.DojoService;
import com.carloscaicedo.dojosninjas.services.NinjaService;

@RestController
public class APIController {
		
	@Autowired
	private DojoService dojoService;
	
	@Autowired
    private NinjaService ninjaService;
		
	@RequestMapping("/api/dojos")
	public List<Dojo> showAll() {
		return dojoService.allDojos();
	}
	
	@RequestMapping("/api/ninjas")
	public List<Ninja> showNinjas() {
		return ninjaService.allNinjas();
	}
	
	@PostMapping(value="/api/dojos")
	public Dojo create(@RequestParam(value="location") String location) {
		Dojo dojo = new Dojo(location);
		return dojoService.createDojo(dojo);
	}
	
	@PostMapping(value="/api/ninjas")
	public Ninja create(
			@RequestParam(value="firstName") String firstName,
			@RequestParam(value="lastName") String lastName,
			@RequestParam(value="age") int age) {
		Ninja ninja = new Ninja(firstName, lastName, age);
		return ninjaService.createNinja(ninja);
	}	
} 