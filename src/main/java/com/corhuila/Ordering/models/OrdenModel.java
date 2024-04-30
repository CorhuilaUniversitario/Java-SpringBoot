package com.corhuila.Ordering.models;

import jakarta.persistence.*;

//Le damos Nombre  a la tabla
@Entity
@Table(name = "ordenes")
public class OrdenModel {

    // Creamos una Id autogenerable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String dispositivo;
    private String falla;
    private String servicio;
    private String fecha;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDispositivo() {
        return dispositivo;
    }
    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }
    public String getFalla() {
        return falla;
    }
    public void setFalla(String falla) {
        this.falla = falla;
    }
    public String getServicio() {
        return servicio;
    }
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    

}
