package com.bs.bs.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	private float price;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	@ManyToMany
	@JoinTable(name = "book_category",joinColumns = @JoinColumn(name="book_id"),inverseJoinColumns = @JoinColumn(name="category_id"))
	private List<Category> category;

	
	public Book() {
		 
	}
	
	public Book(String title, float price, Author author, List<Category> category) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
		this.category = category;
	}

	public Book(Long id,String title, float price, Author author, List<Category> category) {
		 this.id = id;
		this.title = title;
		this.price = price;
		this.author = author;
		this.category = category;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
	
}
