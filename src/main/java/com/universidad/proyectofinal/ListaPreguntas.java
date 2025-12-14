/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

/**
 *
 * @author potoy
 */
public class ListaPreguntas {
    private NodoPregunta cabeza;

    public ListaPreguntas() {
        cabeza = null;
    }

    public NodoPregunta getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoPregunta cabeza) {
        this.cabeza = cabeza;
    }
    public void insertar(Pregunta p) {
        NodoPregunta nuevo = new NodoPregunta(p);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoPregunta aux = cabeza;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }
    
}
