package com.exemplo.aulamc.repository;

import com.exemplo.aulamc.domain.Categoria;
import com.exemplo.aulamc.domain.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Integer> {
}
