package com.corhuila.Ordering.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.Ordering.models.OrdenModel;

@Repository
public interface OrdenRepository extends CrudRepository<OrdenModel, Long> {
    public abstract ArrayList<OrdenModel> findByServicio(String servicio);
}

