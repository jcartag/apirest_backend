package com.example.apirest_prueba.controladores;


import com.example.apirest_prueba.modelos.Cliente;
import com.example.apirest_prueba.servicios.ClienteServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController //esta anotacion es para indicarle que es controlador de tipo rest
@RequestMapping("/api/v1") //realizar la asignacion de la url de inicio para realizar las peticiones http
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class ClienteControlador {

    @Autowired//inyeccion de dependencia donde se devuelven los metodos que estan implementados en la clase ClienteServicioImpl
    ClienteServicioImpl clienteServicio;

    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes(){ // este metodo devuelte el listado de clientes que se tenga en la base de datos
        return clienteServicio.getAll();
    }


    @PostMapping("/guardar")
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente){ //@RequestBody se obtiene los datos de la peticio y se transforma en un objeto de tipo cliente
        Cliente nuevo_cliente = clienteServicio.save(cliente);// para agregar un nuevo cliente se debe crear primero en java y se le manda como parametro el cliente para crearlo
        return new ResponseEntity<>(nuevo_cliente, HttpStatus.CREATED);// con HttpStatus.CREATED se le manda el recurso cuando se ha creato exitosamente, se personaliza la respuesta del api
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/cliente/{id}")//cuando se encierra el llaves el id se vuelve dinamico
    public ResponseEntity<Cliente> obtenerClienteId(@PathVariable long id){//el id de devuelve cuando se manda la peticion y se obtiene con la peticion @PathVariable
        Cliente clientePorId = clienteServicio.getById(id);// se crea un nuevo cliente se guarda en la variable clientePorId y se retorna

        return ResponseEntity.ok(clientePorId);//le pasamos por el body el cliente que se creo
    }



    @PutMapping("/cliente/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable long id, @RequestBody Cliente cliente){// se le pasan dos parametros par identificar el cliente que se va a modificar, y los nuevos datos del cliente en el jormato de java
        //cuando el cliente se haya actualizado vamos a ob tener los datos con la anotacion  @RequestBody

        Cliente clientePorId = clienteServicio.getById(id);
        clientePorId.setNombre(cliente.getNombre());
        clientePorId.setApellido(cliente.getApellido());
        clientePorId.setEmail(cliente.getEmail());

        Cliente cliente_actualizado = clienteServicio.save(clientePorId);
        return  new ResponseEntity<>(cliente_actualizado, HttpStatus.CREATED);
    }



    @DeleteMapping("/cliente/{id}")//id dinamico
    public ResponseEntity<HashMap<String, Boolean>> eliminarCliente(@PathVariable long id){
        this.clienteServicio.delete(id);// solo elimina y ya,  pero con el HasMap devulve la respuesta de la peticion

        HashMap<String, Boolean> estadoClienteEliminado = new HashMap<>();//  se esta creando un nuevo HasMap
        estadoClienteEliminado.put("Eliminado", true);
        return ResponseEntity.ok(estadoClienteEliminado);// se personaliza la respuesta Http
    }


}
