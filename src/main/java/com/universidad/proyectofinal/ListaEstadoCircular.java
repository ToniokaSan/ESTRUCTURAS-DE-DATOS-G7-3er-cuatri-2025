package com.universidad.proyectofinal;

/**
 * Lista circular simple que representa las posiciones actuales del juego (1..N).
 * Cada nodo mantiene la posición y el nombre del jugador que esté en ella (o null si vacía).
 */
public class ListaEstadoCircular {
    private NodoEstadoPosicion primero;
    private NodoEstadoPosicion ultimo;
    private int tamanio;

    public ListaEstadoCircular() {}

    // inicializa posiciones del 1 a N
    public void inicializar(int n) {
        if (n <= 0) return;
        primero = new NodoEstadoPosicion(1);
        NodoEstadoPosicion actual = primero;
        for (int i = 2; i <= n; i++) {
            NodoEstadoPosicion sig = new NodoEstadoPosicion(i);
            actual.setSiguiente(sig);
            actual = sig;
        }
        actual.setSiguiente(primero);
        ultimo = actual;
        tamanio = n;
    }

    public int getTamanio() { return tamanio; }

    // obtener nodo por posicion (1..N)
    public NodoEstadoPosicion obtenerPorPosicion(int pos) {
        if (primero == null || pos < 1 || pos > tamanio) return null;
        NodoEstadoPosicion actual = primero;
        for (int i = 1; i < pos; i++) actual = actual.getSiguiente();
        return actual;
    }

    // ubicar jugador en una posicion (sobrescribe el nombre que pueda haber)
    public void colocarJugadorEnPosicion(int pos, String nombre) {
        NodoEstadoPosicion nodo = obtenerPorPosicion(pos);
        if (nodo != null) nodo.setNombreJugador(nombre);
    }

    // limpiar una posicion
    public void limpiarPosicion(int pos) {
        colocarJugadorEnPosicion(pos, null);
    }

    // actualiza la posicion de un jugador: elimina cualquier aparición previa y coloca en pos (ajustada a 1..N)
    public void actualizarPosicion(String nombre, int pos) {
        if (primero == null || nombre == null) return;
        // limpiar apariciones previas
        NodoEstadoPosicion actual = primero;
        do {
            if (actual.getNombreJugador() != null && actual.getNombreJugador().equalsIgnoreCase(nombre)) {
                actual.setNombreJugador(null);
            }
            actual = actual.getSiguiente();
        } while (actual != primero);

        // ajustar pos
        if (pos < 1) pos = 1;
        if (pos > tamanio) pos = tamanio;
        NodoEstadoPosicion destino = obtenerPorPosicion(pos);
        if (destino != null) destino.setNombreJugador(nombre);
    }

    @Override
    public String toString() {
        if (primero == null) return "Lista de posiciones vacía.";
        StringBuilder sb = new StringBuilder("--- Estado Actual del Juego ---\n");
        NodoEstadoPosicion actual = primero;
        do {
            sb.append("Pos ").append(actual.getPosicion()).append(" : ")
              .append(actual.getNombreJugador() == null ? "(vacía)" : actual.getNombreJugador())
              .append("\n");
            actual = actual.getSiguiente();
        } while (actual != primero);
        return sb.toString();
    }
}
