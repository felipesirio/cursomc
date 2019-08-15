package com.exemplo.aulamc.controller;

import com.exemplo.aulamc.domain.Pedido;
import com.exemplo.aulamc.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable Integer id){
        Pedido ped = pedidoService.buscar(id);
        return (ped != null) ? ResponseEntity.ok().body(ped) : ResponseEntity.notFound().build();
    }
}
