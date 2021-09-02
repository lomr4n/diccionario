package com.example.proyectodiccionario.Espanol.infrastructure;

import com.example.proyectodiccionario.Espanol.aplication.IEspanolService;
import com.example.proyectodiccionario.Espanol.domain.EspanolInputDto;
import com.example.proyectodiccionario.Espanol.infrastructure.repository.EspanolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/espanol")
public class EspanolController {

    @Autowired
    IEspanolService espanolService;

    @GetMapping("")
    public ResponseEntity<?> get(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(espanolService.buscarTodos());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{palabra}")
    public ResponseEntity<?> getOne(@RequestParam String palabra){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(espanolService.buscarPorPalabra(palabra));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody EspanolInputDto palabra){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(espanolService.anadir(palabra));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/{palabra}")
    public ResponseEntity<?> update(@PathVariable String palabra, EspanolInputDto espanolInputDto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(espanolService.modificar(palabra,espanolInputDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @DeleteMapping("/{palabra}")
    public ResponseEntity<?> delete(@PathVariable String palabra){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(espanolService.borrar(palabra));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
