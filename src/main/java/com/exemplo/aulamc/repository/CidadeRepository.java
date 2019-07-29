package com.exemplo.aulamc.repository;

import com.exemplo.aulamc.domain.Categoria;
import com.exemplo.aulamc.domain.Cidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, Integer> {
}
