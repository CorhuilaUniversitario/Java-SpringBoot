package com.corhuila.Ordering.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.Ordering.models.EntregaModel;
import com.corhuila.Ordering.repositories.EntregaRepository;

@Service
public class EntregaService {
    @Autowired
    EntregaRepository entregaRepository;

//Creamos un Metodo para Visualizar los entregas
    public ArrayList<EntregaModel> visualizarEntregas(){
        return (ArrayList<EntregaModel>) entregaRepository.findAll();
    }

//Creamos un metodo para Agregar las entregas    
    public EntregaModel agregarEntergas(EntregaModel entrega){
        return entregaRepository.save(entrega);

    }

//Creamos un metodo para buscar la entregas por ID
    public Optional <EntregaModel> busquedaEntregasID(Long id){
        return entregaRepository.findById(id);
    }

//Creamos un metodo para buscar las entregas por idValoracion
    public ArrayList <EntregaModel> busquedaEntregasidValoracion (Long idValoracion){
        return entregaRepository.findByidValoracion(idValoracion);
    }

//Creamos un metodo para eliminar las entregas por Id    
    public boolean eliminarEnterga (Long id){
        try{
            entregaRepository.deleteById(id);
            return true;
        } catch(Exception err){
            return false;
        }
    }
}

