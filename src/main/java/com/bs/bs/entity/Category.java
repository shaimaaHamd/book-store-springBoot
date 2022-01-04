package com.bs.bs.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.bs.bs.model.enums.ECategory;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Category")
public class Category {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private ECategory category;

	@ManyToMany
	@JoinTable(name = "book_category",joinColumns = @JoinColumn(name="category_id"),inverseJoinColumns = @JoinColumn(name="book_id"))
	@JsonIgnore
	private List<Book> book;

	public Category(){}
	public Category(Long id,ECategory eCategory){
		this.category = eCategory;
		this.id = id;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public ECategory getCategory() {
		return category;
	}



	public void setCategory(ECategory category) {
		this.category = category;
	}



	public List<Book> getBook() {
		return book;
	}



	public void setBook(List<Book> book) {
		this.book = book;
	}
	
	
}
