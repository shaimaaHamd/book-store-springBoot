package com.bs.bs.api.controller;

import com.bs.bs.entity.Author;
import com.bs.bs.entity.Category;
import com.bs.bs.model.BookModel;
import com.bs.bs.repository.AuthorRepository;
import com.bs.bs.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.bs.bs.entity.Book;
import com.bs.bs.model.enums.ECategory;
import com.bs.bs.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired 
	BookRepository bookrepo;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	AuthorRepository authorRepository;

	@GetMapping("/getAllBooks")
	public Iterable<Book> viewAllBooks() {
		return bookrepo.findAll();
	}

	@GetMapping("/getByTitle/{title}")
	public Book viewBookByTitle(@PathVariable("title") String title) {
		return bookrepo.findByTitle(title);
	}

	@GetMapping("/getById/{id}")
	public  Book viewBookById(@PathVariable("id") Long id) {
		return bookrepo.findById(id).get();
	}
	
	@GetMapping("getByAuthorName/{authorName}")
	public Iterable<Book> findAllBooksByAuthorName(@PathVariable("authorName") String name){
		return bookrepo.findByAuthorAuthorName(name);
	}
	
	@GetMapping( "/getByCategory/{category}")
	public Iterable<Book> findAllBooksByCategory(@PathVariable("category") ECategory cat){
		return bookrepo.findByCategoryCategory(cat);
	}
	
	@PostMapping( path ="/createBook/{categories}",consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN')")
	public Book addBook(@RequestBody BookModel book, @PathVariable("categories") List<ECategory> cats) {

		List<Category> categoryList =new ArrayList<>();
		for (ECategory eCategory: cats) {
 			Category category= categoryRepository.findByCategory(eCategory);
  			categoryList.add(category);
		}
		Author author = authorRepository.findById(book.getAuthorId()).get();
 		Book bookEntity = new Book(book.getTitle(),book.getPrice(),author,categoryList);

		return bookrepo.save(bookEntity);
	}

	@PatchMapping( path ="/updateById" , consumes = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PreAuthorize("hasRole('ADMIN')")
	public Book updateBook(@RequestBody BookModel book ) {
		Book bookEntity = bookrepo.findById(book.getId()).get();
		if(! book.getTitle().equals("string")) bookEntity.setTitle(book.getTitle());
		if( book.getPrice() != 0 ) bookEntity.setPrice(book.getPrice());
		if(  book.getAuthorId() !=0 ) {
			Author author = authorRepository.findById(book.getAuthorId()).get();
			bookEntity.setAuthor(author);
		}
		return bookrepo.save(bookEntity);
	}

	@DeleteMapping("deleteById/{id}")
 	@ResponseStatus(HttpStatus.ACCEPTED)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteBook (@PathVariable("id") long id) {
		bookrepo.deleteById(id);
		return "Book deleted successfully";
	}

}
