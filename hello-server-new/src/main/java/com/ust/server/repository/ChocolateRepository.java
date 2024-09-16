package com.ust.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.server.model.Chocolate;

@Repository
public interface ChocolateRepository extends JpaRepository<Chocolate, Long>{

	List<Chocolate> getChocolateByType(String type);

}
