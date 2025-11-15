/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

/**
 *
 * @author EQUIPO
 */
public class NodoCircular {
    private int dato;
    private NodoCircular siguiente;

    public NodoCircular(int dato) {
        this.dato = dato;
    }
    
    

    public int getDato() {
        return dato;
    }

    public NodoCircular getSiguiente() {
        return siguiente;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setSiguiente(NodoCircular siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
