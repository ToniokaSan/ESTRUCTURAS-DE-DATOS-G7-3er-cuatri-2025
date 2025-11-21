package com.universidad.proyectofinal;

import java.util.Date;

/**
 * Lista doble-circular de jugadores ordenada alfabéticamente por nombre.
 * Cada nodo contiene una lista interna `ListaPosiciones` con el historial.
 */
public class ListaJugadoresBitacora {
    private NodoJugadorHist primero;
    private NodoJugadorHist ultimo;

    public NodoJugadorHist getPrimero() {
        return primero;
    }

    public NodoJugadorHist getUltimo() {
        return ultimo;
    }

    
    public ListaJugadoresBitacora() {}

    public boolean estaVacia() { return primero == null; }

    // Inserta ordenadamente por nombre (alfabético). Si ya existe, devuelve el nodo existente.
    public NodoJugadorHist insertarOObtener(String nombre) {
        NodoJugadorHist nuevo = new NodoJugadorHist(nombre);
        if (estaVacia()) {
            primero = nuevo;
            ultimo = nuevo;
            primero.setSiguiente(primero);
            primero.setAnterior(ultimo);
            return nuevo;
        }
        // si ya existe y es igual al primero
        if (nombre.compareToIgnoreCase(primero.getNombre()) < 0) {
            // Insertar antes del primero
            nuevo.setSiguiente(primero);
            nuevo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevo);
            primero.setAnterior(nuevo);
            primero = nuevo;
            return nuevo;
        }
        // Recorrer para encontrar inserción o coincidencia
        NodoJugadorHist actual = primero;
        do {
            int cmp = nombre.compareToIgnoreCase(actual.getNombre());
            if (cmp == 0) {
                return actual; // ya existe
            }
            if (cmp < 0) {
                // insertar antes de actual
                NodoJugadorHist prev = actual.getAnterior();
                prev.setSiguiente(nuevo);
                nuevo.setAnterior(prev);
                nuevo.setSiguiente(actual);
                actual.setAnterior(nuevo);
                return nuevo;
            }
            actual = actual.getSiguiente();
        } while (actual != primero);

        // si llegamos aquí insertar al final
        ultimo.setSiguiente(nuevo);
        nuevo.setAnterior(ultimo);
        nuevo.setSiguiente(primero);
        primero.setAnterior(nuevo);
        ultimo = nuevo;
        return nuevo;
    }

    // Busca por nombre (case-insensitive)
    public NodoJugadorHist buscar(String nombre) {
        if (estaVacia()) return null;
        NodoJugadorHist actual = primero;
        do {
            if (actual.getNombre().equalsIgnoreCase(nombre)) return actual;
            actual = actual.getSiguiente();
        } while (actual != primero);
        return null;
    }

    @Override
    public String toString() {
        if (estaVacia()) return "No hay jugadores en la bitácora.";
        StringBuilder sb = new StringBuilder("--- Bitácora de Jugadores ---\n");
        NodoJugadorHist actual = primero;
        do {
            sb.append("Jugador: ").append(actual.getNombre()).append("\n");
            sb.append(actual.getHistorial().toString()).append("\n");
            actual = actual.getSiguiente();
        } while (actual != primero);
        return sb.toString();
    }
}

