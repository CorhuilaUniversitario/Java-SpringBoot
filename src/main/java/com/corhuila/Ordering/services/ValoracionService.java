package com.corhuila.Ordering.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.Ordering.models.ValoracionModel;
import com.corhuila.Ordering.repositories.ValoracionRepository;

@Service
public class ValoracionService {
    @Autowired
    ValoracionRepository valoracionRepository;

//Creamos un Metodo para Visualizar las valoraciones
    public ArrayList<ValoracionModel> visualizarValoracion(){
        return (ArrayList<ValoracionModel>) valoracionRepository.findAll();
    }

//Creamos un metodo para Agregar la valoracion    
    public ValoracionModel agregarValoracion(ValoracionModel valoracion){
        return valoracionRepository.save(valoracion);

    }

//Creamos un metodo para buscar el valoracion por ID
    public Optional <ValoracionModel> busquedaValoracionID(Long id){
        return valoracionRepository.findById(id);
    }

//Creamos un metodo para buscar valoraciones por Nombre
    public ArrayList <ValoracionModel> busquedaValoracionTecnico(String tecnico){
        return valoracionRepository.findByTecnico(tecnico);
    }

//Creamos un metodo para eliminar valoraciones por Id    
    public boolean eliminarValoracion (Long id){
        try{
            valoracionRepository.deleteById(id);
            return true;
        } catch(Exception err){
            return false;
        }
    }
}

