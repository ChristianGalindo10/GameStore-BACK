package com.ecommerce.security.service;

import com.ecommerce.model.User;
import com.ecommerce.model.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
    UserService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User usuario = usuarioService.getByName(name).get();
        return PrincipalUser.build(usuario);
	}
}
