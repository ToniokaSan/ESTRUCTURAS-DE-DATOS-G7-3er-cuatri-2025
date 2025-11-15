package com.universidad.proyectofinal;

import java.util.Date;

public class NodoPosicion {
    private int posicion;
    private Date timestamp;
    private String premioCastigo; // descripción o "Posición <<##>> no tiene castigos/premios"
    private NodoPosicion siguiente;

    public NodoPosicion(int posicion, Date timestamp, String premioCastigo) {
        this.posicion = posicion;
        this.timestamp = timestamp;
        this.premioCastigo = premioCastigo;
    }

    public int getPosicion() { return posicion; }
    public Date getTimestamp() { return timestamp; }
    public String getPremioCastigo() { return premioCastigo; }
    public NodoPosicion getSiguiente() { return siguiente; }
    public void setSiguiente(NodoPosicion s) { this.siguiente = s; }
}

