package com.ecommerce.security.service;

import com.ecommerce.model.User;
import com.ecommerce.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {
	@Autowired
    UserRepository usuarioRepository;

    public Optional<User> getByName(String name){
        return usuarioRepository.findByName(name);
    }
    
    public User getById(long id){
        return usuarioRepository.findById(id);
    }

    public boolean existsByName(String nombreUsuario){
        return usuarioRepository.existsByName(nombreUsuario);
    }

    public void save(User usuario){
        usuarioRepository.save(usuario);
    }
}
