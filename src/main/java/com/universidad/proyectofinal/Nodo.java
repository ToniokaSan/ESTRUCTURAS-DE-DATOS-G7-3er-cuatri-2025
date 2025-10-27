
package com.universidad.proyectofinal;

/**
 * Representa la creacion del nodo de la estructura enlazada de una pila que
 * almacena la informacion del jugador y usa un puntero hacia el siguiente nodo.
 * Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
public class Nodo {
    private Dato nombreJugador;  // Información del jugador almacenada en este nodo
    private Nodo siguiente; // Referencia al siguiente nodo de la estructura
    
    /**
     * Constructor de la clase Nodo. Crea un nodo que contiene la información de
     * un jugador.
     *
     * @param nombreJugador Objeto Dato que contiene el nombre y la posición del
     * jugador.
     */
    public Nodo(Dato nombreJugador){
        this.nombreJugador = nombreJugador;
    }
    
    /**
     * modifica el dato del jugador que se almaceno en el nodo
     * @param nombreJugador nuevo objeto con la informacion del jugador
     */
    public void setDato(Dato nombreJugador){
        this.nombreJugador = nombreJugador;
    }
    
    /**
     * Establece el nodo siguiente al actual.
     *
     * @param siguiente Nodo que se enlaza como siguiente.
     */
    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
    
    /**
     * Obtiene el dato (jugador) almacenado en el nodo.
     *
     * @return Objeto Dato con la información del jugador.
     */
    public Dato getNombreJugador(){
        return nombreJugador;
    }
    
    /**
     * Obtiene la referencia al siguiente nodo en la estructura.
     *
     * @return Nodo siguiente enlazado.
     */
    public Nodo getSiguiente(){
        return siguiente;
    }
    
}
