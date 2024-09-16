package com.ust.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.server.model.Bread;

@Repository
public interface BreadRepository extends JpaRepository<Bread,Long>{

}
