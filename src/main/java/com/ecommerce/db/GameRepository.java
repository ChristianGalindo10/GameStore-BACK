package com.ecommerce.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
