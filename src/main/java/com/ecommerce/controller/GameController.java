package com.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "games")
public class GameController {

	private byte[] bytes;
	
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
	public void createGame(@RequestBody Game game) throws IOException {
		game.setPicByte(this.bytes);
		gameRepository.save(game);
		this.bytes = null;
	}
	
	@PutMapping("/updatei")
	public void updateGameI(@RequestBody Game game) {
		game.setPicByte(this.bytes);
		gameRepository.save(game);
		this.bytes = null;
	}
	
	@PutMapping("/update")
	public void updateGame(@RequestBody Game game) {
		gameRepository.save(game);
	}

	@DeleteMapping(path = { "/{id}" })
	public Game deleteGame(@PathVariable("id") long id) {
		Game game = gameRepository.getOne(id);
		gameRepository.deleteById(id);
		return game;
	}
}
