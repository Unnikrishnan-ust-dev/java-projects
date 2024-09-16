package com.ust.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.server.model.Egg;

@Repository
public interface EggRepository extends JpaRepository<Egg,Long>{

}
