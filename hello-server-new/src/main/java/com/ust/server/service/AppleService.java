package com.ust.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.server.model.Apple;
import com.ust.server.repository.AppleRepository;

@Service
public class AppleService {

	@Autowired
	AppleRepository repository;
	
	public Apple getAppleById(long id) {
		return repository.findById(id).get();
	}
	
	public List<Apple> getAppleByType(String type) {
		return repository.getAppleByType(type);
	}
	
	public List<Apple> getAllApple(){
		return repository.findAll();
	}
}
