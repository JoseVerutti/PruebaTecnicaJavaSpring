package com.prueba.tecnica.models;
import java.time.LocalDate;


import jakarta.persistence.*;

@Entity
@Table(name= "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;

    private String titulo;
    private String autor;
    private LocalDate fechaDePublicacion;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(LocalDate fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }


}
