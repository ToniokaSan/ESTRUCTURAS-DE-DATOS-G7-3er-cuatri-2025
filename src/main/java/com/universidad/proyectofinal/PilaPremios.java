package com.universidad.proyectofinal;

/**
 *
 * @author
 */
import javax.swing.JOptionPane; 
public class PilaPremios {
    private NodoPremio cima;

    public PilaPremios(){

    }
    public PilaPremios(NodoPremio cima) {
        this.cima = cima;
    }

    public void encolar(char operacion, int numero, String descripcion) {
        DatoPremio premio = new DatoPremio(operacion, numero, descripcion);
        NodoPremio nuevo = new NodoPremio(premio);
        nuevo.setAbajo(cima);
        cima = nuevo;
    }

    public DatoPremio desencolar() throws Exception {
        if (estaVacia()) {
            throw new Exception("La pila de premios está vacía.");
        }
        DatoPremio datoTemporal = cima.getDato();
        cima = cima.getAbajo();
        return datoTemporal;
    }

    public boolean estaVacia() {
        return cima == null;
    }
    
    public boolean modificarPremios(String descripcionBuscada, char nuevaOperacion, int nuevoNumero, String nuevaDescripcion) {
        NodoPremio actual = cima;

        while (actual != null) {
            if (actual.getDato().getDescripcion().equals(descripcionBuscada)) {
                actual.getDato().setOperacion(nuevaOperacion);
                actual.getDato().setNumero(nuevoNumero);
                actual.getDato().setDescripcion(nuevaDescripcion);
                return true; // se modificó
            }
            actual = actual.getAbajo();
        }

        return false; // no se encontró el premio
    }


    @Override
    public String toString() {
        if (estaVacia()) {
            return "No hay premios en la pila.";
        }
        
        StringBuilder sb = new StringBuilder("--- Pila de Premios ---\n");
        NodoPremio actual = cima;
        int contador = 1;
        while (actual != null) {
            sb.append("Premio ").append(contador).append(": ")
              .append(actual.getDato().getDescripcion())
              .append("\n");
            actual = actual.getAbajo();
            contador++;
        }
        return sb.toString();
    }
}