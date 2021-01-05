package com.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.db.GameRepository;
import com.ecommerce.model.Game;

@Service
public class GameService {
	@Autowired
    GameRepository gameRepository;

    public Optional<Game> getByName(String name){
        return gameRepository.findByName(name);
    }

    public boolean existsByName(String nombreJuego){
        return gameRepository.existsByName(nombreJuego);
    }

    public void save(Game game){
        gameRepository.save(game);
    }
}
