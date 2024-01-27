package com.eldar.demo.Auxiliares;

/**
 * Implementación de la clase Persona (solamente guarda nombre y apellido).
 * Decidí crear esta clase por si es necesario agregar más datos de la persona a futuro. 
 * Además, es una clase bastante corta y sencilla.
 */
public class Persona {
    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}