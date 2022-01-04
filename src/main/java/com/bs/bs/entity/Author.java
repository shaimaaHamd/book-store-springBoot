package com.bs.bs.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name = "Author")
public class Author {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	
	private String authorName;

	@OneToMany(mappedBy = "author")
	@JsonIgnore
	private List<Book> book;
	
	public Author() {
		
	}

	public Author(String authorName , List<Book> book) {
		super();
		this.authorName = authorName;
 		this.book = book;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
	

	
	
}
