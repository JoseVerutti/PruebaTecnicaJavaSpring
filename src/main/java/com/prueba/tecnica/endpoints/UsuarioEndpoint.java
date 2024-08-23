package com.prueba.tecnica.endpoints;


import com.prueba.tecnica.models.Usuario;
import com.prueba.tecnica.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UsuarioEndpoint {


    @Autowired
    UsuarioServices usuarioServices;

    @GetMapping()
    private ArrayList<Usuario> getUsers(){
        return this.usuarioServices.getUsers();
    }

    @PostMapping()
    private Usuario createUser(@RequestBody Usuario user){
        return  this.usuarioServices.createUser(user);
    }

    @GetMapping("/{id}")
    private Usuario getUserById(@PathVariable("id") Long id) {
        return this.usuarioServices.getUserById(id).orElse(null);
    }

    @PutMapping("/{id}")
    private Usuario updateUser(@PathVariable("id") Long id, @RequestBody Usuario updatedUser) {
        return this.usuarioServices.updateUser(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    private boolean deleteUser(@PathVariable("id") Long id) {
        return this.usuarioServices.deleteUser(id);
    }

}
