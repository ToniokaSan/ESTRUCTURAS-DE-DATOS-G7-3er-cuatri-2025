package com.universidad.proyectofinal;

/**
 * Nodo simple para almacenar entradas de la bitácora (texto) en una lista enlazada.
 * Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez
 * Badilla, Sebastian Alvarez Murillo.
 */
public class NodoBitacora {
    private String mensaje;
    private NodoBitacora siguiente;

    public NodoBitacora(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public NodoBitacora getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoBitacora siguiente) {
        this.siguiente = siguiente;
    }
}

