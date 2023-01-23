package com.example.apirest_prueba.repositorios;


import com.example.apirest_prueba.modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository// anotaciones que se les ponen a las clases o interfaces que acceden directamente a la base de datos
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {// se extiende a un repository ya creado y como parametro resive la entidad en este caso cliente y el tipo de dato  del id
}
