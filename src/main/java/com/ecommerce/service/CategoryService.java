package com.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.db.CategoryRepository;
import com.ecommerce.model.Category;

@Service
public class CategoryService {

	@Autowired
    CategoryRepository categoryRepository;

    public Optional<Category> getByName(String name){
        return categoryRepository.findByName(name);
    }

    public boolean existsByName(String nombreCategoria){
        return categoryRepository.existsByName(nombreCategoria);
    }

    public void save(Category category){
        categoryRepository.save(category);
    }
    
    public Category getCategory(int id) {
    	return categoryRepository.getOne(id);
    }
}
