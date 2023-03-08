package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Component;

@Repository
@Component
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
