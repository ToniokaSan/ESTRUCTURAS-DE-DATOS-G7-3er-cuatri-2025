package com.universidad.proyectofinal;

/*
 * Árbol binario del Chatbot FAQ
 */
public class ArbolFAQ {

    NodoFAQ raiz;

    public ArbolFAQ() {
        // Raíz precargada obligatoria
        raiz = new NodoFAQ("1", "Preguntas Frecuentes (FAQ)");
    }

    // Insertar un nodo respetando el orden por código
    public void insertarNodo(String codigo, String nombre) {
        raiz = insertarRecursivo(raiz, codigo, nombre);
    }

    private NodoFAQ insertarRecursivo(NodoFAQ actual, String codigo, String nombre) {
        if (actual == null) {
            return new NodoFAQ(codigo, nombre);
        }

        if (codigo.compareTo(actual.codigo) < 0) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, codigo, nombre);
        } else if (codigo.compareTo(actual.codigo) > 0) {
            actual.derecho = insertarRecursivo(actual.derecho, codigo, nombre);
        }

        return actual;
    }

    // Buscar un nodo por código
    public NodoFAQ buscar(String codigo) {
        NodoFAQ aux = raiz;

        while (aux != null) {
            if (codigo.equals(aux.codigo)) {
                return aux;
            } else if (codigo.compareTo(aux.codigo) < 0) {
                aux = aux.izquierdo;
            } else {
                aux = aux.derecho;
            }
        }
        return null;
    }
}

