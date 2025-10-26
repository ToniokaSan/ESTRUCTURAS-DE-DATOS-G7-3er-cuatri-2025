
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
    //aqui se creo un metodo extra para poder eliminar un jugador con la opcion 3 del menu de juego
    public boolean eliminarJugador(String nombre) {
        if (estaVacia()) {
            return false;
        }

        Nodo actual = frente;
        Nodo anterior = null;
        //aqui recorremos la cola 
        while (actual != null) {
            //en esta parte comparamos el nombre del jugador que ingreso el usuario en el menu de juego
            //si lo encontramos entonces busca en que posicion esta para eliminarlo
            if (actual.getNombreJugador().getValor().equalsIgnoreCase(nombre)) {
                if (anterior == null) {
                    // en esta el jugador está al frente
                    frente = actual.getSiguiente();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }

                // en esta el jugador esta al final
                if (actual == fin) {
                    fin = anterior;
                }

                return true; 
            }

            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false; //esta opcion funciona por si no se encontro al jugador
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
    
