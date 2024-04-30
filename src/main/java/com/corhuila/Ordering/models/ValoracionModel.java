package com.corhuila.Ordering.models;

import jakarta.persistence.*;

//Le damos Nombre  a la tabla
@Entity
@Table(name = "valoracion")
public class ValoracionModel {

    // Creamos una Id autogenerable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String tecnico;
    private Long idOrden;
    private String diagnostico;
    private String fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String nombre) {
        this.tecnico = nombre;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String identificacion) {
        this.diagnostico = identificacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String usuario) {
        this.fecha = usuario;
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    
    

}
