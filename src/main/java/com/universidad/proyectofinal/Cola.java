/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

/**
 * Clase Principal de la EE DD Cola.
 * Almacenará las referencias así como los métodos de la definición formal de Cola.
 * @author EQUIPO
 */
public class Cola {
    private Nodo frente;  // Referencia que apunta al primer elemento de la cola.
    private Nodo fin;  // Referencia que apunta al último elemento de la cola.

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public Nodo getFrente() {
        return frente;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }
    
    public void setFin(Nodo fin) {
        this.fin = fin;
    }
    
    // Crear los métodos de la definición formal de Cola.
    public void encolar(Dato valor){
        Nodo nuevo = new Nodo(valor);   // PASO 1 Crear la cajita.
        
        // PASO 2: Amarrar la nueva cajita a la cola.
        if (frente == null){  // CASO 1: Si la cola está vacía
            frente = nuevo;  // Coloco la referencia del frente a apuntar a la nueva cajita
        }else{               // CASO 2: Si la cola NO está vacía
            fin.setSiguiente(nuevo);      //Amarrar la nueva cajita al final de la cola.
        }
        fin = nuevo;    // Coloco la referencia del fin a apuntar a la nueva cajita
    }
    
    public Dato desencolar()throws Exception {
    
        if (frente == null){  // Si la cola está vacía. NO podemos desencolar
            // Retorne una excepción para que el usuario sepa que no se pudo desencolar.
            throw new Exception("Cola vacía, no se puede desencolar");
        }else{
            Dato temp = frente.getNombreJugador(); // Guardar el dato del frente en una variable temporal para NO perderlo.
            frente = frente.getSiguiente(); // Mover la ferencia del frente al segundo.
            
            if (frente == null){    //Si la cola queda nula después de eliminar un elemento
                fin = null;     // Poniendo en null la referencia al fin.    
            }
            return temp;
        }
    
    }
    
    public Dato frente(){
        if (this.getFrente() == null)
            return null;
        else
            return this.frente.getNombreJugador();
    }
    
    public boolean estaVacia(){
       /*if (this.frente == null) 
           return true;
       else 
           return false;*/
       return frente == null;
    }
    
    public void imprimeCola(){
        if (estaVacia()){
            System.out.println("No se pudo imprimir,la cola está vacía");
        }else{
            Nodo actual = frente; // Creamos una variable temporal para recorrer la cola
            while(actual != null){
                System.out.println(actual.getNombreJugador());
                actual = actual.getSiguiente();
            }
        }
    
    
    }
    
}
