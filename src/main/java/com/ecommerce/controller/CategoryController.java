package com.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.db.CategoryRepository;
import com.ecommerce.model.Category;
import com.ecommerce.model.Game;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "categories")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/get")
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}
	
	@GetMapping("/get/{id}/games")
	public List<Game> getGames(@PathVariable("id") int id) {
		Category category = categoryRepository.getOne(id);
		return category.getGames();
	}
	
	@PostMapping("/add")
	public void createCategory(@RequestBody Category category) throws IOException {
		categoryRepository.save(category);
	}
	
	@DeleteMapping(path = { "/{id}" })
	public Category deleteCategory(@PathVariable("id") int id) {
		Category category = categoryRepository.getOne(id);
		categoryRepository.deleteById(id);
		return category;
	}
}
