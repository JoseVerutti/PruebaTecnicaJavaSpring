package com.prueba.tecnica.services;


import com.prueba.tecnica.models.Usuario;
import com.prueba.tecnica.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioServices {

    @Autowired
    IUserRepo UserRepo;

    public ArrayList<Usuario> getUsers(){
        return (ArrayList<Usuario>) UserRepo.findAll();
    }

    public Usuario createUser(Usuario user) {
        return UserRepo.save(user);
    }

    public Optional<Usuario> getUserById(Long id) {
        return UserRepo.findById(id);
    }

    public Usuario updateUser(Long id, Usuario updatedUser) {
        return UserRepo.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return UserRepo.save(user);
        }).orElseGet(() -> {
            updatedUser.setId(id);
            return UserRepo.save(updatedUser);
        });
    }

    public boolean deleteUser(Long id) {
        try {
            UserRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
