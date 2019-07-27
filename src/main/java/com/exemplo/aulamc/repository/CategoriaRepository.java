package com.exemplo.aulamc.repository;

import com.exemplo.aulamc.domain.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
}
