package com.ecommerce.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "game",uniqueConstraints={@UniqueConstraint(columnNames = {"name"})})
public class Game {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", unique=true)
	private String name;

	@Column(name = "developer")
	private String developer;
	
	@Column(name = "price")
	private Long price;

	@Column(name = "picByte", length = 10000)
	private byte[] picByte;
	
	@ManyToOne
    @JoinColumn(name = "idCat")
	@JsonBackReference
    private Category category;
	

	@ManyToMany(mappedBy = "games",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Pedido> pedidos;
	
	@Transient
	private int idCatT;
	
	@JsonProperty 
	public int getCategoryId(){ 
		return category!=null ? category.getIdCat():-1;
	}
	
	@JsonProperty 
	public String getCategoryName(){ 
		return category!=null ? category.getName() : "Ninguna";
	} 

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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
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
	
	public int getIdCatT() {
		return idCatT;
	}

	public void setIdCatT(int idCatT) {
		this.idCatT = idCatT;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
