package com.bs.bs.api.controller;

import com.bs.bs.entity.Category;
import com.bs.bs.model.enums.ECategory;
import com.bs.bs.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/getAllCategores")
    public Iterable<Category> viewAllCats() {
        return categoryRepository.findAll();
    }

    @GetMapping("/getByECategory/{ecategory}")
    public  Category viewByECat(@PathVariable("ecategory")ECategory eCategory) {
        return categoryRepository.findByCategory(eCategory);
    }

    @GetMapping("/getById/{id}")
    public  Category viewById(@PathVariable("id") Long id) {
        return categoryRepository.findById(id).get();
    }

}
