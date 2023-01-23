package com.example.apirest_prueba.controladores;

import com.example.apirest_prueba.modelos.Usuario;
import com.example.apirest_prueba.servicios.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController //esta anotacion es para indicarle que es controlador de tipo rest
@RequestMapping("/api") //realizar la asignacion de la url de inicio para realizar las peticiones http
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class UsuarioControler {


    @Autowired//inyeccion de dependencia donde se devuelven los metodos que estan implementados en la clase ClienteServicioImpl
    UsuarioServiceImpl usuarioService;

    @GetMapping("/usuario")
    public List<Usuario> obtenerUsuario() { // este metodo devuelte el listado de clientes que se tenga en la base de datos
        return usuarioService.getAll();
    }


    @PostMapping("/guardar")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) { //@RequestBody se obtiene los datos de la peticio y se transforma en un objeto de tipo cliente
        Usuario nuevo_usuario = usuarioService.save(usuario);// para agregar un nuevo cliente se debe crear primero en java y se le manda como parametro el cliente para crearlo
        return new ResponseEntity<>(nuevo_usuario, HttpStatus.CREATED);// con HttpStatus.CREATED se le manda el recurso cuando se ha creato exitosamente, se personaliza la respuesta del api
    }


    @GetMapping("/usuario/{id}")//cuando se encierra el llaves el id se vuelve dinamico
    public ResponseEntity<Usuario> obtenerUsuarioId(@PathVariable long id) {//el id de devuelve cuando se manda la peticion y se obtiene con la peticion @PathVariable
        Usuario usuarioPorId = usuarioService.getById(id);// se crea un nuevo cliente se guarda en la variable clientePorId y se retorna

        return ResponseEntity.ok(usuarioPorId);//le pasamos por el body el cliente que se creo
    }


    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable long id, @RequestBody Usuario usuario) {// se le pasan dos parametros par identificar el cliente que se va a modificar, y los nuevos datos del cliente en el jormato de java
        //cuando el cliente se haya actualizado vamos a ob tener los datos con la anotacion  @RequestBody

        Usuario usuarioPorId = usuarioService.getById(id);
        usuarioPorId.setNombre_usuario(usuario.getNombre_usuario());
        usuarioPorId.setApellido_usuario(usuario.getApellido_usuario());
        usuarioPorId.setEdad_usuario(usuario.getEdad_usuario());
        usuarioPorId.setSexo_usuario(usuario.getSexo_usuario());
        usuarioPorId.setTelefono_usuario(usuario.getTelefono_usuario());
        usuarioPorId.setEstado_civil(usuario.getEstado_civil());


        Usuario Usuario_actualizado = usuarioService.save(usuarioPorId);
        return new ResponseEntity<>(Usuario_actualizado, HttpStatus.CREATED);
    }


    @DeleteMapping("/usuario/{id}")//id dinamico
    public ResponseEntity<HashMap<String, Boolean>> eliminarUsuario(@PathVariable long id) {
        this.usuarioService.delete(id);// solo elimina y ya,  pero con el HasMap devulve la respuesta de la peticion
        HashMap<String, Boolean> estadoUsuarioEliminado = new HashMap<>();//  se esta creando un nuevo HasMap
        estadoUsuarioEliminado.put("Eliminado", true);
        return ResponseEntity.ok(estadoUsuarioEliminado);
    }
}