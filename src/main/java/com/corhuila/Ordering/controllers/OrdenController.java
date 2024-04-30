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

import com.corhuila.Ordering.models.OrdenModel;
import com.corhuila.Ordering.services.OrdenService;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {
    @Autowired
    OrdenService ordenService;

//Visualizar Ordenes   
    @GetMapping
    public ArrayList<OrdenModel> verOrdenes(){
        return ordenService.visualizarOrdenes();
    }

//Agregar Orden
    @PostMapping
    public OrdenModel insertarValoracion(@RequestBody OrdenModel orden){
        return this.ordenService.agregarOrden(orden);
    }

//Buscar Orden por ID    
    @GetMapping(path = "/{id}")
    public Optional <OrdenModel> obtenerOrdenId (@PathVariable("id") Long id){
        return this.ordenService.busquedaOrdenID(id);
    }

//Busqueda Ordenes por Servicio    
    @GetMapping("/query")
    public ArrayList<OrdenModel> obtenerOrdenServicio(@RequestParam ("servicio") String servicio){
        return this.ordenService.busquedaOrdenServicio(servicio);
    }

//Eliminar Ordnen por ID    
    @DeleteMapping (path = "/{id}")
    public String eliminarOrdenporID (@PathVariable("id") Long id){
        boolean ok = this.ordenService.eliminarOrden(id);
        if(ok){
            return "Se elimino la Orden con el ID "+id;
        }else{
            return "No se pudo eliminar la Orden con el ID "+id;
        }
    }

}


