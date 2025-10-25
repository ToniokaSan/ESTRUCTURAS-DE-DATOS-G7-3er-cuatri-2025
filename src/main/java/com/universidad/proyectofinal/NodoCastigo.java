package com.universidad.proyectofinal;

/**
 * 
 * 
 */
public class NodoCastigo {
    private DatoCastigo dato;
    private NodoCastigo siguiente;

    public NodoCastigo(DatoCastigo dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public DatoCastigo getDato() {
        return dato;
    }

    public NodoCastigo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCastigo siguiente) {
        this.siguiente = siguiente;
    }
}