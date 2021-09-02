package com.example.proyectodiccionario.Ingles.infrastructure;

import com.example.proyectodiccionario.Espanol.aplication.IEspanolService;
import com.example.proyectodiccionario.Espanol.domain.EspanolInputDto;
import com.example.proyectodiccionario.Ingles.aplication.IInglesService;
import com.example.proyectodiccionario.Ingles.domain.InglesInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/ingles")
public class InglesController {
    @Autowired
    IInglesService inglesService;

    @GetMapping("")
    public ResponseEntity<?> get(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(inglesService.buscarTodos());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{palabra}")
    public ResponseEntity<?> getOne(@RequestParam String palabra){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(inglesService.buscarPorPalabra(palabra));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody InglesInputDto palabra){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(inglesService.anadir(palabra));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/{palabra}")
    public ResponseEntity<?> update(@PathVariable String palabra, InglesInputDto inglesInputDto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(inglesService.modificar(palabra,inglesInputDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @DeleteMapping("/{palabra}")
    public ResponseEntity<?> delete(@PathVariable String palabra){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(inglesService.borrar(palabra));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
