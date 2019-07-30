package com.exemplo.aulamc.service;

import com.exemplo.aulamc.domain.Cliente;
import com.exemplo.aulamc.repository.ClienteRepository;
import com.exemplo.aulamc.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscar(Integer id){
        Optional<Cliente> cat = clienteRepository.findById(id);
        return cat.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! " +
                "Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }
}
