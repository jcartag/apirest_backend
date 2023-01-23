package com.example.apirest_prueba.repositorios;

import com.example.apirest_prueba.modelos.Cliente;
import com.example.apirest_prueba.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository// anotaciones que se les ponen a las clases o interfaces que acceden directamente a la base de datos
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
