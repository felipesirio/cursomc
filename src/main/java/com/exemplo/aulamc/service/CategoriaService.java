package com.exemplo.aulamc.service;

import com.exemplo.aulamc.domain.Categoria;
import com.exemplo.aulamc.repository.CategoriaRepository;
import com.exemplo.aulamc.service.exceptions.DataIntegrityException;
import com.exemplo.aulamc.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id){
        Optional<Categoria> cat = categoriaRepository.findById(id);
        return cat.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada! " +
                "Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria inserir(Categoria cat){
        cat.setId(null);
        return categoriaRepository.save(cat);
    }

    public Categoria alterar(Categoria cat){
        buscar(cat.getId());
        return categoriaRepository.save(cat);
    }

    public void deletar(Integer id) {
        try {
            categoriaRepository.deleteById(id);
        } catch(DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possível deletar uma categoria que já possui produtos.");
        }

    }
}
