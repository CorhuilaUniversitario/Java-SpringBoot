package com.corhuila.Ordering.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.Ordering.models.EntregaModel;

@Repository
public interface EntregaRepository extends CrudRepository<EntregaModel, Long>{
    public abstract ArrayList<EntregaModel> findByidValoracion (Long idValoracion);
}
