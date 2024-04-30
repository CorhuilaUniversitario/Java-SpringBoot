package com.corhuila.Ordering.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.Ordering.models.LoginModel;
import com.corhuila.Ordering.repositories.LoginRepository;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginrepository;

//Creamos un Metodo para Visualizar el Login
    public ArrayList<LoginModel> visualizarLogin(){
        return (ArrayList<LoginModel>) loginrepository.findAll();
    }

//Creamos un metodo para Agregar Login   
    public LoginModel agregarLogin(LoginModel login){
        return loginrepository.save(login);

    }

//Creamos un metodo para buscar login por ID
    public Optional <LoginModel> busquedaLoginID(Long id){
        return loginrepository.findById(id);
    }

//Creamos un metodo para buscar el Login por Nombre
    public ArrayList <LoginModel> busquedaLoginNombre (String nombre){
        return loginrepository.findByNombre(nombre);
    }

//Creamos un metodo para Iniciar Sesion  
    public ArrayList <LoginModel> iniciarSesion(LoginModel login){
        return loginrepository.findByUsuarioAndClave(login.getUsuario(), login.getClave());
    }    

//Creamos un metodo para eliminar login por Id    
    public boolean eliminarLogin (Long id){
        try{
            loginrepository.deleteById(id);
            return true;
        } catch(Exception err){
            return false;
        }
    }
}

