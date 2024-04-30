package com.corhuila.Ordering.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.Ordering.models.LoginModel;

@Repository
public interface LoginRepository extends CrudRepository<LoginModel, Long>{

    //Crear un Arralist para buscar por Nombre
    public abstract ArrayList<LoginModel> findByNombre (String nombre);


    //Crear Un Arralist para Validar el Usuario y clave del Login
    public abstract ArrayList<LoginModel> findByUsuarioAndClave (String usuario, String clave);


}
