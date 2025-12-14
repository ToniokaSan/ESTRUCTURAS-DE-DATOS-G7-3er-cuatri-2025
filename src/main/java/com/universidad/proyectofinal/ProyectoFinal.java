package com.universidad.proyectofinal;

import javax.swing.*;

/**
 * Clase principal del proyecto final de Estructuras de Datos.
 * Se encarga de inicializar los jugadores, las pilas de premios y castigos,
 * y de iniciar el menú principal del juego.
 *  Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
public class ProyectoFinal {

    public static void main(String[] args) throws Exception {
        
        preparadosListosCola jugadores = new preparadosListosCola();

        
        int cantidadJugadores = 0;
        while (cantidadJugadores <= 0 || cantidadJugadores > 4) {
                String inputCantidad = JOptionPane.showInputDialog(null, "Ingrese la cantidad de jugadores (1-4):", "Inicio del Juego", JOptionPane.QUESTION_MESSAGE);
                cantidadJugadores = Integer.parseInt(inputCantidad);
                if (cantidadJugadores <= 0 || cantidadJugadores > 4) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número entre 1 y 4.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        for (int i = 0; i < cantidadJugadores; i++) {
            String nombreJugador = JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador " + (i + 1) + ":", "Ingreso de Jugador", JOptionPane.INFORMATION_MESSAGE);
            DatoJugador dato = new DatoJugador(nombreJugador);
            jugadores.encolar(dato);
            JOptionPane.showMessageDialog(null, "Jugador '" + nombreJugador + "' agregado a la cola.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        }

        String listaCompleta = jugadores.toString();
        JOptionPane.showMessageDialog(null, listaCompleta, "Lista Final de Jugadores", JOptionPane.INFORMATION_MESSAGE);

        int posicionMaxima = 0;
        while (posicionMaxima <= 0) {
            String inputPosicion = JOptionPane.showInputDialog(null, "Ingrese la posición máxima del laberinto:", "Configuración del Juego", JOptionPane.QUESTION_MESSAGE);
            posicionMaxima = Integer.parseInt(inputPosicion);
            if (posicionMaxima <= 0) {
                JOptionPane.showMessageDialog(null, "La posición máxima debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        String inputPermitir = JOptionPane.showInputDialog(null, "¿Permitir el ingreso de más jugadores? (S/N):", "Configuración del Juego", JOptionPane.QUESTION_MESSAGE);
        boolean permitirNuevosJugadores = inputPermitir.equalsIgnoreCase("S");

        PilaPremios pilaPremios = new PilaPremios();
        PilaCastigo pilaCastigos = new PilaCastigo();

        


        // Premios
        pilaPremios.encolar('+', 2, "Avanza 2 posiciones.");
        pilaPremios.encolar('+', 8, "Avanza 8 posiciones.");
        pilaPremios.encolar('+', 0, "Avanza 0 posiciones.");
        //pilaPremios.desencolar();

        // Castigos
        pilaCastigos.encolar('-', 3, "Retrocede 3 posiciones.");
        pilaCastigos.encolar('=', 1, "Vuelves a la casilla 1.");
        pilaCastigos.encolar('-', 5, "Retrocede 5 posiciones.");
        
        //demostracion de premios y mantenimiento
        JOptionPane.showMessageDialog(null, pilaPremios.toString(), "Mantenimiento de Pilas", JOptionPane.INFORMATION_MESSAGE);
        
        //chat del bot carga de datos
        ArbolChatBot arbolChatBot = new ArbolChatBot();
        arbolChatBot.agregarNodo("1", "Juego");
        arbolChatBot.agregarNodo("1", "Reglas");
        arbolChatBot.agregarPregunta("1-1", new Pregunta("¿Cómo jugar?", "Instrucciones de juego", "Tira los dados y avanza."));
        arbolChatBot.agregarPregunta("1-2", new Pregunta( "¿Cuales son las reglas?", "Toma de premios o castigos","Siempre debes tomar un premio o castigo... Suerte con ello :)" ));
        
        
        
        JOptionPane.showMessageDialog(null, pilaCastigos.toString(), "Mantenimiento de Pilas", JOptionPane.INFORMATION_MESSAGE);
        //iniciador del menu donde se gestionara el juego
        MenuJuego menu1 = new MenuJuego(jugadores,pilaPremios,pilaCastigos, posicionMaxima, permitirNuevosJugadores, arbolChatBot);
        menu1.mostrarMenu();
        
    }
}
