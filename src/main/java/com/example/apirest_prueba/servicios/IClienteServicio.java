package com.example.apirest_prueba.servicios;

import com.example.apirest_prueba.modelos.Cliente;

import java.util.List;

public interface IClienteServicio {

    public List<Cliente> getAll();

    public Cliente save(Cliente cliente);

    public Cliente getById(long id);

    public void  delete(long id);
}
