package com.universidad.proyectofinal;

public class Pila {
    private NodoPila cima;

    public Pila() {
    }

    public Pila(NodoPila cima) {
        this.cima = cima;
    }

    public NodoPila getCima() {
        return cima;
    }

    public void setCima(NodoPila cima) {
        this.cima = cima;
    }

    // Métodos de la definición formal de Pilas

    // Método que retorna true o false si la pila está vacía
    // o si tiene elementos.
    public boolean esVacia() {
        return cima == null;
    }

    // Método apilar. Permite insertar un elemento a la pila  (PUSH)
    public void apilar(String valor) {
        // Paso 1: Crear el Dato.
        Dato miDato = new Dato(valor);

        // Paso 2: Crear el Nodo.
        NodoPila miNodo = new NodoPila(miDato);

        // Paso 3: Para insertar tenemos dos opciones.

        if (esVacia()) {  // Si la pila está vacía.
            cima = miNodo;
        } else { // Si la pila tiene elementos.
            miNodo.setAbajo(cima); // Paso 3.1 Amarro el nuevo nodo a la pila
            // Paso 3.2 Mover la cima al nuevo nodo, para que no esté de segunda
            cima = miNodo;
        }
    }

    // Método desapilar. Permite sacar un elemento de la pila (POP)
    public Dato desapilar() {
        if (esVacia()) { // Si la pila está vacía, retorno Null para no caer en excepción (Stack Underflow)
            return null;
        } else {
            // 1. Guardamos la cima en una variable temporal.
            Dato valorTemporal = cima.getDato();
            // 2. Movemos la cima al que está debajo (segundo).
            cima = cima.getAbajo();
            // 3. Retornamos lo que antes era la cima y habíamos guardado en la variable temporal.
            return valorTemporal;
        }
    }

    // Método que recorre la pila y la imprime.
    public void imprimePila() {
        if (esVacia()) {
            System.out.println("No se pudo imprimir, está vacía");
        }
    }
}