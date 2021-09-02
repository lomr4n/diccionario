package com.example.proyectodiccionario.Ingles.domain;

import com.example.proyectodiccionario.Espanol.domain.Espanol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InglesOutputDto {
    private int id;
    private String palabra;
    private String descripcion;
    private Date fecha_alta;
    private Date fecha_modif;
    private Espanol palabraEspanol;

    public InglesOutputDto(Ingles ingles){
        setId(ingles.getId());
        setPalabra(ingles.getPalabra());
        setDescripcion(ingles.getDescripcion());
        setFecha_alta(ingles.getFecha_alta());
        setFecha_modif(ingles.getFecha_modif());
        setPalabraEspanol(ingles.getPalabraEspanol());
    }
}
