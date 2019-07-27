package com.exemplo.aulamc.service;

import com.exemplo.aulamc.domain.Categoria;
import com.exemplo.aulamc.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id){
        Optional<Categoria> cat = categoriaRepository.findById(id);
        return cat.orElse(null);
    }
}
