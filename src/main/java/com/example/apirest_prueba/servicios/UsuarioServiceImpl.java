package com.example.apirest_prueba.servicios;

import com.example.apirest_prueba.modelos.Usuario;
import com.example.apirest_prueba.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;


    @Override
    public List<Usuario> getAll() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario getById(long id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        usuarioRepositorio.deleteById(id);
    }
}
