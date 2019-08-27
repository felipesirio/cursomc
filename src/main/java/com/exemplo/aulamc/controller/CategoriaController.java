package com.exemplo.aulamc.controller;

import com.exemplo.aulamc.domain.Categoria;
import com.exemplo.aulamc.dto.CategoriaDTO;
import com.exemplo.aulamc.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(value="categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable Integer id){
        Categoria cat = categoriaService.buscar(id);
        return (cat != null) ? ResponseEntity.ok().body(cat) : ResponseEntity.notFound().build();
    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> buscarTodos(){
        Iterable<Categoria> categorias = categoriaService.buscarTodos();
        List<CategoriaDTO> categoriasDTO =
                StreamSupport.stream(categorias.spliterator(), false)
                        .map(cat -> new CategoriaDTO(cat))
                        .collect(Collectors.toList());
        return (categorias != null) ? ResponseEntity.ok().body(categoriasDTO) : ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserir(@RequestBody Categoria cat){
        cat = categoriaService.inserir(cat);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cat.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> alterar(@RequestBody Categoria cat, @PathVariable Integer id){
        cat.setId(id);
        cat = categoriaService.alterar(cat);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
       categoriaService.deletar(id);
       return ResponseEntity.noContent().build();
    }
}
