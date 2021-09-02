package com.example.proyectodiccionario.Ingles.domain;

import com.example.proyectodiccionario.Espanol.domain.Espanol;
import com.example.proyectodiccionario.Espanol.domain.EspanolInputDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ingles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="id_palabra_espanol")
    @NotNull
    private int id_palabra_espanol;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "palabraEspanol")
    private Espanol palabraEspanol;

    public Ingles(InglesInputDto inglesInputDto){
        setPalabra(inglesInputDto.getPalabra());
        setFecha_alta(new Date());
    }

}
