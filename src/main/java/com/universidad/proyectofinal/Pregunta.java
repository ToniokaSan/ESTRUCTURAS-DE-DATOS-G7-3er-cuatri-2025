package com.universidad.proyectofinal;

/*
 * Nodo de la lista enlazada de preguntas
 */
public class Pregunta {

    String codigo;       // Código de la pregunta
    String pregunta;     // Texto de la pregunta
    String respuesta;    // Respuesta
    Pregunta siguiente;  // Enlace al siguiente nodo

    public Pregunta(String codigo, String pregunta, String respuesta) {
        this.codigo = codigo;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.siguiente = null;
    }
}

