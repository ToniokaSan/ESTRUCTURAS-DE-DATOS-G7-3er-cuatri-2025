
package com.universidad.proyectofinal;

/**
 *
 * @author
 */
public class preparadosListosCola {

    private Nodo frente;
    private Nodo fin;

    public preparadosListosCola() {
        this.frente = null;
        this.fin = null;
    }

    public Nodo getFrente() {
        return frente;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public void encolar(Dato nombreJugador) {
        Nodo nuevo = new Nodo(nombreJugador);
        if (frente == null) {
            frente = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
    }

    public Dato desencolar() throws Exception {

        if (frente == null ){
            throw new Exception("No hay jugadores, no se puede desencolar");

        } else {
            Dato temp = frente.getNombreJugador();
            frente = frente.getSiguiente();

            if (frente == null) {
                fin = null;
            }
            return temp;
        }
    }

    public Dato frente(){
        if (this.getFrente() == null) {
            return null;
        } else {
            return this.frente.getNombreJugador();
        }
    }
    public boolean estaVacia(){
        return frente == null;
    }
    

    @Override
    public String toString() {
        if (estaVacia()) {
            return "No hay jugadores en la cola.";
        } else {
            StringBuilder sb = new StringBuilder("--- Lista de Jugadores ---\n");
            Nodo actual = frente;
            int contador = 1;
            while (actual != null) {
                // Usamos el toString() de Dato para mostrar nombre y posición
                sb.append(contador).append(". ").append(actual.getNombreJugador().toString()).append("\n");
                actual = actual.getSiguiente();
                contador++;
            }
            return sb.toString();
        }
    }
}
    
