package com.apirest.demo.controllers;

import com.apirest.demo.entities.Libro;
import com.apirest.demo.services.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * url swagger: http://localhost:8080/swagger-ui/index.html
 */
@RestController
public class LibroController {

    @Autowired
    private LibroService service;

    @GetMapping("/")
    public String holaMundo(){
        return "José y Nicole Forever and Ever";
    }

    @GetMapping("/api/books")
    @Operation(description = "Devuelve todos los libros", summary = "Obtener todos")
    public ResponseEntity<List<Libro>> findAll(){
        if(service.buscarTodos().isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(service.buscarTodos());
        }
    }

    @PostMapping("/api/books")
    @Operation(description = "Crea un nuevo libro", summary = "Crear")
    public ResponseEntity<Libro> save(@RequestBody Libro libro){
        if(libro.getId_libro()==null){
            return ResponseEntity.ok(service.crear(libro));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/api/books/{id}")
    @Operation(description = "Devuelve un libro por su id", summary = "Obtener uno")
    public ResponseEntity<Libro> findById(@PathVariable Long id){
        if(!service.buscarPorId(id).isEmpty()){
            return ResponseEntity.ok(service.buscarPorId(id).get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/api/books")
    @Operation(description = "Actualiza un libro", summary = "Actualizar")
    public ResponseEntity<Libro> update(@RequestBody Libro libro){
        if(libro.getId_libro()!=null){
            if(service.buscarPorId(libro.getId_libro()).isPresent()){
                return ResponseEntity.ok(service.actualizar(libro));
            }else{
                return ResponseEntity.notFound().build();
            }
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/api/books/{id}")
    @Operation(description = "Elimina un libro por su id", summary = "Eliminar")
    public ResponseEntity<Libro> delete(@PathVariable Long id){
        if(service.buscarPorId(id).isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
