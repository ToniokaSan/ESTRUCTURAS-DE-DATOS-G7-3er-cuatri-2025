package com.universidad.proyectofinal;

/**
 * Representa una pila de premios donde se almacenara la informacion de los premios para el juego MVP
 * Permite apilar (encolar), desapilar (desencolar),modificar y visualizar los castigos registrados.
 * Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
import javax.swing.JOptionPane; 
public class PilaPremios {
    private NodoPremio cima; // se determina la cima de la pila de premios

    /**
     * constructor vacio
     */
    public PilaPremios(){

    }
    /**
     * Constructor vacio que inicializa la cima nula e inicia una pila vacia.
     * @param cima 
     */
    public PilaPremios(NodoPremio cima) {
        this.cima = cima;
    }

    /**
     * Metodo encolar permite crear un nuevo elemento en la pila de premios
     * @param operacion simbolo o caracter que representa la operacion en la pila
     * @param numero tipo de entero que afecta la posicion actual del jugador
     * @param descripcion informacion descriptiva del premio obtenido por el jugador.
     */
    public void encolar(char operacion, int numero, String descripcion) {
        DatoPremio premio = new DatoPremio(operacion, numero, descripcion);
        NodoPremio nuevo = new NodoPremio(premio);
        nuevo.setAbajo(cima);
        cima = nuevo;
    }

    /**
     * Metodo desencolar permite mostrar y eliminar un elemento en la pila de premios
     * @return el objeto que estaba en la cima
     * @throws Exception retorna un aviso de error en caso de que la pila esté vacia
     */
    public DatoPremio desencolar() throws Exception {
        if (estaVacia()) {
            throw new Exception("La pila de premios está vacía.");
        }
        DatoPremio datoTemporal = cima.getDato();
        cima = cima.getAbajo();
        return datoTemporal;
    }

    /**
     * metodo que permite determinar si la pila esta vacia
     * @return true en caso de que este vacia, false en caso de que aun se encuentren elementos en ella.
     */
    public boolean estaVacia() {
        return cima == null;
    }
    
    /**
     * Metodo de modificar premios que permite cambiar las caracteristicas de premios existentes en la pila.
     * @param descripcionBuscada Descripcion del metodo que se desea modificar
     * @param nuevaOperacion Nueva operacion que contendra el premio 
     * @param nuevoNumero Nuevo numero que afectara la posicion del jugador
     * @param nuevaDescripcion Nueva descrpcion que poseera el elemento de premio en la pila.
     * @return si el premio fue encontrado retorna true, de lo contrario false.
     */
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


    /**
     * Devuelve representacion de texto de PilaPremios, mostrando caracteristicas de los premios en la pila
     * @return informacion de los premios apilados.
     */
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