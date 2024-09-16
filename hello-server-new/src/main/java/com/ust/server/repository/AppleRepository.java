package com.ust.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.server.model.Apple;

@Repository
public interface AppleRepository extends JpaRepository<Apple, Long>{
	public List<Apple> getAppleByType(String type);
}
