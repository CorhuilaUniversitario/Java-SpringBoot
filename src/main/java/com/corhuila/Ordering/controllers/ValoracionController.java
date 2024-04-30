package com.corhuila.Ordering.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.Ordering.models.ValoracionModel;
import com.corhuila.Ordering.services.ValoracionService;

@RestController
@RequestMapping("/valoracion")
public class ValoracionController {
    @Autowired
    ValoracionService valoracionService;

//Visualizar Valoracion    
    @GetMapping
    public ArrayList<ValoracionModel> verValoracion(){
        return valoracionService.visualizarValoracion();
    }

//Agregar Valoracion
    @PostMapping
    public ValoracionModel insertarValoracion(@RequestBody ValoracionModel valoracion){
        return this.valoracionService.agregarValoracion(valoracion);
    }

//Buscar Valoracion por ID    
    @GetMapping(path = "/{id}")
    public Optional <ValoracionModel> obtenerValoracionId (@PathVariable("id") Long id){
        return this.valoracionService.busquedaValoracionID(id);
    }

//Busqueda Valoracion Nombre    
    @GetMapping("/query")
    public ArrayList<ValoracionModel> obtenerValoracionTecnico(@RequestParam ("tecnico") String tecnico){
        return this.valoracionService.busquedaValoracionTecnico(tecnico);
    }

//Eliminar Valoracion por ID    
    @DeleteMapping (path = "/{id}")
    public String eliminarValoracionporID (@PathVariable("id") Long id){
        boolean ok = this.valoracionService.eliminarValoracion(id);
        if(ok){
            return "Se elimino la valoracion con el ID "+id;
        }else{
            return "No se pudo eliminar la valoracion con el ID "+id;
        }
    }

}

