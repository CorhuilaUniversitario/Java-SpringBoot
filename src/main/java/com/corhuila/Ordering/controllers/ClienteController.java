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

import com.corhuila.Ordering.models.ClienteModel;
import com.corhuila.Ordering.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

//Visualizar Clientes    
    @GetMapping
    public ArrayList<ClienteModel> verClientes(){
        return clienteService.visualizarClientes();
    }

//Agregar Cliente
    @PostMapping
    public ClienteModel insertarCliente(@RequestBody ClienteModel cliente){
        return this.clienteService.agregarClientes(cliente);
    }

//Buscar cliente por ID    
    @GetMapping(path = "/{id}")
    public Optional <ClienteModel> obtenerClienteId (@PathVariable("id") Long id){
        return this.clienteService.busquedaClientesID(id);
    }

//Busqueda cliente Nombre    
    @GetMapping("/query")
    public ArrayList<ClienteModel> obtenerClienteNombre(@RequestParam ("nombre") String nombre){
        return this.clienteService.busquedaClientesNombre(nombre);
    }

//Eliminar cliente por ID    
    @DeleteMapping (path = "/{id}")
    public String eliminarClienteporID (@PathVariable("id") Long id){
        boolean ok = this.clienteService.eliminarCliente(id);
        if(ok){
            return "Se elimino el cliente con el ID "+id;
        }else{
            return "No se pudo eliminar el cliente con el ID "+id;
        }
    }

}
