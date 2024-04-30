package com.corhuila.Ordering.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.Ordering.models.OrdenModel;
import com.corhuila.Ordering.repositories.OrdenRepository;

@Service
public class OrdenService {
    @Autowired
    OrdenRepository ordenRepository;

//Creamos un Metodo para Visualizar Ordnes
    public ArrayList<OrdenModel> visualizarOrdenes(){
        return (ArrayList<OrdenModel>) ordenRepository.findAll();
    }

//Creamos un metodo para Agregar Ordenes    
    public OrdenModel agregarOrden(OrdenModel orden){
        return ordenRepository.save(orden);

    }

//Creamos un metodo para buscar orden  por ID
    public Optional <OrdenModel> busquedaOrdenID(Long id){
        return ordenRepository.findById(id);
    }

//Creamos un metodo para buscar ordenes por Servicio
    public ArrayList <OrdenModel> busquedaOrdenServicio(String servicio){
        return ordenRepository.findByServicio(servicio);
    }

//Creamos un metodo para eliminar Orden por Id    
    public boolean eliminarOrden (Long id){
        try{
            ordenRepository.deleteById(id);
            return true;
        } catch(Exception err){
            return false;
        }
    }
}


