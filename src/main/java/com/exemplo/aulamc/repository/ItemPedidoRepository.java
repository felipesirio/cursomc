package com.exemplo.aulamc.repository;

import com.exemplo.aulamc.domain.ItemPedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Integer> {
}
