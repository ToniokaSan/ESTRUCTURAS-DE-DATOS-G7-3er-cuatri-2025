package com.universidad.proyectofinal;

/*
 * Nodo del árbol binario del Chatbot
 * Cada nodo representa una categoría de preguntas
 */
public class NodoFAQ {

    String codigo;      // Código del nodo (Ej: 1111)
    String nombre;      // Nombre descriptivo
    NodoFAQ izquierdo; // Hijo izquierdo
    NodoFAQ derecho;   // Hijo derecho
    ListaPreguntas preguntas; // Lista de preguntas (solo si es hoja)

    // Constructor
    public NodoFAQ(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
        this.preguntas = null;
    }

    // Método que indica si el nodo es hoja
    public boolean esHoja() {
        return izquierdo == null && derecho == null;
    }
}

