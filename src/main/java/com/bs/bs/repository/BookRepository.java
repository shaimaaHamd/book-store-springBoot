package com.bs.bs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bs.bs.entity.Book;
import com.bs.bs.model.enums.ECategory;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	public List<Book>  findByAuthorAuthorName(String name);
 	 public List<Book> findByCategoryCategory(ECategory category);
 	 public Book findByTitle(String title);

 }
