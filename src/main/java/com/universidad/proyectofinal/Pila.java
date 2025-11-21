package com.universidad.proyectofinal;
/**
 * Representa la creacion de una nueva pila en la que se establece la cima
 *  Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
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

    /**
     * Metodo booleano que retorna verdadero o falso si esta se encuentra vacia
     * @return boolean
     */
    public boolean esVacia() {
        return cima == null;
    }

    /**
     * Metodo apilar que permite agregar elementos a la pila.
     * @param valor 
     */
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

    /**
     * Metodo desapilar, permite eliminar elementos de la pila.
     * @return valor
     */
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
    /**
     * Metodo imprimir pila, permite imprimir la informacion que contiene la pila
     */
    public void imprimePila() {
        if (esVacia()) {
            System.out.println("No se pudo imprimir, está vacía");
        }
    }
}