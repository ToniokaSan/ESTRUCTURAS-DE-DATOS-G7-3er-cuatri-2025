/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

/**
 * Clase lista de preguntas es una lista simple la cual permite guardar informacion como preguntas.
 * @Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez
 * Badilla, Sebastian Alvarez Murillo.
 */
public class ListaPreguntas {
    private NodoPregunta cabeza;

    public ListaPreguntas() {
        cabeza = null;
    }

    public NodoPregunta getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoPregunta cabeza) {
        this.cabeza = cabeza;
    }
    /**
     * Metodo agregar pregunta, agrega una pregunta al nodo.
     * @param p 
     */
    public void agregarPregunta(Pregunta p) {
        NodoPregunta nuevo = new NodoPregunta(p);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoPregunta aux = cabeza;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }
    /**
     * Metodo eliminar pregunta elimina una pregunta de la lista simple de preguntas.
     * @param textoPregunta
     * @return 
     */
    public boolean eliminarPregunta(String textoPregunta) {
        if (cabeza == null) {
            return false;
        }

        if (cabeza.getDato().getPregunta().equalsIgnoreCase(textoPregunta)) {
            cabeza = cabeza.getSiguiente();
            return true;
        }

        NodoPregunta actual = cabeza;
        NodoPregunta anterior = null;

        while (actual != null) {
            if (actual.getDato().getPregunta().equalsIgnoreCase(textoPregunta)) {
                anterior.setSiguiente(actual.getSiguiente());
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false; // no se encontró
    }
    
}
