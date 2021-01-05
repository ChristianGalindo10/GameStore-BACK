package com.ecommerce.db;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	Optional<Category> findByName(String name);
	boolean existsByName(String name);
}
