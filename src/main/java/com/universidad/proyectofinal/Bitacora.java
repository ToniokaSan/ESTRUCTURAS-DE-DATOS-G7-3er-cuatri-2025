/**
 * Clase que permite crear una bitacora para el funcionamiento del proyecto MVP 
 * Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
package com.universidad.proyectofinal;

public class Bitacora {
    private NodoBitacora primero;
    private NodoBitacora ultimo;

    /**
     * Constructor vacio
     */
    public Bitacora() {
    }

    /**
     * Metodo para verificar si la bitacora se encuentra vacia
     * @return booleano que indica si esta vacia o contiene algun elemento
     */
    public boolean estaVacia() {
        return primero == null;
    }

    
    /**
     * Metodo agregar permite agregar un nuevo nodo de bitacora en el que se establece el primero
     * y ultimo elemento
     * @param mensaje 
     */
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

    /**
     * Metodo que establece en nulas las entradas ya hechas.
     */
    public void limpiar() {
        primero = null;
        ultimo = null;
    }

    
    /**
     * Devuelve las entradas concatenadas con saltos de linea.
     * @return 
     */
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
