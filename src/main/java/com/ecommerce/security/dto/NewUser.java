package com.ecommerce.security.dto;

import javax.validation.constraints.NotBlank;

public class NewUser {
	@NotBlank
    private String nombre;
    @NotBlank
    private String password;
    private String type;

    public String getName() {
        return nombre;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setType(String type) {
    	this.type = type;
    }
    
    public String getType() {
    	return this.type;
    }
}
