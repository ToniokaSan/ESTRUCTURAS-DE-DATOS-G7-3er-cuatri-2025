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
public class DatoCastigo {
    private char operacion;
    private int numero;
    private String descripcion;
    
    /**
     * Constructor de la clase DatoCastigo. Crea un nuevo castigo con su
     * operación, número y descripción.
     *
     * @param operacion Tipo de operación del castigo (por ejemplo, '+' o '-').
     * @param numero Valor numérico del castigo.
     * @param descripcion Texto descriptivo que explica el castigo.
     */
    
    public DatoCastigo(char operacion, int numero, String descripcion) {
        this.operacion = operacion;
        this.numero = numero;
        this.descripcion = descripcion;
    }

    
    /**
     * Obtiene el tipo de operación del castigo.
     * @return El carácter que representa la operación.
     */
    public char getOperacion() {
        return operacion;
    }

    /**
     * Obtiene el valor numérico del castigo.
     *
     * @return El número del castigo.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Obtiene la descripción del castigo.
     *
     * @return Texto descriptivo del castigo.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Modifica el tipo de operación del castigo.
     *
     * @param operacion Nuevo carácter de operación.
     */
    public void setOperacion(char operacion) {
        this.operacion = operacion;
    }

    /**
     * Modifica el valor numérico del castigo.
     *
     * @param numero Nuevo valor del castigo.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Modifica la descripción del castigo.
     *
     * @param descripcion Nueva descripción del castigo.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve una representación en texto del castigo, incluyendo su
     * operación, número y descripción.
     *
     * @return Cadena con los datos del castigo.
     */
    @Override
    public String toString() {
        return "Operación: " + operacion + ", Número: " + numero + " (" + descripcion + ")";
    }
}