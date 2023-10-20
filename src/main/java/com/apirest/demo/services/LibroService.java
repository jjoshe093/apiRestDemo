package com.apirest.demo.services;

import com.apirest.demo.entities.Libro;
import com.apirest.demo.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository repository;

    public List<Libro> buscarTodos(){
        if (repository.count()>0){
            return repository.findAll();
        }else{
            return new ArrayList<>();
        }
    }

    public Libro crear(Libro libro){
        if(libro.getId_libro()==null){
            return repository.save(libro);
        }
        return null;
    }

    public Optional<Libro> buscarPorId(Long id){
        if(id!=null){
            return repository.findById(id);
        }
        return null;
    }

    public Libro actualizar(Libro libro){
        return repository.save(libro);
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }

}
