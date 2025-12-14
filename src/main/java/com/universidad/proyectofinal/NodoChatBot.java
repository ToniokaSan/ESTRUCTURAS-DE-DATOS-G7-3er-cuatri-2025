/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

/**
 *
 * @author potoy
 */
public class NodoChatBot {
    private String codigo;
    private String nombre;

    private NodoChatBot izquierdo;
    private NodoChatBot derecho;
    private ListaPreguntas preguntas; //  si es hoja
    
    private NodoChatBot padre;

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public NodoChatBot getIzquierdo() {
        return izquierdo;
    }

    public NodoChatBot getDerecho() {
        return derecho;
    }

    public ListaPreguntas getPreguntas() {
        return preguntas;
    }

    public NodoChatBot getPadre() {
        return padre;
    }
    

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIzquierdo(NodoChatBot izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoChatBot derecho) {
        this.derecho = derecho;
    }

    public void setPreguntas(ListaPreguntas preguntas) {
        this.preguntas = preguntas;
    }

    public void setPadre(NodoChatBot padre) {
        this.padre = padre;
    }
    
    
    public NodoChatBot(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
        this.preguntas = null;
    }
}
