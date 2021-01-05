package com.ecommerce.db;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	Optional<Game> findByName(String name);
	boolean existsByName(String name);
}
