package com.example.proyectodiccionario.Espanol.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EspanolSimpleOutputDto {
    private int id;
    private String palabra;
    private String descripcion;
    private Date fecha_alta;
    private Date fecha_modif;

    public EspanolSimpleOutputDto(Espanol espanol){
        setId(espanol.getId());
        setPalabra(espanol.getPalabra());
        setDescripcion(espanol.getDescripcion());
        setFecha_alta(espanol.getFecha_alta());
        setFecha_modif(espanol.getFecha_modif());
    }
}
