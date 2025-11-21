/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

/**
 * Clase que permite moldear el nodo doble para ejectutar una lista de tipo doble.
 * Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna
 * Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
public class NodoDoble {
    private NodoDoble anterior;
    private int dato;
    private NodoDoble siguiente;

    public NodoDoble() {
    }

    public NodoDoble(int dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public int getDato() {
        return dato;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
