package com.exemplo.aulamc.resources;

import com.exemplo.aulamc.domain.Categoria;
import com.exemplo.aulamc.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable Integer id){
        Categoria cat = categoriaService.buscar(id);
        return (cat != null) ? ResponseEntity.ok().body(cat) : ResponseEntity.notFound().build();
    }
}
