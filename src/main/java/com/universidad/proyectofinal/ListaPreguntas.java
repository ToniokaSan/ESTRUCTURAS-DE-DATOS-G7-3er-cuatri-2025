package com.universidad.proyectofinal;

/*
 * Lista enlazada simple para manejar preguntas
 */
public class ListaPreguntas {

    private Pregunta primero;

    public ListaPreguntas() {
        primero = null;
    }

    // Insertar una pregunta al final de la lista
    public void insertar(String codigo, String pregunta, String respuesta) {
        Pregunta nueva = new Pregunta(codigo, pregunta, respuesta);

        if (primero == null) {
            primero = nueva;
        } else {
            Pregunta aux = primero;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nueva;
        }
    }

    public Pregunta getPrimero() {
        return primero;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    // Eliminar una pregunta por código
    public boolean eliminar(String codigo) {
        if (primero == null) return false;

        if (primero.codigo.equals(codigo)) {
            primero = primero.siguiente;
            return true;
        }

        Pregunta aux = primero;
        while (aux.siguiente != null) {
            if (aux.siguiente.codigo.equals(codigo)) {
                aux.siguiente = aux.siguiente.siguiente;
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }
}

