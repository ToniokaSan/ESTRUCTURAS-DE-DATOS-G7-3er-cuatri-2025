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

        // Nivel 1
        // Raíz ya creada: "1" - "Preguntas Frecuentes (FAQ)"
        // Nivel 2
        arbolChatBot.agregarNodo("1", "Preguntas para jugadores"); // "11"
        arbolChatBot.agregarNodo("1", "Preguntas para administradores"); // "12"

        // Nivel 3
        arbolChatBot.agregarNodo("11", "Primera vez que juego"); // "111"
        arbolChatBot.agregarNodo("11", "Jugador Experimentado"); // "112"
        arbolChatBot.agregarNodo("12", "Funcionalidades"); // "121"
        arbolChatBot.agregarNodo("12", "Mejorar Juego"); // "122"

        // Nivel 4 (hojas)
        arbolChatBot.agregarNodo("111", "Soy nuevo en videojuegos"); // "1111"
        arbolChatBot.agregarNodo("112", "Ya he jugado otros juegos similares"); // "1121"
        arbolChatBot.agregarNodo("121", "Administrador preguntas"); // "1211"
        // "122" puede quedar hoja si no tiene subniveles

        // Preguntas (solo en hojas)
        arbolChatBot.agregarPregunta("1111", new Pregunta("¿Cuántos jugadores pueden participar simultáneamente?", "Cantidad de jugadores", "Se tiene un máximo de 4 jugadores."));
        arbolChatBot.agregarPregunta("1111", new Pregunta("¿Hay un tiempo máximo por partida?", "Tiempo máximo", "No, el juego termina cuando un jugador alcance la posición máxima."));
        arbolChatBot.agregarPregunta("1121", new Pregunta("¿Puedo jugar en línea?", "Juego en línea", "No, en la versión liberada no se permite jugar en línea."));
        arbolChatBot.agregarPregunta("1121", new Pregunta("Si hay un ganador, ¿los demás jugadores pueden continuar?", "Continuación del juego", "Sí, no hay restricción que les impida continuar."));
        arbolChatBot.agregarPregunta("1211", new Pregunta("¿Hay una comunidad de jugadores?", "Comunidad", "No, pero es una excelente idea. Te invito a fundarla."));
        arbolChatBot.agregarPregunta("1211", new Pregunta("¿En qué lenguaje fue implementado?", "Lenguaje del juego", "El juego fue implementado en JAVA."));
        arbolChatBot.agregarPregunta("1211", new Pregunta("¿Cuándo liberan una nueva versión?", "Nueva versión", "Esperamos liberar una nueva versión en diciembre de 2025."));


        /*
        ArbolChatBot arbolChatBot = new ArbolChatBot();
        arbolChatBot.agregarNodo("1", "Juego");
        arbolChatBot.agregarNodo("1", "Reglas");
        arbolChatBot.agregarPregunta("1-1", new Pregunta("¿Cómo jugar?", "Instrucciones de juego", "Tira los dados y avanza."));
        arbolChatBot.agregarPregunta("1-2", new Pregunta( "¿Cuales son las reglas?", "Toma de premios o castigos","Siempre debes tomar un premio o castigo... Suerte con ello :)" ));
        */
        
        
        JOptionPane.showMessageDialog(null, pilaCastigos.toString(), "Mantenimiento de Pilas", JOptionPane.INFORMATION_MESSAGE);
        //iniciador del menu donde se gestionara el juego
        MenuJuego menu1 = new MenuJuego(jugadores,pilaPremios,pilaCastigos, posicionMaxima, permitirNuevosJugadores, arbolChatBot);
        menu1.mostrarMenu();
        
    }
}
