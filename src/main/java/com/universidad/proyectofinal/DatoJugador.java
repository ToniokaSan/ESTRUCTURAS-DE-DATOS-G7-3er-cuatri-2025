/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

/**
 * Representa un castigo dentro del juego, con su tipo de operación, número asociado
 * y una descripción detallada. Se utiliza para aplicar penalizaciones o acciones.
 * especiales a los jugadores.
 * Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
public class DatoJugador extends Dato {

    private String nombreJugador;

    /**
     * Constructor de la clase DatoCastigo. Crea un nuevo castigo con su
     * operación, número y descripción.
     *
     * @param nombreJugador Texto descriptivo que explica el castigo.
     */

    public DatoJugador( String nombreJugador) {

        this.nombreJugador = nombreJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    /**
     * Devuelve una representación en texto del castigo, incluyendo su
     * operación, número y descripción.
     *
     * @return Cadena con los datos del castigo.
     */
    @Override
    public String toString() {
        return "Operación: " + nombreJugador ;
    }
}