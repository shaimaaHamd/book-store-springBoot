package com.bs.bs.api.controller;

import com.bs.bs.model.enums.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.bs.bs.entity.Author;
import com.bs.bs.repository.AuthorRepository;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	AuthorRepository authrepo;
	
	@GetMapping("/getAllAuthors")
	public Iterable<Author> viewAllAuthors(){
		return authrepo.findAll();
	}

	@GetMapping("/getById/{id}")
	public Author viewAuthorById(@PathVariable("id") Long id) {
		return authrepo.findById(id).get();
	}

	@GetMapping("getByAuthorName/{authorName}")
	public Author findByAuthorName(@PathVariable("authorName") String name){
		return authrepo.findByAuthorName(name);
	}

	@GetMapping("getByBookId/{id}")
	public Author findByBookId(@PathVariable("id") Long id){
		return authrepo.findByBookId(id);
	}



	@PostMapping( path ="/createAuthor",consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN')")
	public Author addAuthor(@RequestBody Author author) {
		return authrepo.save(author);
	}


	@PatchMapping( path ="/updateById" , consumes = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PreAuthorize("hasRole('ADMIN')")
 	public Author updateAuthor(@RequestBody Author author ) {

		return authrepo.save(author);
	}


}
