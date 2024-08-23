package com.prueba.tecnica.services;


import com.prueba.tecnica.models.Libro;
import com.prueba.tecnica.models.Usuario;
import com.prueba.tecnica.repositories.ILibroRepo;
import com.prueba.tecnica.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServices {

    @Autowired
    ILibroRepo LibroRepo;

    public Libro createLibro(Libro libro) {
        return LibroRepo.save(libro);
    }

    public boolean deleteLibro(Long id) {
        try {
            LibroRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
