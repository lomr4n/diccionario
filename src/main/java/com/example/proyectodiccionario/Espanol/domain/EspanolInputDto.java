package com.example.proyectodiccionario.Espanol.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EspanolInputDto {
    private String palabra;
    private String descripcion;
}
