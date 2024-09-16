package com.ust.server.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ust.server.repository.EggRepository;

public class EggService {

	@Autowired
	EggRepository repository;
}
