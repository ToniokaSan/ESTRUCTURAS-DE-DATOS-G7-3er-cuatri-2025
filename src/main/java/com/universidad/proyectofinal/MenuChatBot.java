/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;
import javax.swing.*;
/**
 * Clase Menu chat bot tiene como proposito desplegar la interfaz del menu del chat bot presente en el juego
 * @Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez
 * Badilla, Sebastian Alvarez Murillo.
 */
public class MenuChatBot {
    private ArbolChatBot arbol;
    
    public MenuChatBot(ArbolChatBot arbol) {
        this.arbol = arbol;
    }
    /*
    Metodo void mostrar menu, permite desplegar el menu del chatbot viendo las opciones disponibles.
    */
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
    /*
    Metodo void que conlleva a navegar en la interfaz del chatbot, permite navegar entre los nodos disponibles dentro del arbol.
    */
    public void verChatBot() {
        NodoChatBot actual = arbol.getRaiz();
        JOptionPane.showMessageDialog(null, "¡Bienvenido al ChatBot!");
        boolean salir = false;

        while (!salir) {
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("Nodo: ").append(actual.getNombre()).append("\n");

            int opcionNum = 1;
            NodoChatBot hijo1 = actual.getIzquierdo();
            NodoChatBot hijo2 = actual.getDerecho();

            if (hijo1 != null) {
                mensaje.append(opcionNum++).append(". ").append(hijo1.getNombre()).append("\n");
            }
            if (hijo2 != null) {
                mensaje.append(opcionNum++).append(". ").append(hijo2.getNombre()).append("\n");
            }

            // Preguntas de la hoja
            NodoPregunta preguntaActual = actual.getPreguntas() != null ? actual.getPreguntas().getCabeza() : null;
            int primerIndicePregunta = opcionNum;
            while (preguntaActual != null) {
                mensaje.append(opcionNum++).append(". ").append(preguntaActual.getDato().getPregunta()).append("\n");
                preguntaActual = preguntaActual.getSiguiente();
            }

            mensaje.append(opcionNum).append(". Regresar");

            int opcion = -1;
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje.toString()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                continue;
            }

            // Selección de hijo
            if (opcion == 1 && hijo1 != null) {
                actual = hijo1;
            } else if (opcion == 2 && hijo2 != null) {
                actual = hijo2;
            } // Selección de pregunta
            else if (opcion >= primerIndicePregunta && opcion < opcionNum) {
                int contador = primerIndicePregunta;
                preguntaActual = actual.getPreguntas() != null ? actual.getPreguntas().getCabeza() : null;
                while (preguntaActual != null) {
                    if (opcion == contador) {
                        JOptionPane.showMessageDialog(null, preguntaActual.getDato().getRespuesta(), preguntaActual.getDato().getPregunta(), JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    preguntaActual = preguntaActual.getSiguiente();
                    contador++;
                }
            } // Regresar
            else if (opcion == opcionNum) {
                if (actual.getPadre() != null) {
                    actual = actual.getPadre();
                } else {
                    salir = true;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }

        JOptionPane.showMessageDialog(null, "¡Gracias por usar el ChatBot!");
    }

    
    /*
    private void verChatBot() {
        NodoChatBot actual = arbol.getRaiz();
        JOptionPane.showMessageDialog(null, "¡Bienvenido al ChatBot!");
        boolean salir = false;

        while (!salir) {
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("Nodo: ").append(actual.getNombre()).append("\n");

            int opcionNum = 1;
            NodoChatBot[] hijos = new NodoChatBot[2]; // max 2 hijos
            int index = 0;

            if (actual.getIzquierdo() != null) {
                mensaje.append(opcionNum++).append(". ").append(actual.getIzquierdo().getNombre()).append("\n");
                hijos[index++] = actual.getIzquierdo();
            }
            if (actual.getDerecho() != null) {
                mensaje.append(opcionNum++).append(". ").append(actual.getDerecho().getNombre()).append("\n");
                hijos[index++] = actual.getDerecho();
            }

            // Si es hoja con preguntas
            NodoPregunta p = actual.getPreguntas() != null ? actual.getPreguntas().getCabeza() : null;
            NodoPregunta[] listaPreguntas = null;
            if (p != null) {
                listaPreguntas = new NodoPregunta[10]; // tamaño arbitrario para almacenar preguntas
                int i = 0;
                while (p != null) {
                    mensaje.append(opcionNum).append(". ").append(p.getDato().getPregunta()).append("\n");
                    listaPreguntas[i++] = p;
                    p = p.getSiguiente();
                    opcionNum++;
                }
            }

            // Opción de regresar
            mensaje.append(opcionNum).append(". Regresar");
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje.toString()));

            // Lógica de selección
            if (opcion <= index && opcion > 0) {
                // Seleccionó un hijo
                actual = hijos[opcion - 1];
            } else if (listaPreguntas != null && opcion > index && opcion <= index + listaPreguntas.length) {
                int preguntaIndex = opcion - index - 1;
                if (preguntaIndex < listaPreguntas.length && listaPreguntas[preguntaIndex] != null) {
                    JOptionPane.showMessageDialog(null, listaPreguntas[preguntaIndex].getDato().getRespuesta());
                } else {
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
                }
            } else if (opcion == opcionNum) {
                // Regresar
                if (actual.getPadre() != null) {
                    actual = actual.getPadre();
                } else {
                    salir = true; // estamos en raíz, salir del ChatBot
                }
            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
        JOptionPane.showMessageDialog(null, "¡Gracias por usar el ChatBot!");
    }
    */

    /*
    Metodo void que permite realizar el mantenimiento del chatbot en modo administrador, este 
    permite ya sea agregar un nodo o pregunta dentro del arbol, a su vez regresar entre las opciones.
    */
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
