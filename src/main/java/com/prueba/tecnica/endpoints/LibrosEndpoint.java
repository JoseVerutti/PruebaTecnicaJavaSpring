package com.prueba.tecnica.endpoints;

import com.prueba.tecnica.models.Libro;
import com.prueba.tecnica.models.Usuario;
import com.prueba.tecnica.services.LibroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/libro")
public class LibrosEndpoint {

    @Autowired
    LibroServices libroServices;

    @PostMapping()
    private Libro createUser(@RequestBody Libro libro){
        return  this.libroServices.createLibro(libro);
    }

    @DeleteMapping("/{id}")
    private boolean deleteUser(@PathVariable("id") Long id) {
        return this.libroServices.deleteLibro(id);
    }
}
