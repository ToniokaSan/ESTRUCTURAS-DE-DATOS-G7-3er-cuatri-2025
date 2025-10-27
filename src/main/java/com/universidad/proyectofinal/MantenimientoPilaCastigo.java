/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;
import javax.swing.JOptionPane;
/**
 * Menu interactivo que permite modificar los elementos que se encuentras en la pila de castigos
 * Permite al usuario, agregar, eliminar, modificar y ver castigos disponibles
 * Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
public class MantenimientoPilaCastigo {
    
    PilaCastigo pilaCastigos;
    
    /**
     * Constructor de la clase MantenimientoPilaCastigo.
     *  Inicializa la clase con una pila de castigos existente.
     * @param pilaCastigos objeto de pilaCastigos que se gestionara mediante el menu.
     */
    public MantenimientoPilaCastigo(PilaCastigo pilaCastigos) {
        this.pilaCastigos = pilaCastigos;
    }

    /**
     * Muestra un menú interactivo que permite al usuario realizar operaciones
     * en la pila de castigo, como agregar, modificar, eliminar y ver los castigos existentes.
     */
    public void menuPilaCastigo() {
        boolean salir = false;
        while (!salir) {
            String eleccion = JOptionPane.showInputDialog(null, "///Mantenimiento de castigos//\n+"
                    + "1. Agregar castigo\n"
                    + "2. Eliminar castigo\n"
                    + "3. Modificar castigo\n"
                    + "4. Ver castigos disponibles\n"
                    + "5. Salir"
            );
            if (eleccion == null) { // si el usuario cierra el cuadro
                salir = true;
                continue;
            }
            int opcion;
            opcion = Integer.parseInt(eleccion);
            switch (opcion) {
                case 1:
                    agregarCastigo();
                    break;
                case 2:
                    eliminarCastigo();
                    break;
                case 3:
                    modificarCastigo();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, pilaCastigos.toString());
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida, seleccione otra");

            }
        }
    }
    
    
    /**
     * Solicita al usuario un nuevo castigo y lo agrega a la pila.
     */
    public void agregarCastigo() {
        char operacion = JOptionPane.showInputDialog("Ingrese operación (- o =):").charAt(0);
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero:"));
        String descripcion = JOptionPane.showInputDialog("Ingrese descripcion:");
        pilaCastigos.encolar(operacion, numero, descripcion);
    }
    /**
     * Elimina un elemento de la pila de castigos y muestra su informacion.
     */
    public void eliminarCastigo() {
        try {
            DatoCastigo eliminado = pilaCastigos.desencolar();
            JOptionPane.showMessageDialog(null, "Se eliminó: " + eliminado.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /**
     * Permite modificar un castigo existente, buscando por su descripción y actualizando sus datos.
     * De lo contrario, se avisa que no se encontró
     */
    public void modificarCastigo() {
        String descripcionBuscada = JOptionPane.showInputDialog("Ingrese la descrpcion del castigo para modificarlo:");
        char nuevaOperacion = JOptionPane.showInputDialog("Ingrese nueva operacion:").charAt(0);
        int nuevoNumero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo numero:"));
        String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese nueva descripcion:");
        boolean modificado = pilaCastigos.modificarCastigo(descripcionBuscada, nuevaOperacion, nuevoNumero, nuevaDescripcion);
        if (modificado) {
            JOptionPane.showMessageDialog(null, "Castigo modificado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro el premio.");
        }
    }
}
