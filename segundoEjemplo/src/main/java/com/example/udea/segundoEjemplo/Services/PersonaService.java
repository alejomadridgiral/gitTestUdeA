package com.example.udea.segundoEjemplo.Services;

import com.example.udea.segundoEjemplo.Entities.Persona;
import java.time.LocalDate;

import java.util.ArrayList;

public class PersonaService {
    private ArrayList<Persona> lista = new ArrayList<Persona>();

    public PersonaService() {
        lista.add(new Persona("Viviana", "Forero", 38, "Casada", LocalDate.of(1996, 03, 18)));
        lista.add(new Persona("Mateo", "Segura", 13, "Soltero", LocalDate.of(2009, 01, 06)));
        lista.add(new Persona("Camila", "Martinez", 23, "Soltera", LocalDate.of(2000, 11, 21)));
        lista.add(new Persona("Valeria", "Ceballos", 25, "Casada", LocalDate.of(1998, 04, 04)));
        lista.add(new Persona("Jefferson", "Palacios", 40, "Casado", LocalDate.of(1983, 01, 06)));
    }

    //metodo Listar
    public ArrayList<Persona> mostrar(){
        return lista;
    }

    //metodo listar una persona
    public Persona buscarNombre(String nombre){
        Persona p =null;
        for(Persona persona:lista){
            if(persona.getNombre().equals(nombre)){
                p=persona;
                break;
            }
        }
        return p;
    }

    //metodo para agregar persona
    public  String agregarPersona(Persona persona){
        lista.add(persona);
        return "Registro Exitoso!!!";
    }

    //Método para actualizar la información de una persona
    public Persona updatePersona(Persona persona) {
        Persona personaToUpdate = buscarNombre(persona.getNombre());
        if(personaToUpdate != null){
            personaToUpdate.setApellido(persona.getApellido());
            personaToUpdate.setEdad(persona.getEdad());
            personaToUpdate.setEstadoCivil(persona.getEstadoCivil());
            personaToUpdate.setFecha(persona.getFecha());
        }else{
            System.out.println("Recuerda que el nombre no es editable");
        }
        return personaToUpdate;
    }

    //Método para eliminar una persona
    public String deletePerson(String nombre) {
        Persona person = buscarNombre(nombre);
        lista.remove(person);
        return nombre + " se elimino exitosamente";
    }
}
