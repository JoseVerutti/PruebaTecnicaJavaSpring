package com.prueba.tecnica.services;

import com.prueba.tecnica.models.Prestamo;
import com.prueba.tecnica.models.Usuario;
import com.prueba.tecnica.repositories.IPrestamoRepo;
import com.prueba.tecnica.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PrestamoServices {

    @Autowired
    IPrestamoRepo PrestamoRepo;

    public ArrayList<Prestamo> getPrestamos(){
        return (ArrayList<Prestamo>) PrestamoRepo.findAll();
    }


    public Prestamo createPrestamo(Prestamo prestamo) {
        return PrestamoRepo.save(prestamo);
    }


    public List<Prestamo> getPrestamosByUsuarioId(Long usuarioId) {
        return PrestamoRepo.findByUsuarioId(usuarioId);
    }


    // Registrar la devolución de un libro
    public Optional<Prestamo> registrarDevolucion(Long prestamoId) {
        return PrestamoRepo.findById(prestamoId).map(prestamo -> {
            prestamo.setFechaDevolucion(LocalDate.now());
            return PrestamoRepo.save(prestamo);
        });
    }
}
