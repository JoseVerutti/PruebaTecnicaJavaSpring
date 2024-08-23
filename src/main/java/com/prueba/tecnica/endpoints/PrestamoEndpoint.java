package com.prueba.tecnica.endpoints;

import com.prueba.tecnica.models.Prestamo;
import com.prueba.tecnica.services.LibroServices;
import com.prueba.tecnica.services.PrestamoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/prestamo")
public class PrestamoEndpoint {

    @Autowired
    PrestamoServices prestamoServices;


    @GetMapping
    private List<Prestamo> getPrestamos() {
        return prestamoServices.getPrestamos();
    }

    // Crear un nuevo préstamo
    @PostMapping
    private Prestamo createPrestamo(@RequestBody Prestamo prestamo) {
        return prestamoServices.createPrestamo(prestamo);
    }

    // Obtener los préstamos de un usuario específico
    @GetMapping("/usuario/{usuarioId}")
    private List<Prestamo> getPrestamosByUsuarioId(@PathVariable("usuarioId") Long usuarioId) {
        return prestamoServices.getPrestamosByUsuarioId(usuarioId);
    }

    // Registrar la devolución de un libro
    @PutMapping("/devolucion/{prestamoId}")
    private Prestamo registrarDevolucion(@PathVariable("prestamoId") Long prestamoId) {
        Optional<Prestamo> prestamo = prestamoServices.registrarDevolucion(prestamoId);
        return prestamo.orElse(null); // Devuelve null si no se encuentra el préstamo
    }


}
