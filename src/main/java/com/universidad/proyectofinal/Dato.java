package com.universidad.proyectofinal;

/**
 * Representa un jugador en el juego, almacenando su nombre y su posición actual.
 * Esta clase se utiliza para manejar la información de cada jugador durante el juego.
 * Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 * 
 */
public class Dato { // es lo de los jugadores, se ocupa la posicion porque mas adelante se necesita en el juego
    private String valor;
    private int posicion;
    
    /**
     * Constructor de la clase Dato. Inicializa un jugador con su nombre y la
     * posición inicial en 0.
     *
     * @param nombreJugador Nombre del jugador a crear.
     */
    
    public Dato(String nombreJugador){
        this.valor = nombreJugador;
        this.posicion = 0; //para que el jugador inicie en 0
    }
    
    
    /**
     * modifica el nombre del jugador
     * @param valor el nombre del jugador
     */
    public void setValor(String valor){
        this.valor = valor;
    }
    
    /**
     * obtiene el nombre del jugador 
     * @return el nombre del jugador
     */
    public String getValor(){
        return valor;
    }

    /**
     * obtiene la posicion del jugador
     * @return la posicion del jugador
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * modifica la posicion
     * @param posicion nueva del jugador
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    
    
    /**
     * Devuelve una representación en cadena del jugador, incluyendo su nombre y
     * posición.
     *
     * @return Cadena con el nombre y posición del jugador.
     */
    
    
    @Override
    public String toString() {
         return valor + " - Posición: " + posicion;
    }
    
}
