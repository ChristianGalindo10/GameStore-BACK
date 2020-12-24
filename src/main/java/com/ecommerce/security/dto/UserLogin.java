package com.ecommerce.security.dto;

import javax.validation.constraints.NotBlank;

public class UserLogin {

	@NotBlank
    private String name;
    @NotBlank
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String nombreUsuario) {
        this.name = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
