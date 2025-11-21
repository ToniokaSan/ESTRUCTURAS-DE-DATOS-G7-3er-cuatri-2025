package com.universidad.proyectofinal;

/**
 * Clase que permite moldear el nodo tipo posicion, con atributos de posicion, atributo de fecha y hora
 * ademas de la informacion de premios y castigos.
 * Autores: Anthony Potoy Alemán,Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
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

