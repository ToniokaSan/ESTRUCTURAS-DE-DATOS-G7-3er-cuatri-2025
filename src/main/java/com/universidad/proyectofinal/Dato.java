package com.universidad.proyectofinal;

/**
 *
 * 
 */
public class Dato { // es lo de los jugadores, se ocupa la posicion porque mas adelante se necesita en el juego
    private String valor;
    private int posicion;
    public Dato(String nombreJugador){
        this.valor = nombreJugador;
        this.posicion = 0;
    }
    
    public void setValor(String valor){
        this.valor = valor;
    }
    
    public String getValor(){
        return valor;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
         return valor + " - Posición: " + posicion;
    }
    
}
