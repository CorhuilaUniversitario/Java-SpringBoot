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

import com.corhuila.Ordering.models.LoginModel;
import com.corhuila.Ordering.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;

//Visualizar Login    
    @GetMapping
    public ArrayList<LoginModel> verLogin(){
        return loginService.visualizarLogin();
    }

//Agregar Login
    @PostMapping
    public LoginModel insertarLogin(@RequestBody LoginModel login){
        return this.loginService.agregarLogin(login);
    }

//Buscar Login por ID    
    @GetMapping(path = "/{id}")
    public Optional <LoginModel> obtenerLoginId (@PathVariable("id") Long id){
        return this.loginService.busquedaLoginID(id);
    }

//Busqueda Login Nombre    
    @GetMapping("/query")
    public ArrayList<LoginModel> obtenerLoginNombre(@RequestParam ("nombre") String nombre){
        return this.loginService.busquedaLoginNombre(nombre);
    }

//Validar Usuario y Clave
    @PostMapping("/iniciar")
    public ArrayList<LoginModel> ValidarSesion(@RequestBody LoginModel login){
        return this.loginService.iniciarSesion(login);
    }    

//Eliminar Login por ID    
    @DeleteMapping (path = "/{id}")
    public String eliminarLoginporID (@PathVariable("id") Long id){
        boolean ok = this.loginService.eliminarLogin(id);
        if(ok){
            return "Se elimino el login con el ID "+id;
        }else{
            return "No se pudo eliminar el ogin con el ID "+id;
        }
    }

}
