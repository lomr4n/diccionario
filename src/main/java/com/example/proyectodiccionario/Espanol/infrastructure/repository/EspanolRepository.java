package com.example.proyectodiccionario.Espanol.infrastructure.repository;

import com.example.proyectodiccionario.Espanol.domain.Espanol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspanolRepository extends JpaRepository<Espanol, String> {
    boolean existsByPalabra(String palabra);
    void deleteByPalabra(String palabra);
    Espanol findByPalabra(String palabra);
}
