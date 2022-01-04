package com.bs.bs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bs.bs.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{
    public Author findByAuthorName(String name);

    public Author findByBookId(Long id);
}
