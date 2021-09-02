package com.example.proyectodiccionario.Espanol.aplication;

import com.example.proyectodiccionario.Espanol.domain.Espanol;
import com.example.proyectodiccionario.Espanol.domain.EspanolInputDto;
import com.example.proyectodiccionario.Espanol.domain.EspanolOutputDto;
import com.example.proyectodiccionario.Espanol.domain.EspanolSimpleOutputDto;
import com.example.proyectodiccionario.Espanol.infrastructure.repository.EspanolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;


@Service
public class EspanolService implements  IEspanolService{

    @Autowired
    EspanolRepository espanolRepository;

    @Override
    public List<EspanolOutputDto> buscarTodos() throws Exception {
        try{
            List<EspanolOutputDto> entitiesDto = new ArrayList();
            List<Espanol> entities = espanolRepository.findAll();
            ModelMapper modelMapper = new ModelMapper();
            for (Espanol espanol : entities){
                entitiesDto.add(new EspanolOutputDto(espanol));
            }
            return entitiesDto;
        }catch(Exception e){
            throw new Exception("Error, no se encuentra ninguna palabra en español");
        }
    }

    @Override
    public EspanolOutputDto buscarPorPalabra(String palabra) throws Exception {
        Espanol espanol = espanolRepository.findByPalabra(palabra);
        EspanolOutputDto espanolOutputDto = new EspanolOutputDto(espanol);
        return espanolOutputDto;

    }

    @Override
    public EspanolSimpleOutputDto anadir(EspanolInputDto palabra) throws Exception {
        Espanol espanol = new Espanol(palabra);
        if (this.espanolRepository.existsByPalabra(espanol.getPalabra())) {
            throw new Exception("Esa palabra ya existe");
        }
        espanolRepository.save(espanol);
        return new EspanolSimpleOutputDto(espanol);
    }

    @Override
    public EspanolSimpleOutputDto modificar(String palabra, EspanolInputDto espanolInputDto) throws Exception {
        Espanol espanol = new Espanol(espanolInputDto);
        if (this.espanolRepository.existsByPalabra(palabra)) {
            espanolRepository.save(espanol);
        }
        else{
            throw new Exception("Esa palabra no existe");
        }
        return new EspanolSimpleOutputDto(espanol);
    }

    @Override
    public String borrar(String palabra) throws Exception {
        if (this.espanolRepository.existsByPalabra(palabra)) {
            espanolRepository.deleteByPalabra(palabra);
        }else{
            throw new Exception("Esa palabra no existe");
        }
        return "Borrada";
    }
}
