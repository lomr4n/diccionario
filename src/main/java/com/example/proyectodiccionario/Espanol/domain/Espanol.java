package com.example.proyectodiccionario.Espanol.domain;

import com.example.proyectodiccionario.Ingles.domain.Ingles;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="espanol")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Espanol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="palabra")
    @NotNull
    private String palabra;

    @Column(name="descripcion")
    @NotNull
    private String descripcion;

    @Column(name="fecha_alta")
    @NotNull
    private Date fecha_alta;

    @Column(name="fecha_modif")
    private Date fecha_modif;

    @OneToMany(mappedBy = "palabraEspanol", orphanRemoval = true, cascade = CascadeType.REMOVE)
    List<Ingles> palabrasIngles;

    public Espanol(EspanolInputDto espanolInputDto){
        setPalabra(espanolInputDto.getPalabra());
        setDescripcion(espanolInputDto.getDescripcion());
        setFecha_alta(new Date());
    }
}
