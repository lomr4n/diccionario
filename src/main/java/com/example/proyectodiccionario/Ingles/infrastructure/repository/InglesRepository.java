package com.example.proyectodiccionario.Ingles.infrastructure.repository;

import com.example.proyectodiccionario.Ingles.domain.Ingles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InglesRepository extends JpaRepository<Ingles, String> {
    boolean existsByPalabra(String palabra);
    void deleteByPalabra(String palabra);
    Ingles findByPalabra(String palabra);
    //    Ingles findByPalabraI(String palabra);
}
