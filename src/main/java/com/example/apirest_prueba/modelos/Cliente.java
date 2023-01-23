package com.example.apirest_prueba.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;


@Entity//anotacion de identidad para que lo reconozca el api de java
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1l;//requisito para utilizar las clases de jpa

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// anotacion para que el id sea autoincrementable
    private long id;

    private String nombre;

    private String apellido;

    private String email;

    public Cliente(){}

    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

