package com.ust.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.server.model.Milk;

@Repository
public interface MilkRepository extends JpaRepository<Milk, Long>{

}
