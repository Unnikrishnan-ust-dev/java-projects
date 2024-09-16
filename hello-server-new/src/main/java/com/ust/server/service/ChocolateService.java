package com.ust.server.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ust.server.model.Chocolate;
import com.ust.server.repository.ChocolateRepository;

@Service
public class ChocolateService {

	@Autowired
	ChocolateRepository repository;
	
	public Chocolate getChocolateById(long id) {
		return repository.findById(id).get();
	}
	
	public List<Chocolate> getChocolateByType(String type) {
		return repository.getChocolateByType(type);
	}
	
	public List<Chocolate> getAllChocolate(){
		return repository.findAll();
	}
}
