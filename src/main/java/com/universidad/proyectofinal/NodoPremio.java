package com.universidad.proyectofinal;

/**
 * Representa la creacion de un nuevo nodo para la pila de premios que contiene la informacion del premio
 * ademas del puntero, en este caso el (abajo)
 *  Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
public class NodoPremio {
    private DatoPremio dato; //informacion del dato del premio
    private NodoPremio abajo; //puntero hacia el siguiente nodo

    /**
     * Constructor de la clase NodoPremio 
     * Crea un nuevo nodo con la informacion del premio y pu
     * @param dato objeto de DatoPremio que contiene el premio obtenido por el jugador
     */
    public NodoPremio(DatoPremio dato) {
        this.dato = dato;
        this.abajo = null;
    }

    /**
     * Obtiene el dato obtenido del nodo
     * @return devuelve el dato obtenido
     */
    public DatoPremio getDato() {
        return dato;
    }

    /**
     * obtiene la informacion del puntero hacia el siguiente nodo
     * @return puntero hacia el siguiente nodo
     */
    public NodoPremio getAbajo() {
        return abajo;
    }

    /**
     * Cambia la informacion del puntero hacia el siguiente nodo
     * @param abajo parte del Nodo que sera cambiado
     */
    public void setAbajo(NodoPremio abajo) {
        this.abajo = abajo;
    }
    
}