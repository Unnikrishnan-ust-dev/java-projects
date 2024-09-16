package com.ust.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.server.repository.BreadRepository;

@Service
public class BreadService {

	@Autowired
	BreadRepository repository;
}
