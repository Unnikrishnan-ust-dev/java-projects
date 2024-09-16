package com.ust.relationships.repository;

import com.ust.relationships.resources.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
