package com.example.udea.segundoEjemplo.Controllers;

import com.example.udea.segundoEjemplo.Entities.Persona;
import com.example.udea.segundoEjemplo.Services.PersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PersonaContoller {
    PersonaService servicio = new PersonaService();

    //metodo para mostrar lista

    @GetMapping("listarPersonas")
    public ArrayList<Persona> listar(){
        return servicio.mostrar();
    }

    //metodo para mostrar una persona
    @GetMapping("mostrarPersona/{nombre}")
    public Persona buscar(@PathVariable String nombre){
        return  servicio.buscarNombre(nombre);
    }

    //metodo para agregar persona
    @PostMapping("agregarPersona")
    public String persona(@RequestBody Persona p){
        return servicio.agregarPersona(p);
    }

    @PutMapping("updatePersona")
    public Persona updatePersona(@RequestBody Persona persona){
        return servicio.updatePersona(persona);
    }

    @DeleteMapping("deletePerson/{nombre}")
    public String deletePersona(@PathVariable String nombre){
        return servicio.deletePerson(nombre);
    }

}
