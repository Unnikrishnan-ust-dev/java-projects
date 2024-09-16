package com.ust.server.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.server.repository.MilkRepository;

@Service
public class MilkService {

	@Autowired
	MilkRepository repository;
}
