package com.prueba.tecnica.repositories;


import com.prueba.tecnica.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<Usuario, Long> {
}