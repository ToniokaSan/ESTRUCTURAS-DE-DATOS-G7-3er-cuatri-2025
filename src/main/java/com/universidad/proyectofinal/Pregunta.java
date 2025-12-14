package com.universidad.proyectofinal;

/*
 * Nodo de la lista enlazada de preguntas
 */
public class Pregunta {
    private String pregunta;
    private String texto;
    private String respuesta;

    public Pregunta(String pregunta, String texto, String respuesta) {
        this.pregunta = pregunta;
        this.texto = texto;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getTexto() {
        return texto;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    
}

