package com.example.proyectodiccionario.Espanol.aplication;

import com.example.proyectodiccionario.Espanol.domain.EspanolInputDto;
import com.example.proyectodiccionario.Espanol.domain.EspanolOutputDto;
import com.example.proyectodiccionario.Espanol.domain.EspanolSimpleOutputDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEspanolService {
    public List<EspanolOutputDto> buscarTodos() throws Exception;
    public EspanolOutputDto buscarPorPalabra(String palabra) throws Exception;
    public EspanolSimpleOutputDto anadir(EspanolInputDto palabra) throws Exception;
    public EspanolSimpleOutputDto modificar(String palabra, EspanolInputDto espanolInputDto) throws Exception;
    public String borrar(String palabra) throws Exception;
}
