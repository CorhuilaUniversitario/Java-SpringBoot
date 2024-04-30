package com.corhuila.Ordering.models;

import jakarta.persistence.*;

//Le damos Nombre  a la tabla
@Entity
@Table(name = "entregas")
public class EntregaModel {

    // Creamos una Id autogenerable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Long idCliente;
    private Long idValoracion;
    private String precio;
    private String fecha;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    public Long getIdValoracion() {
        return idValoracion;
    }
    public void setIdValoracion(Long idValoracion) {
        this.idValoracion = idValoracion;
    }
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    

}

