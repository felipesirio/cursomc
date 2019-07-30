package com.exemplo.aulamc.controller;

import com.exemplo.aulamc.domain.Cliente;
import com.exemplo.aulamc.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable Integer id){
        Cliente cat = clienteService.buscar(id);
        return (cat != null) ? ResponseEntity.ok().body(cat) : ResponseEntity.notFound().build();
    }
}
