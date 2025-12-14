/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

/**
 *
 * @author potoy
 */
public class ArbolChatBot {
    private NodoChatBot raiz;

    public NodoChatBot getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoChatBot raiz) {
        this.raiz = raiz;
    }

    public ArbolChatBot() {
        raiz = new NodoChatBot ("1","Preguntas Frecuentes (FAQ)");
    }
    // -----------------------
    // MÉTODOS DE BÚSQUEDA
    // -----------------------

    public NodoChatBot buscarNodo(String codigo) {
        return buscarRecursivo(raiz, codigo);
    }

    private NodoChatBot buscarRecursivo(NodoChatBot actual, String codigo) {
        if (actual == null) {
            return null;
        }
        if (actual.getCodigo().equals(codigo)) {
            return actual;
        }
        NodoChatBot izq = buscarRecursivo(actual.getIzquierdo(), codigo);
        if (izq != null) {
            return izq;
        }
        return buscarRecursivo(actual.getDerecho(), codigo);
    }

    // -----------------------
    // MÉTODOS DE AGREGADO
    // -----------------------
    public boolean agregarNodo(String codigoPadre, String nombreHijo) {
        NodoChatBot padre = buscarNodo(codigoPadre);
        if (padre == null) {
            return false;
        }

        String codigoHijo;
        if (padre.getIzquierdo() == null) {
            codigoHijo = codigoPadre + "-1";
            NodoChatBot hijo = new NodoChatBot(codigoHijo, nombreHijo);
            hijo.setPadre(padre);
            padre.setIzquierdo(hijo);
        } else if (padre.getDerecho() == null) {
            codigoHijo = codigoPadre + "-2";
            NodoChatBot hijo = new NodoChatBot(codigoHijo, nombreHijo);
            hijo.setPadre(padre);
            padre.setDerecho(hijo);
        } else {
            return false; // ya tiene dos hijos
        }
        return true;
    }

    public boolean agregarPregunta(String codigoHoja, Pregunta pregunta) {
        NodoChatBot nodo = buscarNodo(codigoHoja);
        if (nodo == null) {
            return false;
        }
        if (nodo.getIzquierdo() != null || nodo.getDerecho() != null) {
            return false; // solo hojas
        }
        if (nodo.getPreguntas() == null) {
            nodo.setPreguntas(new ListaPreguntas());
        }
        nodo.getPreguntas().insertar(pregunta); // usamos tu método "insertar"
        return true;
    }
    
    /*
    public void insertar(String codigo, String nombre){
        raiz = insertarRec(raiz, codigo, nombre);
    }
    public NodoChatBot insertarRec(NodoChatBot actual, String codigo, String nombre){
        if (actual == null) {
            return new NodoChatBot(codigo, nombre);
        }

        if (codigo.compareTo(actual.getCodigo()) < 0) {
            actual.setIzquierdo(
                    insertarRec(actual.getIzquierdo(), codigo, nombre));
        } else if (codigo.compareTo(actual.getCodigo()) > 0) {
            actual.setDerecho(
                    insertarRec(actual.getDerecho(), codigo, nombre));
        }

        return actual;
    }
    public NodoChatBot buscar(String codigo) {
        NodoChatBot aux = raiz;

        while (aux != null) {
            if (codigo.equals(aux.getCodigo())) {
                return aux;
            } else if (codigo.compareTo(aux.getCodigo()) < 0) {
                aux = aux.getIzquierdo();
            } else {
                aux = aux.getDerecho();
            }
        }
        return null;
    }
    */
}
