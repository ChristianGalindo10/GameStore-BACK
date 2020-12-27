package com.ecommerce.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(name = "name", unique = true)
	private String name;
	@NotNull
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "type")
	private String type;
	
	@OneToMany(mappedBy = "user")
    private List<Pedido> pedidos;
	
	public User() {
    }
	
	public User(@NotNull String nombre,@NotNull  String password, String type) {
        this.name = nombre;
        this.password = password;
        this.type = type;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public List<Pedido> getPedidos(){
    	return this.pedidos;
    }
    
    public void setPedidos(List<Pedido> pedidos) {
    	this.pedidos = pedidos;
    }
    


}
