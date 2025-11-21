/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

/**
 * Clase que ejecuta la creacion de una lista de tipo doble.
 * Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
public class ListaDoble {
   private NodoDoble primero;

   /**
    * Constructor vacio
    */
    public ListaDoble() {
    }

    public NodoDoble getPrimero() {
        return primero;
    }

    public void setPrimero(NodoDoble primero) {
        this.primero = primero;
    }
   /**
    * Metodo insertar ordenado que permite insetar valores a una lista doble
    * @param valor 
    */
    public void insertaOrdenado(int valor){
        // Caso 1: La lista está vacía.
        if (primero == null){
            NodoDoble aux = new NodoDoble(valor);
            primero = aux;
        }else
            // Caso 2: El valor a insertar es menor al primero.
            if (valor < primero.getDato()){
                // Paso 2.1 Crear la cajita
                NodoDoble aux = new NodoDoble(valor);
                // Paso 2.2 Amarro la nueva caja al primero.
                aux.setSiguiente(primero);
                
                // Paso 2.3 Amarro el primero para atrás a la nueva cajita.
                primero.setAnterior(aux);
                
                // paso 2.4: Mover la referencia al primero ya que quedó de segundo.
                primero = aux;
            }
            else{
            // Caso 3: Si quiero insertar en el medio de lista.
               // Paso 4.1: Vamos a iterar la lista para encontrar el lugar donde insertar}
                NodoDoble aux = primero;
                while (aux.getSiguiente().getDato() < valor){
                    aux = aux.getSiguiente();
                }
                
                // Paso 4.2. Creo la cajita.
                NodoDoble temp = new NodoDoble(valor);
                // Paso 4.3 Amarro el sgte de la cajia nueva al que esta después del aux
                temp.setSiguiente(aux.getSiguiente());
                // Paso 4.4 Amarro el anterior de la nueva cajita al aux.
                temp.setAnterior(aux);
                // Paso 4.5 Amarro el aux a la nueva cajita.
                aux.setSiguiente(temp);
                // Paso 4.6 Amarro el siguiente de la cajita para atrás a la nueva cajita.
                temp.getSiguiente().setAnterior(temp);
            }
    
    }
   
}
