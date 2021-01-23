package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@Column(name = "idPedido")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idPedido;
	
	@ManyToOne
    @JoinColumn(name = "id")
    private User user;
	
	@Transient
	private long idUser;
	
	@JoinTable(
	        name = "rel_games_pedidos",
	        joinColumns = @JoinColumn(name = "FK_PEDIDO", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="FK_GAME", nullable = false)
	    )
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Game> games;
	
	@JsonProperty 
	public Long getUserId(){ 
		return user.getId();
	}
	
	public void addGame(Game game){
        if(this.games == null){
            this.games = new ArrayList<>();
        }
        this.games.add(game);
    }
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	
	public int getIdPedido() {
		return this.idPedido;
	}
	
	public List<Game> getGames(){
		return this.games;
	}
	
	public void setGames(List<Game> games) {
		this.games = games;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	
	
}
