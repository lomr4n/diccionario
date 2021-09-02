package com.example.proyectodiccionario.Ingles.aplication;

import com.example.proyectodiccionario.Espanol.domain.Espanol;
import com.example.proyectodiccionario.Espanol.domain.EspanolSimpleOutputDto;
import com.example.proyectodiccionario.Espanol.infrastructure.repository.EspanolRepository;
import com.example.proyectodiccionario.Ingles.domain.Ingles;
import com.example.proyectodiccionario.Ingles.domain.InglesInputDto;
import com.example.proyectodiccionario.Ingles.domain.InglesSimpleOutputDto;
import com.example.proyectodiccionario.Ingles.infrastructure.repository.InglesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class InglesService implements IInglesService{

    @Autowired
    InglesRepository inglesRepository;

    @Override
    public List<InglesSimpleOutputDto> buscarTodos() throws Exception {
        try{
            List<InglesSimpleOutputDto> entitiesDto = new ArrayList();
            List<Ingles> entities = inglesRepository.findAll();
            ModelMapper modelMapper = new ModelMapper();
            for (Ingles ingles : entities){
                entitiesDto.add(new InglesSimpleOutputDto(ingles));
            }
            return entitiesDto;
        }catch(Exception e){
            throw new Exception("Error, no se encuentra ninguna palabra en ingles");
        }
    }

    @Override
    public InglesSimpleOutputDto buscarPorPalabra(String palabra) throws Exception {
            Ingles ingles = inglesRepository.findByPalabra(palabra);
            InglesSimpleOutputDto inglesSimpleOutputDto = new InglesSimpleOutputDto(ingles);
            return inglesSimpleOutputDto;
    }

    @Override
    public InglesSimpleOutputDto anadir(InglesInputDto palabra) throws Exception {
        Ingles ingles = new Ingles(palabra);
        if (this.inglesRepository.existsByPalabra(ingles.getPalabra())) {
            throw new Exception("Esa palabra ya existe");
        }
        inglesRepository.save(ingles);
        return new InglesSimpleOutputDto(ingles);
    }

    @Override
    public InglesSimpleOutputDto modificar(String palabra, InglesInputDto inglesInputDto) throws Exception {
        Ingles ingles = new Ingles(inglesInputDto);
        if (this.inglesRepository.existsByPalabra(palabra)) {
            inglesRepository.save(ingles);
        }
        else{
            throw new Exception("Esa palabra no existe");
        }
        return new InglesSimpleOutputDto(ingles);
    }

    @Override
    public String borrar(String palabra) throws Exception {
        if (this.inglesRepository.existsByPalabra(palabra)) {
            inglesRepository.deleteByPalabra(palabra);
        }else{
            throw new Exception("Esa palabra no existe");
        }
        return "Borrada";
    }
}
