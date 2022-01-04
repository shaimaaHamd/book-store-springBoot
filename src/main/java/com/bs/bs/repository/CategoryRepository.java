package com.bs.bs.repository;

import com.bs.bs.model.enums.ECategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bs.bs.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
    public Category findByCategory(ECategory category);

}
