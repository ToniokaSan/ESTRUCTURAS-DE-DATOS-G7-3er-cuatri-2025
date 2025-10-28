/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

/**
 * Menu interactivo que permite modificar los elementos que se encuentras en la pila de premios
 * Permite al usuario, agregar, eliminar, modificar y ver premios disponibles
 * Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
import javax.swing.JOptionPane;

public class MantenimientoPilaPremio {

     PilaPremios pilaPremios;

     /**
      * Inicializa la pila de premios existentes 
      * @param pilaPremios objeto de la pila de premios que se gestionara por el menu
      */
    public  MantenimientoPilaPremio(PilaPremios pilaPremios) {
        this.pilaPremios = pilaPremios;
    }
    /**
     * Menu interactivo que permitira gestionar la pila de premios, en sus funciones se encuentra:
     * Agregar, eliminar, modificar, y ver los premios disponibles en la pila.
     */
    public void menuPilaPremio() {
    boolean salir = false;
    while (!salir){
        String eleccion = JOptionPane.showInputDialog(null, "///Mantenimiento de Pilas//\n+"
        + "1. Agregar Premio\n"
        + "2. Eliminar Premio\n"
        + "3. Modificar Premio\n"
        + "4. Ver Premios disponibles\n"
        + "5. Salir"
        );
        if (eleccion == null) { // si el usuario cierra el cuadro
            salir = true;
            continue;
        }
        int opcion;
        opcion = Integer.parseInt(eleccion);
        switch (opcion){
            case 1:
                agregarPremio();
                break;
            case 2: 
                eliminarPremio();
                break;
            case 3:
                modificarPremio();
                break;
            case 4:
                JOptionPane.showMessageDialog(null, pilaPremios.toString());
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
     * Metodo agregarPremio que permite encolar un nuevo premio a la pila
     */
    public void agregarPremio(){
        char operacion = JOptionPane.showInputDialog("Ingrese operacion (+ o -):").charAt(0);
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero:"));
        String descripcion = JOptionPane.showInputDialog(null,"Ingrese la descrpcion");
        pilaPremios.encolar(operacion, numero, descripcion);
    }
    
    /**
     *Metodo eliminarPremio permite desencolar o (eliminar) un elemento de la pila. 
     */
    public void eliminarPremio(){
        try {
            DatoPremio eliminado = pilaPremios.desencolar();
            JOptionPane.showMessageDialog(null, "Se acaba de eliminar: " + eliminado.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    /**
     * Permite buscar un premio y modificar sus atributos, tales como 
     * Nueva operacion, nuevo numero y nueva descripcion, si este no se encuentra lo mostrara con mensaje.
     */
    public void modificarPremio (){
        String descripcionBuscada = JOptionPane.showInputDialog("Ingrese la descrpcion del premio para modificarlo:");
        char nuevaOperacion = JOptionPane.showInputDialog("Ingrese nueva operacion:").charAt(0);
        int nuevoNumero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo numero:"));
        String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese nueva descripcion:");
        boolean modificado = pilaPremios.modificarPremios(descripcionBuscada, nuevaOperacion, nuevoNumero, nuevaDescripcion);
        if (modificado) {
            JOptionPane.showMessageDialog(null, "Premio modificado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro el premio.");
        }
    } 
}// final de la clase
