package com.example.apirest_prueba.servicios;

import com.example.apirest_prueba.modelos.Cliente;
import com.example.apirest_prueba.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // esta anotacion es para que reconozca la clase como un servicio
public class ClienteServicioImpl implements IClienteServicio{

    @Autowired//con esta notacion se hace un inyeccion de dependencia implicita para este objeto por lo tanto no hay necesidad de instanciar la interfaz  ClienteRepositorio
    ClienteRepositorio clienteRepositorio;


    @Override
    public List<Cliente> getAll() {
        return clienteRepositorio.findAll();//devuelve todos los clientes que esten en la base de datos, este metodo es propio de JPaRepositorio desdes se extendio de la carpeta repositorio
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente getById(long id) {
        return clienteRepositorio.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        clienteRepositorio.deleteById(id);
    }
}
