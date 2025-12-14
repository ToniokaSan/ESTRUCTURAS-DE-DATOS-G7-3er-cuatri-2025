/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

/**
 * Clase nodo pregunta es una clase la cual se hace referencia a un nodo y al siguiente elemento
 * donde se utilizan diferentes atributos para el funcionamiento de este.
 *@Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez
 * Badilla, Sebastian Alvarez Murillo.
 */
public class NodoPregunta {
    private Pregunta dato;
    private NodoPregunta siguiente;

    public NodoPregunta(Pregunta dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Pregunta getDato() {
        return dato;
    }

    public NodoPregunta getSiguiente() {
        return siguiente;
    }

    public void setDato(Pregunta dato) {
        this.dato = dato;
    }

    public void setSiguiente(NodoPregunta siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
}
