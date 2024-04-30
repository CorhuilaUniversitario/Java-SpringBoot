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

import com.corhuila.Ordering.models.EntregaModel;
import com.corhuila.Ordering.services.EntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
    @Autowired
    EntregaService entregaService;

//Visualizar Entregas    
    @GetMapping
    public ArrayList<EntregaModel> verEntregas(){
        return entregaService.visualizarEntregas();
    }

//Agregar Entregas
    @PostMapping
    public EntregaModel insertarEntrega(@RequestBody EntregaModel entrega){
        return this.entregaService.agregarEntergas(entrega);
    }

//Buscar entregas por ID    
    @GetMapping(path = "/{id}")
    public Optional <EntregaModel> obtenerEntergaId (@PathVariable("id") Long id){
        return this.entregaService.busquedaEntregasID(id);
    }

//Busqueda enterga por idValoracion    
    @GetMapping("/query")
    public ArrayList<EntregaModel> obtenerEntregaNombre(@RequestParam ("idvaloracion") Long idValoracion){
        return this.entregaService.busquedaEntregasidValoracion(idValoracion);
    }

//Eliminar entrega por ID    
    @DeleteMapping (path = "/{id}")
    public String eliminarEntregaporID (@PathVariable("id") Long id){
        boolean ok = this.entregaService.eliminarEnterga(id);
        if(ok){
            return "Se elimino la entrega con el ID "+id;
        }else{
            return "No se pudo eliminar la entrega con el ID "+id;
        }
    }

}
