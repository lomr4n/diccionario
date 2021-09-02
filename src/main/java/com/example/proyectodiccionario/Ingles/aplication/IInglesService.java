package com.example.proyectodiccionario.Ingles.aplication;

import com.example.proyectodiccionario.Espanol.domain.EspanolInputDto;
import com.example.proyectodiccionario.Espanol.domain.EspanolSimpleOutputDto;
import com.example.proyectodiccionario.Ingles.domain.InglesInputDto;
import com.example.proyectodiccionario.Ingles.domain.InglesOutputDto;
import com.example.proyectodiccionario.Ingles.domain.InglesSimpleOutputDto;

import java.util.List;

public interface IInglesService {
    public List<InglesSimpleOutputDto> buscarTodos() throws Exception;
    public InglesSimpleOutputDto buscarPorPalabra(String palabra) throws Exception;
    public InglesSimpleOutputDto anadir(InglesInputDto palabra) throws Exception;
    public InglesSimpleOutputDto modificar(String palabra, InglesInputDto inglesInputDto) throws Exception;
    public String borrar(String palabra) throws Exception;
}
