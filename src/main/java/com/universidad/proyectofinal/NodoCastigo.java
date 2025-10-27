package com.universidad.proyectofinal;

/**
 * Representa la creacion de un nodo para la pila de castigos, que contiene la informacion de la
 * Descripcion, ademas del simbolo del castigo obtenido.
 * Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
public class NodoCastigo {
    private DatoCastigo dato; //informacion del dato castigo en el nodo
    private NodoCastigo siguiente; //puntero al siguiente nodo

    /**
     * Constructor de la clase NodoCastigo
     * Crea un nuevo nodo que almacena la informacion de castigo-
     * @param dato objeto DatoCastigo que contiene la informacion del dato castigo.
     */
    public NodoCastigo(DatoCastigo dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    /**
     * Obtiene el dato de castigo almacenado en el nodo 
     * @return devuelve el dato obtenido 
     */

    public DatoCastigo getDato() {
        return dato;
    }

    /**
     * obtiene la referencia al siguiente nodo
     * @return referencia del siguiente nodo
     */
    public NodoCastigo getSiguiente() {
        return siguiente;
    }
    
    /**
     * Cambia el siguiente nodo 
     * @param siguiente  NodoCastigo que se enlazara con el siguiente
     */
    public void setSiguiente(NodoCastigo siguiente) {
        this.siguiente = siguiente;
    }
}