package com.corhuila.Ordering.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.Ordering.models.ClienteModel;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Long>{
    public abstract ArrayList<ClienteModel> findByNombre (String nombre);
}
