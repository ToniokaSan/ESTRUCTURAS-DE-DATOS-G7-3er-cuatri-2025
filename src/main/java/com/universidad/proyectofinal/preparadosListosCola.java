
package com.universidad.proyectofinal;

/**
 * Representa una cola de jugadores preparados para el juego.
 * Permite encolar y desencolar jugadores, así como consultar, eliminar y
 * verificar si la cola está vacía.
 * Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
public class preparadosListosCola {

    private Nodo frente; //referencia al primer nodo de la cola
    private Nodo fin; // el fin de la cola

    /**
     * Constructor de la clase preparadoslistoscola
     * inicializa una nueva cola vacia sin jugadores
     */
    public preparadosListosCola() {
        this.frente = null;
        this.fin = null;
    }

    /**
     * Obtiene el nodo que está al frente de la cola
     * @return Nodo que está al frente
     */
    public Nodo getFrente() {
        return frente;
    }

    /**
     * Obtiene el nodo que esta al final de la cola
     * @return Nodo que está al final de la cola
     */
    public Nodo getFin() {
        return fin;
    }

    /**
     * Establece el nodo que estara al frente de la cola
     * 
     * @param frente Nodo que se asignara como frente 
     */
    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    /**
     * Establece el nodo que estara al final de la cola
     * @param fin Nodo que se asignará como el final
     */
    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    /**
     * Agrega un nuevo jugador a la cola
     * @param nombreJugador Objeto que {@link Dato} que contiene la informacion
     * Del jugador
     */
    public void encolar(Dato nombreJugador) {
        Nodo nuevo = new Nodo(nombreJugador);
        if (frente == null) {
            frente = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
    }

    /**
     * Elimina el jugador que esta al frente de la cola
     * @return objeto Tipo dato con la informacion del jugador
     * @throws Exception Si la cola esta vacia.
     */
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

    /**
     * Obtiene el jugador que está al frente de la cola sin eliminarlo
     * @return La informacion del jugador al frente
     */
    public Dato frente(){
        if (this.getFrente() == null) {
            return null;
        } else {
            return this.frente.getNombreJugador();
        }
    }
    
    /**
     * Verifica si la cola esta vacia
     * @return Devuelve true si no tiene jugadores, false si contiene alguno
     */
    public boolean estaVacia(){
        return frente == null;
    }
    
    
    //aqui se creo un metodo extra para poder eliminar un jugador con la opcion 3 del menu de juego
    /**
     * Elimina el jugador de la cola que se busco por un nombre en especifico
     * @param nombre Nombre del jugador a liminar
     * 
     * @return Devuelve true si lo encontro y elimino al jugador, caso contrario devuelve false
     */
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
    

    /**
     * Devuelve informacion de la cola jugadores, mostrando orden e informacion de cada uno
     * @return cadena de texto con los jugadores en la cola
     */
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
    
