package com.ust.relationships.repository;

import com.ust.relationships.resources.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<Page,Long> {
}
