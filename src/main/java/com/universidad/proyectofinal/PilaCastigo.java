
package com.universidad.proyectofinal;

/**
 * Representa una pila de castigos, donde se almacenara la informacion de los castigos para el presente
 * proyecto, el cual es un juego MVP
 * Permite apilar (encolar), desapilar (desencolar), modificar y visualizar los castigos registrados.
 * Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
public class PilaCastigo {
    private NodoCastigo cima; //es el elemento superior para de la pila, como referencia.

    /**
     * constructor para inicializar la pila en forma vacia, ademas de iniciar la cima como nula.
     */
    public PilaCastigo() {
        this.cima = null;
    }

    /**
     * Metodo encolar o apilar el cual permite crear un nuevo elemento en la pila
     * @param operacion simbolo o caracter que representa el castigo obtenidp
     * @param numero tipo entero que determina la cantidad de posicion a movilizar
     * @param descripcion informacion que presenta el elemento en la pila
     */
    public void encolar(char operacion, int numero, String descripcion) {
        DatoCastigo castigo = new DatoCastigo(operacion, numero, descripcion);
        NodoCastigo nuevo = new NodoCastigo(castigo);
        nuevo.setSiguiente(cima);
        cima = nuevo;
    }

    /**
     * Devuelve y elimina el elemento en la pila 
     * @return el objeto que estaba en la cima 
     * @throws Exception mensaje de error en caso de que la pila se encuentre vacia
     */
    public DatoCastigo desencolar() throws Exception {
        if (estaVacia()) {
            throw new Exception("La pila de castigos está vacía.");
        }
        DatoCastigo dato = cima.getDato();
        cima = cima.getSiguiente();
        return dato;
    }

    /**
     * metodo esta vacia permite verificar si la pila se encuentra vacia por medio de un booleano
     * 
     * @return true si la pila se encuentra vacia, sino devuelve false
     */
    public boolean estaVacia() {
        return cima == null;
    }
    
    /**
     * Metodo modificarCastigo permite modificar los elementos de los castigos predeterminados por el 
     * Programa, donde se podra editar la operacion, numero y descripcion de los castigos disponibles.
     * @param descripcionBuscada Descrpcion del castigo que se desea modificar 
     * @param nuevaOperacion Nueva operacion que se asignara al castigo
     * @param nuevoNumero Nuevo numero que se asignara al castigo
     * @param nuevaDescripcion Nueva descrpcion del castigo 
     * @return si el codigo fue encontrado y modificado retorna true, de lo contrario false.
     */
    public boolean modificarCastigo(String descripcionBuscada, char nuevaOperacion, int nuevoNumero, String nuevaDescripcion) {
        NodoCastigo actual = cima;

        while (actual != null) {
            if (actual.getDato().getDescripcion().equals(descripcionBuscada)) {
                actual.getDato().setOperacion(nuevaOperacion);
                actual.getDato().setNumero(nuevoNumero);
                actual.getDato().setDescripcion(nuevaDescripcion);
                return true; // se modificó
            }
            actual = actual.getSiguiente();
        }

        return false; // no se encontró el premio
    }

    /**
     * Devuelve representacion de texto de PilaCastigo, mostrando caracteristicas de los castigos
     * almacendados en la pila.
     * @return informacion de los castigos aplilados.
     */
    @Override
    public String toString() {
        if (estaVacia()) {
            return "No hay castigos en la pila.";
        }
        
        StringBuilder sb = new StringBuilder("--- Pila de Castigos ---\n");
        NodoCastigo actual = cima;
        int contador = 1;
        while (actual != null) {
            sb.append("Castigo ").append(contador).append(": ")
              .append(actual.getDato().getDescripcion())
              .append("\n");
            actual = actual.getSiguiente();
            contador++;
        }
        return sb.toString();
    }
}


