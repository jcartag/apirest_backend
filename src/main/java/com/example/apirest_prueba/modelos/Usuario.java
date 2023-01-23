package com.example.apirest_prueba.modelos;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// anotacion para que el id sea autoincrementable
    private long id_usuario;

    private String nombre_usuario;

    private String apellido_usuario;

    private long edad_usuario;

    private String sexo_usuario;

    private long telefono_usuario;

    private String estado_civil;

    public Usuario() {
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public long getEdad_usuario() {
        return edad_usuario;
    }

    public void setEdad_usuario(long edad_usuario) {
        this.edad_usuario = edad_usuario;
    }

    public String getSexo_usuario() {

        return sexo_usuario;
    }

    public void setSexo_usuario(String sexo_usuario) {

        this.sexo_usuario = sexo_usuario;
    }

    public long getTelefono_usuario() {

        return telefono_usuario;
    }

    public void setTelefono_usuario(long telefono_usuario) {

        this.telefono_usuario = telefono_usuario;
    }

    public String getEstado_civil() {

    return estado_civil;

    }

    public void setEstado_civil(String estado_civil) {

        this.estado_civil = estado_civil;

    }

}

