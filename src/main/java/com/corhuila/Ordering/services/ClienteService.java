package com.corhuila.Ordering.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.Ordering.models.ClienteModel;
import com.corhuila.Ordering.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

//Creamos un Metodo para Visualizar los clientes
    public ArrayList<ClienteModel> visualizarClientes(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

//Creamos un metodo para Agregar los Clientes    
    public ClienteModel agregarClientes(ClienteModel cliente){
        return clienteRepository.save(cliente);

    }

//Creamos un metodo para buscar el cliente por ID
    public Optional <ClienteModel> busquedaClientesID(Long id){
        return clienteRepository.findById(id);
    }

//Creamos un metodo para buscar el cliente por Nombre
    public ArrayList <ClienteModel> busquedaClientesNombre (String nombre){
        return clienteRepository.findByNombre(nombre);
    }

//Creamos un metodo para eliminar el cliente por Id    
    public boolean eliminarCliente (Long id){
        try{
            clienteRepository.deleteById(id);
            return true;
        } catch(Exception err){
            return false;
        }
    }
}
