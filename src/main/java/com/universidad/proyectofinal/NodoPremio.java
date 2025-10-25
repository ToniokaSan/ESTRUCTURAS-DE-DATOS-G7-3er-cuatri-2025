package com.universidad.proyectofinal;

/**
 *
 * 
 */
public class NodoPremio {
    private DatoPremio dato;
    private NodoPremio abajo;

    public NodoPremio(DatoPremio dato) {
        this.dato = dato;
        this.abajo = null;
    }

    public DatoPremio getDato() {
        return dato;
    }

    public NodoPremio getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoPremio abajo) {
        this.abajo = abajo;
    }
}