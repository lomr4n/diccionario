package com.example.proyectodiccionario.Espanol.domain;

import com.example.proyectodiccionario.Ingles.domain.Ingles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EspanolOutputDto {
    private int id;
    private String palabra;
    private String descripcion;
    private Date fecha_alta;
    private Date fecha_modif;
    private List<Ingles> palabrasIngles;

    public EspanolOutputDto(Espanol espanol){
        setId(espanol.getId());
        setPalabra(espanol.getPalabra());
        setDescripcion(espanol.getDescripcion());
        setFecha_alta(espanol.getFecha_alta());
        setFecha_modif(espanol.getFecha_modif());
        setPalabrasIngles(espanol.getPalabrasIngles());
    }
}
