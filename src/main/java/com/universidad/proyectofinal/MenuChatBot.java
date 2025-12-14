/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;
import javax.swing.*;
/**
 *
 * @author potoy
 */
public class MenuChatBot {
    private ArbolChatBot arbol;
    
    public MenuChatBot(ArbolChatBot arbol) {
        this.arbol = arbol;
    }
    
    public void mostrarMenu() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "=== ChatBot ===\n"
                    + "1. Ver ChatBot (Usuarios)\n"
                    + "2. Mantenimiento ChatBot (Administrador)\n"
                    + "3. Salir"
            ));
            switch (opcion) {
                case 1:
                    verChatBot();
                    break;
                case 2:
                    mantenimientoChatBot();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar el ChatBot!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 3);
    }
    
    private void verChatBot() {
        NodoChatBot actual = arbol.getRaiz();
        JOptionPane.showMessageDialog(null, "¡Bienvenido al ChatBot!");
        boolean salir = false;
        while (!salir) {
            String mensaje = "Nodo: " + actual.getNombre() + "\n";
            int contador = 1;
            if (actual.getIzquierdo() != null) {
                mensaje += contador++ + ". " + actual.getIzquierdo().getNombre() + "\n";
            }
            if (actual.getDerecho() != null) {
                mensaje += contador++ + ". " + actual.getDerecho().getNombre() + "\n";
            }
            if (actual.getPreguntas() != null) {
                NodoPregunta p = actual.getPreguntas().getCabeza();
                while (p != null) {
                    mensaje += contador++ + ". " + p.getDato().getPregunta() + "\n";
                    p = p.getSiguiente();
                }
            }
            mensaje += contador + ". Regresar";

            int opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            // Dependiendo de la selección, navegamos
            int sel = 1;
            if (actual.getIzquierdo() != null && opcion == sel) {
                actual = actual.getIzquierdo();
            } else if (actual.getDerecho() != null && opcion == sel + (actual.getIzquierdo() != null ? 1 : 0)) {
                actual = actual.getDerecho();
            } else if (actual.getPreguntas() != null) {
                NodoPregunta p = actual.getPreguntas().getCabeza();
                while (p != null) {
                    if (opcion == sel) {
                        JOptionPane.showMessageDialog(null, p.getDato().getRespuesta());
                        break;
                    }
                    sel++;
                    p = p.getSiguiente();
                }
                if (opcion == sel) {
                    actual = actual.getPadre(); // Regresar
                }
            } else {
                actual = actual.getPadre(); // Regresar
            }
            if (actual == null) {
                salir = true;
            }
        }
        JOptionPane.showMessageDialog(null, "¡Gracias por usar el ChatBot!");
    }

    private void mantenimientoChatBot() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "=== Mantenimiento ChatBot ===\n"
                    + "1. Agregar Nodo\n"
                    + "2. Agregar Pregunta\n"
                    + "3. Regresar"
            ));
            switch (opcion) {
                case 1:
                    String padre = JOptionPane.showInputDialog("Código del nodo padre:");
                    String nombreHijo = JOptionPane.showInputDialog("Nombre del nodo hijo:");
                    if (arbol.agregarNodo(padre, nombreHijo)) {
                        JOptionPane.showMessageDialog(null, "Nodo agregado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al agregar nodo.");
                    }
                    break;
                case 2:
                    String hoja = JOptionPane.showInputDialog("Código del nodo hoja:");
                    String pre = JOptionPane.showInputDialog("Pregunta:");
                    String resp = JOptionPane.showInputDialog("Respuesta:");
                    if (arbol.agregarPregunta(hoja, new Pregunta(pre, pre, resp))) {
                        JOptionPane.showMessageDialog(null, "Pregunta agregada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al agregar pregunta.");
                    }
                    break;
            }
        } while (opcion != 3);
    }
    
}
