package com.carloscaicedo.dojosninjas.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carloscaicedo.dojosninjas.models.Dojo;
import com.carloscaicedo.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepo;
	
	// CRUD ACTIONS
	
	// 1 Find all Dojos
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}	
	// 1.1 Find one Dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}	
	// 2 Create
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}				
	// 3 Update
	public Dojo updateDojo(Dojo dojo) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(dojo.getId());
		if(optionalDojo.isPresent()) {
			return dojoRepo.save(dojo);
		} else {
			return null;
		}								
	}	
	// 4 Delete
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}		
}
