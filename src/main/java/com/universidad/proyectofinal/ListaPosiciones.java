package com.universidad.proyectofinal;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Lista simple que mantiene posiciones históricas de un jugador.
 * Se inserta en orden: posiciones de menor a mayor; si la posición ya existe,
 * se inserta por timestamp dentro de esa posición (orden cronológico ascendente).
 */
public class ListaPosiciones {
    private NodoPosicion primero;

    public NodoPosicion getPrimero() {
        return primero;
    }

    
    public ListaPosiciones() {}

    public boolean estaVacia() { return primero == null; }

    // Agrega una entrada según las reglas: por posición ascendente; si igual posición, orden por timestamp ascendente
    public void agregar(int posicion, Date ts, String premioCastigo) {
        NodoPosicion nuevo = new NodoPosicion(posicion, ts, premioCastigo);
        if (estaVacia()) {
            primero = nuevo;
            return;
        }

        // Si debe ir al inicio
        if (posicion < primero.getPosicion() || (posicion == primero.getPosicion() && ts.before(primero.getTimestamp()))) {
            nuevo.setSiguiente(primero);
            primero = nuevo;
            return;
        }

        NodoPosicion anterior = null;
        NodoPosicion actual = primero;
        while (actual != null) {
            // Si nuevo tiene posición menor a la actual -> insertar antes de actual
            if (posicion < actual.getPosicion()) {
                break;
            }
            // Si misma posición, y timestamp anterior al actual -> insertar antes de actual
            if (posicion == actual.getPosicion() && ts.before(actual.getTimestamp())) {
                break;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }

        // insertar entre anterior y actual (manejar anterior == null por seguridad)
        if (anterior == null) {
            // inserta al inicio
            nuevo.setSiguiente(actual);
            primero = nuevo;
        } else {
            anterior.setSiguiente(nuevo);
            nuevo.setSiguiente(actual);
        }
    }

    // Helper para mostrar -- devuelve todas las entradas como texto (formatea timestamp)
    @Override
    public String toString() {
        if (estaVacia()) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        NodoPosicion aux = primero;
        while (aux != null) {
            String ts = aux.getTimestamp() != null ? sdf.format(aux.getTimestamp()) : "(sin timestamp)";
            sb.append("Pos: ").append(aux.getPosicion())
              .append(" - ").append(ts)
              .append(" - ").append(aux.getPremioCastigo())
              .append("\n");
            aux = aux.getSiguiente();
        }
        return sb.toString();
    }
}
