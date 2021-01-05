package com.ecommerce.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "category",uniqueConstraints={@UniqueConstraint(columnNames = {"name"})})
public class Category {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idCat;
	
	@NotNull
	@Column(name = "name", unique = true)
	private String name;
	
	@OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<Game> games;

	public int getIdCat() {
		return idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	
}
