
package com.universidad.proyectofinal;

/**
 *
 * 
 */
public class Nodo {
    private Dato nombreJugador;
    private Nodo siguiente;
    
    public Nodo(Dato nombreJugador){
        this.nombreJugador = nombreJugador;
    }
    
    public void setDato(Dato nombreJugador){
        this.nombreJugador = nombreJugador;
    }
    
    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
    
    public Dato getNombreJugador(){
        return nombreJugador;
    }
    
    public Nodo getSiguiente(){
        return siguiente;
    }
    
}
