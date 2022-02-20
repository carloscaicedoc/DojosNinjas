package com.carloscaicedo.dojosninjas.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carloscaicedo.dojosninjas.models.Ninja;
import com.carloscaicedo.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	// CRUD ACTIONS
	
		// 1 Find all Ninjas
		public List<Ninja> allNinjas() {
			return ninjaRepo.findAll();
		}	
		// 1.1 Find one Ninja
		public Ninja findNinja(Long id) {
			Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
			if(optionalNinja.isPresent()) {
				return optionalNinja.get();
			} else {
				return null;
			}
		}		
		// 2 Create Ninja
		public Ninja createNinja(Ninja ninja) {
			return ninjaRepo.save(ninja);
		}		
		// 3 Update
		public Ninja updateNinja(Ninja ninja) {
			Optional<Ninja> optionalNinja = ninjaRepo.findById(ninja.getId());
			if(optionalNinja.isPresent()) {
				return ninjaRepo.save(ninja);
			} else {
				return null;
			}								
		}		
		// 4 Delete
		public void deleteNinja(Long id) {
			ninjaRepo.deleteById(id);
		}			
}

