package com.universidad.proyectofinal;

public class NodoEstadoPosicion {
    private int posicion;
    private String nombreJugador; // null cuando está vacía
    private NodoEstadoPosicion siguiente;

    public NodoEstadoPosicion(int posicion) { this.posicion = posicion; }
    public int getPosicion() { return posicion; }
    public String getNombreJugador() { return nombreJugador; }
    public void setNombreJugador(String nombre) { this.nombreJugador = nombre; }
    public NodoEstadoPosicion getSiguiente() { return siguiente; }
    public void setSiguiente(NodoEstadoPosicion s) { this.siguiente = s; }
}

