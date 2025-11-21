/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

/**
 *Clase lista circular, permite crear una lista circular en las que se vincula el primer elemento, con el ultimo
 * Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
public class ListaCircular {
    private NodoCircular primero;
    private NodoCircular ultimo;

    /**
     * Constructor vacio para creacion de objetos.
     */
    public ListaCircular() {
    }

    /**
     * obtiene el primer elemento
     * @return primero
     */
    public NodoCircular getPrimero() {
        return primero;
    }

    /**
     * obtiene el ultimo elemento
     * @return ultimo
     */
    public NodoCircular getUltimo() {
        return ultimo;
    }

    /**
     * modifica el primer elemento de la lista circular
     * @param primero 
     */
    public void setPrimero(NodoCircular primero) {
        this.primero = primero;
    }

    /**
     * modifica el ultimo elemento de la lista ciruclar
     * @param ultimo 
     */
    public void setUltimo(NodoCircular ultimo) {
        this.ultimo = ultimo;
    }
    /**
     * Metodo que permite insertar un elemento de forma ordenada, lo ordena por sus atributos.
     * @param valor 
     */
    public void insertaOrdenado(int valor){
        // Caso 1: La lista está vacía.
        if (primero == null){
            // Paso 1.1 Creamos el nodo.
            NodoCircular aux = new NodoCircular(valor);
            // Paso 1.2 Reescribir el primero.
            primero = aux;
            // Paso 1.3 Reescibir el último.
            ultimo = primero;
            // Paso 1.4 La hago circular.
            ultimo.setSiguiente(primero);
        }else
            // Caso 2: El elemento a insertar es menor al primero. Lo inserto a la izquierda.
            if (valor <= primero.getDato()){
                // Paso 2.1 Creamos el nodo.
                NodoCircular aux = new NodoCircular(valor);
                
                // Paso 2.2  Amarramos la nueva cajita al primero de al lista.
                aux.setSiguiente(primero);

                // Paso 2.3 Amarrar el último a la nueva cajita
                ultimo.setSiguiente(aux);
                
                // Paso 2.4 Mover el primero.
                primero = aux;
            }else //Caso 3: El elemento a insertar es mayor al último.
                if (valor > ultimo.getDato()){
                    // Paso 3.1 Creamos el nodo.
                    NodoCircular aux = new NodoCircular(valor);
                    // Paso 3.2 Amarramos el último a la nueva cajita.
                    ultimo.setSiguiente(aux);
                    // Paso 3.3 Mover el último.
                    ultimo = aux;
                    // Paso 4: Ligar el nuevo último al primero para hacerla circular.
                    ultimo.setSiguiente(primero);
                }
            else{
                // Caso 4: El elemento a insertar va en una posición interna.
                // Paso 4.1: Vamos a iterar la lista para encontrar el lugar donde insertar}
                NodoCircular aux = primero;
                while (aux.getSiguiente().getDato() < valor){
                    aux = aux.getSiguiente();
                }
                // Paso 4.2  Crear la cajita
                NodoCircular temp = new NodoCircular(valor);    
               // Paso 4.3 Amarrar la nueva cajita al resto de la lista
                temp.setSiguiente(aux.getSiguiente());
               // paso 4.4Amarro el aux al nuevo siguiente (temp)-
                aux.setSiguiente(temp);
            }
    
    }
    
    
}
