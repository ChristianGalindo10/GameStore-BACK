package com.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.db.CategoryRepository;
import com.ecommerce.model.Category;
import com.ecommerce.model.Game;
import com.ecommerce.security.dto.Message;
import com.ecommerce.service.CategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "categories")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
    CategoryService categoryService;
	
	@GetMapping("/get")
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}
	
	@GetMapping("/get/{idCat}/games")
	public List<Game> getGames(@PathVariable("idCat") int idCat) {
		Category category = categoryRepository.getOne(idCat);
		return category.getGames();
	}
	
	@GetMapping("/get/{idCat}")
	public Category getCategory(@PathVariable("idCat") int idCat) {
		Category category = categoryRepository.getOne(idCat);
		System.out.println(category.getName());
		return category;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> createCategory(@RequestBody Category category) throws IOException {
		if(categoryService.existsByName(category.getName()))
            return new ResponseEntity(new Message("That name already exists, you must create a name"), HttpStatus.BAD_REQUEST);
		categoryRepository.save(category);
		return new ResponseEntity(new Message("Categoria guardada"), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public void updateCategory(@RequestBody Category category) {
		categoryRepository.save(category);
	}
	
	@DeleteMapping(path = { "/{idCat}" })
	public Category deleteCategory(@PathVariable("idCat") int idCat) {
		Category category = categoryRepository.getOne(idCat);
		categoryRepository.deleteById(idCat);
		return category;
	}
}
