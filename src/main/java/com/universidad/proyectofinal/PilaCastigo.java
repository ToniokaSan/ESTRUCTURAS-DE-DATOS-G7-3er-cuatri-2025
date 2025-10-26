
package com.universidad.proyectofinal;

/**
 * 
 * 
 */
public class PilaCastigo {
    private NodoCastigo cima;

    public PilaCastigo() {
        this.cima = null;
    }

    public void encolar(char operacion, int numero, String descripcion) {
        DatoCastigo castigo = new DatoCastigo(operacion, numero, descripcion);
        NodoCastigo nuevo = new NodoCastigo(castigo);
        nuevo.setSiguiente(cima);
        cima = nuevo;
    }

    public DatoCastigo desencolar() throws Exception {
        if (estaVacia()) {
            throw new Exception("La pila de castigos está vacía.");
        }
        DatoCastigo dato = cima.getDato();
        cima = cima.getSiguiente();
        return dato;
    }

    public boolean estaVacia() {
        return cima == null;
    }
    
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


