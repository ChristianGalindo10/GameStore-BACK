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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.db.GameRepository;
import com.ecommerce.model.Game;
import com.ecommerce.security.dto.Message;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.GameService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "games")
public class GameController {

	private byte[] bytes;
	
	@Autowired
    CategoryService categoryService;
	
	@Autowired
    GameService gameService;
	
	@Autowired
	private GameRepository gameRepository;
	
	@GetMapping("/get")
	public List<Game> getGames() {
		return gameRepository.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Game getGame(@PathVariable("id") long id) {
		return gameRepository.getOne(id);
	}
	
	
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}

	@PostMapping("/add")
	public ResponseEntity<?> createGame(@RequestBody Game game) throws IOException {
		if(gameService.existsByName(game.getName()))
            return new ResponseEntity(new Message("That name already exists, it must be a unique name"), HttpStatus.BAD_REQUEST);
		game.setPicByte(this.bytes);
		int id = game.getIdCatT();
		if(id!=-1) {
			game.setCategory(categoryService.getCategory(id));
		}
		gameRepository.save(game);
		this.bytes = null;
		return new ResponseEntity(new Message("Juego guardado"), HttpStatus.CREATED);
	}
	
	@PutMapping("/updatei")
	public void updateGameI(@RequestBody Game game) {
		game.setPicByte(this.bytes);
		int id = game.getIdCatT();
		if(id!=-1) {
			game.setCategory(categoryService.getCategory(id));
		}else {
			game.setCategory(null);
		}
		gameRepository.save(game);
		this.bytes = null;
	}
	
	@PutMapping("/update")
	public void updateGame(@RequestBody Game game) {
		int id = game.getIdCatT();
		if(id!=-1) {
			game.setCategory(categoryService.getCategory(id));
		}else {
			game.setCategory(null);
		}
		gameRepository.save(game);
	}

	@DeleteMapping(path = { "/{id}" })
	public Game deleteGame(@PathVariable("id") long id) {
		Game game = gameRepository.getOne(id);
		gameRepository.deleteById(id);
		return game;
	}
}
