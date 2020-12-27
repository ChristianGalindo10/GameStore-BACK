package com.ecommerce.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "developer")
	private String developer;
	
	@Column(name = "price")
	private String price;

	@Column(name = "picByte", length = 10000)
	private byte[] picByte;
	
	@ManyToOne
    @JoinColumn(name = "idCat")
    private Category category;
	
	@ManyToMany(mappedBy = "games")
	private List<Pedido> pedidos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
	
	public List<Pedido> getPedidos(){
		return this.pedidos;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
