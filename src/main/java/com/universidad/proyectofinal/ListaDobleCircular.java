/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

/**
 *
 * @author EQUIPO
 */
public class ListaDobleCircular {
    private NodoDoble primero;
    private NodoDoble ultimo;

    public ListaDobleCircular() {
    }

    public NodoDoble getPrimero() {
        return primero;
    }

    public NodoDoble getUltimo() {
        return ultimo;
    }

    public void setPrimero(NodoDoble primero) {
        this.primero = primero;
    }

    public void setUltimo(NodoDoble ultimo) {
        this.ultimo = ultimo;
    }
    
    public void insertaOrdenado(int valor){
        // Caso 1: Lista esta vacía.
        if (primero == null){
            // Paso 1.1: Crear la cajita.
            NodoDoble aux = new NodoDoble(valor);
            // Paso 1.2: Apuntar el primero a la nueva cajita.
            primero = aux;
            // Paso 1.3: Apuntar el último a la nueva cajita.
            ultimo = aux;
            // 1.4: Apuntar el siguiente a si mismo.
            ultimo.setSiguiente(primero);
            // 1.5: Apuntar el anterior a si mismo.
            primero.setAnterior(ultimo);
        }
        else if(valor < primero.getDato()){
        // Caso 2: Insertar un elemento menor al primero.
            // Paso 2.1: Crear la cajita.
            NodoDoble aux = new NodoDoble(valor);
            
            // Paso 2.2: Amarro la nueva cajita al primero de la lista.
            aux.setSiguiente(primero);
            
            // Paso 2.3 Amarro el sgte del último a la nueva cajita
            ultimo.setSiguiente(aux);
            
            // Paso 2.4 Amarro el anterior de la nueva cajita al último.
            aux.setAnterior(ultimo);
            
            // paso 2.5 Amarro el anterior al primero a la nueva cajita.
            primero.setAnterior(aux);
            
            // paso 2.6 Mover el primero a la nueva cajita.
            primero = aux;
            
        }else if (valor >= ultimo.getDato()){ // Caso 3: Insertar un elemento mayor o igual al último.
          // Paso 3.1: Crear la cajita.
            NodoDoble aux = new NodoDoble(valor);   
            // Amarro el sgte de la nueva cajita al primero de la lista.
            aux.setSiguiente(primero);
            // Amarro el anterio de la nueva cajita al ultimo
            aux.setAnterior(ultimo);
            // Amarro el sgte del último a la nueva cajita.
            ultimo.setSiguiente(aux);
            // Amarro el anterior del primero, al nuevo último (nueva cajita)
            primero.setAnterior(aux);
            
            // Movemos el puntero del último a la nueva cajita.
            ultimo = aux;
        }else{
        // Caso 4: Insertar en el medio de la lista.
            // Paso 4.1 Buscar el lugar.
             NodoDoble aux = primero;
             while (aux.getSiguiente().getDato() < valor){
                    aux = aux.getSiguiente();
             }
             // paso 4.2 Creo la cajita del nodo a insertar
             NodoDoble temp = new NodoDoble(valor); 
             
             // paso 4.3 Amarro la nueva cajita al siguiente de la liosta
             temp.setSiguiente(aux.getSiguiente());
             // Paso 4.4 Amarro la nueva cajita pero para atrás.
             temp.setAnterior(aux);
             // Paso 4.5 Amarro la caja siguiente de la nueva para atrás con la nueva.
             temp.getSiguiente().setAnterior(temp);
             
             // Paso 4.6 Amarramos el aux a la nueva cajita.
             aux.setSiguiente(temp);
             
        }
        
        
    
    }
    
}
