/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

/**
 *Clase chat arbol, tiene como proposito crear el arbol binario para la implementacion del chatbot
 * @Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez
 * Badilla, Sebastian Alvarez Murillo.
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
    
    /*
    Metodo buscar nodo que tiene un metodo recursivo para buscar los nodos dentro del arbol.
    @return buscarNodoRec
    */
    public NodoChatBot buscarNodo(String codigo) {
        return buscarNodoRec(raiz, codigo);
    }
    
    /*
    Metodo recursivo que recibe como parametros un nodo actual y un codigo para buscar similitudes.
    @return buscarNodoRec
    */
    private NodoChatBot buscarNodoRec(NodoChatBot actual, String codigo) {
        if (actual == null) {
            return null;
        }
        if (actual.getCodigo().equals(codigo)) {
            return actual;
        }

        NodoChatBot izq = buscarNodoRec(actual.getIzquierdo(), codigo);
        if (izq != null) {
            return izq;
        }

        return buscarNodoRec(actual.getDerecho(), codigo);
    }
    
    /**
     * Metodo agregar Nodo permite agregar un nuevo nodo al arbol binario.
     * @param codigoPadre
     * @param nombreNodo
     * @return 
     */
    public boolean agregarNodo(String codigoPadre, String nombreNodo) {
        NodoChatBot padre = buscarNodo(codigoPadre);
        if (padre == null) {
            return false;
        }

        String codigoNuevo;
        if (padre.getIzquierdo() == null) {
            codigoNuevo = codigoPadre + "1";
            NodoChatBot nuevo = new NodoChatBot(codigoNuevo, nombreNodo);
            nuevo.setPadre(padre);
            padre.setIzquierdo(nuevo);
            return true;
        } else if (padre.getDerecho() == null) {
            codigoNuevo = codigoPadre + "2";
            NodoChatBot nuevo = new NodoChatBot(codigoNuevo, nombreNodo);
            nuevo.setPadre(padre);
            padre.setDerecho(nuevo);
            return true;
        } else {
            return false; // ambos hijos ocupados
        }
    }
    /**
     * Metodo agregar pregunta permite agregar pregunta dentro de los nodos en el arbol binario
     * @param codigoNodo
     * @param p
     * @return 
     */

    public boolean agregarPregunta(String codigoNodo, Pregunta p) {
        NodoChatBot nodo = buscarNodo(codigoNodo);
        if (nodo == null) {
            return false;
        }
        if (nodo.getIzquierdo() != null || nodo.getDerecho() != null) {
            return false; // solo hojas
        }
        // Inicializa la lista si es nula
        if (nodo.getPreguntas() == null) {
            nodo.setPreguntas(new ListaPreguntas());
        }

        nodo.getPreguntas().agregarPregunta(p);
        return true;
    }

   /**
    * Metodo void que permite imprimir datos del arbol utilizando un metodo recursivo.
    */

    public void imprimirArbol() {
        imprimirNodo(raiz, "");
    }

    /**
     * Metodo imprimir nodo que utiliza un metodo recursivo para imprimir un los nodos dentro del arbol.
     * @param nodo
     * @param prefijo 
     */
    private void imprimirNodo(NodoChatBot nodo, String prefijo) {
        if (nodo != null) {
            System.out.println(prefijo + nodo.getCodigo() + " - " + nodo.getNombre());
            imprimirNodo(nodo.getIzquierdo(), prefijo + "  ");
            imprimirNodo(nodo.getDerecho(), prefijo + "  ");
        }
    }
    //metodos solicitados
    
    /**
     * Metodo booleano que permite modificar nodo, retorna true si lo encuentra y false si no existe.
     * @param codigoNodo
     * @param nuevoNombre
     * @return 
     */

    public boolean modificarNodo(String codigoNodo, String nuevoNombre) {
        NodoChatBot nodo = buscarNodo(codigoNodo);
        if (nodo != null) {
            nodo.setNombre(nuevoNombre);
            return true;
        }
        return false;
    }

    /**
     * Metodo eliminar nodo que permite eliminar el nodo que se ha buscado.
     * @param codigoNodo
     * @return 
     */
    public boolean eliminarNodo(String codigoNodo) {
        NodoChatBot nodo = buscarNodo(codigoNodo);
        if (nodo == null) {
            return false;
        }

        // No se puede eliminar si tiene hijos
        if (nodo.getIzquierdo() != null || nodo.getDerecho() != null) {
            return false;
        }

        NodoChatBot padre = nodo.getPadre();
        if (padre == null) {
            return false; // no se elimina la raíz
        }
        if (padre.getIzquierdo() == nodo) {
            padre.setIzquierdo(null);
        } else if (padre.getDerecho() == nodo) {
            padre.setDerecho(null);
        }

        return true;
    }
    
    /**
     * Metodo modificar pregunta que recibe como parametros el codigo, pregunta y nueva pregunta para modificar una
     * pregunta existente dentro del arbol.
     * @param codigoNodo
     * @param textoPregunta
     * @param nuevaPregunta
     * @param nuevaRespuesta
     * @return 
     */
    public boolean modificarPregunta(String codigoNodo, String textoPregunta, String nuevaPregunta, String nuevaRespuesta) {
        NodoChatBot nodo = buscarNodo(codigoNodo);
        if (nodo == null || nodo.getPreguntas() == null) {
            return false;
        }

        NodoPregunta actual = nodo.getPreguntas().getCabeza();
        while (actual != null) {
            if (actual.getDato().getPregunta().equalsIgnoreCase(textoPregunta)) {
                actual.getDato().setPregunta(nuevaPregunta);
                actual.getDato().setRespuesta(nuevaRespuesta);
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    /**
     * Metodo eliminar pregunta permite eliminar una pregunta dentro del arbol.
     * @param codigoNodo
     * @param textoPregunta
     * @return 
     */
    public boolean eliminarPregunta(String codigoNodo, String textoPregunta) {
        NodoChatBot nodo = buscarNodo(codigoNodo);
        if (nodo == null || nodo.getPreguntas() == null) {
            return false;
        }

        return nodo.getPreguntas().eliminarPregunta(textoPregunta);
    }

    /**
     * Metodo imprimir preguntas permite imprimir preguntas dentro del nodo.
     * @param codigoNodo 
     */
    public void imprimirPreguntas(String codigoNodo) {
        NodoChatBot nodo = buscarNodo(codigoNodo);
        if (nodo == null || nodo.getPreguntas() == null) {
            System.out.println("No hay preguntas en este nodo o el nodo no existe.");
            return;
        }

        NodoPregunta actual = nodo.getPreguntas().getCabeza();
        int contador = 1;
        while (actual != null) {
            System.out.println(contador + ". " + actual.getDato().getPregunta() + " - " + actual.getDato().getRespuesta());
            actual = actual.getSiguiente();
            contador++;
        }
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
