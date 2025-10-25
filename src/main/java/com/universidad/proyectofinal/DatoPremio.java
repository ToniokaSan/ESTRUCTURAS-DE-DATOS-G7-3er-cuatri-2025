package com.universidad.proyectofinal;

/**
 *
 *
 */
public class DatoPremio {
    private char operacion;
    private int numero;
    private String descripcion;

    public DatoPremio(char operacion, int numero, String descripcion) {
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