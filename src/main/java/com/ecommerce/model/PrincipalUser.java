package com.ecommerce.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PrincipalUser implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    
    public PrincipalUser(String nombre,  String password, Collection<? extends GrantedAuthority> authorities) {
        this.name = nombre;
        this.password = password;
        this.authorities = authorities;
    }
    
    public static PrincipalUser build(User usuario){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getType());
        authorities.add(authority);
        return new PrincipalUser(usuario.getName(), usuario.getPassword(), authorities);
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
