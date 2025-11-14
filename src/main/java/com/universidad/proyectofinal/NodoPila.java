package com.universidad.proyectofinal;

public class NodoPila {
    private Dato dato;   //Primera mitad del nodo. Parte izquierda.
    private NodoPila abajo;  // Referencia al sgte Nodo (Similar a punteros).

    public NodoPila(Dato Dato) {
    }

    public void NodoPila() {
    }

    public void NodoPila(Dato dato) {
        this.dato = dato;
    }

    public Dato getDato() {
        return dato;
    }

    public NodoPila getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoPila abajo) {
        this.abajo = abajo;
    }

    public void setDato(Dato dato) {
        this.dato = dato;
    }
}
