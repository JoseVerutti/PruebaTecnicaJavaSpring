package com.prueba.tecnica.repositories;


import com.prueba.tecnica.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepo extends JpaRepository<Libro, Long> {
}
