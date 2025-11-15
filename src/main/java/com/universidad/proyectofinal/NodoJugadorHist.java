package com.universidad.proyectofinal;

public class NodoJugadorHist {
    private String nombre;
    private ListaPosiciones historial; // lista simple interna de posiciones
    private NodoJugadorHist siguiente;
    private NodoJugadorHist anterior;

    public NodoJugadorHist(String nombre) {
        this.nombre = nombre;
        this.historial = new ListaPosiciones();
    }

    public String getNombre() { return nombre; }
    public ListaPosiciones getHistorial() { return historial; }
    public NodoJugadorHist getSiguiente() { return siguiente; }
    public NodoJugadorHist getAnterior() { return anterior; }
    public void setSiguiente(NodoJugadorHist s) { this.siguiente = s; }
    public void setAnterior(NodoJugadorHist a) { this.anterior = a; }
}

