package com.universidad.proyectofinal;

public class Bitacora {
    private NodoBitacora primero;
    private NodoBitacora ultimo;

    public Bitacora() {
    }

    public boolean estaVacia() {
        return primero == null;
    }

    // Agrega una entrada al final de la bitácora
    public void agregar(String mensaje) {
        NodoBitacora nodo = new NodoBitacora(mensaje);
        if (estaVacia()) {
            primero = nodo;
            ultimo = nodo;
        } else {
            ultimo.setSiguiente(nodo);
            ultimo = nodo;
        }
    }

    // Borra todas las entradas
    public void limpiar() {
        primero = null;
        ultimo = null;
    }

    // Devuelve todas las entradas concatenadas con saltos de línea
    @Override
    public String toString() {
        if (estaVacia()) return "";
        StringBuilder sb = new StringBuilder();
        NodoBitacora aux = primero;
        while (aux != null) {
            sb.append(aux.getMensaje()).append("\n");
            aux = aux.getSiguiente();
        }
        return sb.toString();
    }
}
