package com.exemplo.aulamc.service;

import com.exemplo.aulamc.domain.Pedido;
import com.exemplo.aulamc.repository.PedidoRepository;
import com.exemplo.aulamc.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscar(Integer id){
        Optional<Pedido> cat = pedidoRepository.findById(id);
        return cat.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrado! " +
                "Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
