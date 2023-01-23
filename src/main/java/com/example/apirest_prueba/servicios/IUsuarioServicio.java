package com.example.apirest_prueba.servicios;

import com.example.apirest_prueba.modelos.Cliente;
import com.example.apirest_prueba.modelos.Usuario;

import java.util.List;

public interface IUsuarioServicio {

    public List<Usuario> getAll();

    public Usuario save(Usuario usuario);

    public Usuario getById(long id);

    public void  delete(long id);
}
