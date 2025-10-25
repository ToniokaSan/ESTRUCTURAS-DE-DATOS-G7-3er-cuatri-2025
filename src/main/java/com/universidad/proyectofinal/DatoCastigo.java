/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

/**
 * Contiene los datos específicos de un Castigo.
 * @author celor
 */
public class DatoCastigo {
    private char operacion;
    private int numero;
    private String descripcion;

    public DatoCastigo(char operacion, int numero, String descripcion) {
        this.operacion = operacion;
        this.numero = numero;
        this.descripcion = descripcion;
    }

    public char getOperacion() {
        return operacion;
    }

    public int getNumero() {
        return numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setOperacion(char operacion) {
        this.operacion = operacion;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Operación: " + operacion + ", Número: " + numero + " (" + descripcion + ")";
    }
}