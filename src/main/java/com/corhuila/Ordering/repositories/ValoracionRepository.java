package com.corhuila.Ordering.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.Ordering.models.ValoracionModel;

@Repository
public interface ValoracionRepository extends CrudRepository<ValoracionModel, Long> {
    public abstract ArrayList<ValoracionModel> findByTecnico(String tecnico);
}
