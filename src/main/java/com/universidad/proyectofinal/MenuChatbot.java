/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;

import javax.swing.JOptionPane;

/**
 *
 * @author AMD
 */
public class MenuChatbot {
    private ArbolFAQ arbol;
    private MenuJuego menuJuego;

    public MenuChatbot(MenuJuego menuJuego) {
    this.menuJuego = menuJuego;
    arbol = new ArbolFAQ();
    precargarArbol();
}

    
    private void precargarArbol() {
    arbol.insertarNodo("11", "Preguntas para jugadores");
    arbol.insertarNodo("111", "Primera vez que juego");
    arbol.insertarNodo("1111", "Soy nuevo en videojuegos");
    arbol.insertarNodo("1112", "Ya he jugado otros juegos similares");

    NodoFAQ hoja = arbol.buscar("1111");
    hoja.preguntas = new ListaPreguntas();
    hoja.preguntas.insertar("P1",
        "¿Cuántos jugadores pueden participar?",
        "Se permite un máximo de 4 jugadores.");
}

/*
 * Permite al usuario navegar por el chatbot FAQ
 * usando un árbol binario y mostrando preguntas en las hojas
 */
/*
 * Permite al usuario navegar por el chatbot de forma amigable,
 * sin mostrar códigos internos del sistema.
 */
private void verChatbot() {

    JOptionPane.showMessageDialog(null,
            "¡Bienvenido al Chatbot de Preguntas Frecuentes!\n" +
            "Seleccione una opción para continuar.");

    NodoFAQ actual = arbol.raiz;
    NodoFAQ anterior = null;
    boolean salir = false;

    while (!salir) {

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Categoría actual:\n");
        mensaje.append(actual.nombre).append("\n\n");
        mensaje.append("Seleccione una opción:\n");

        int opcionMenu = 1;

        // Guardamos las opciones visibles
        NodoFAQ opcionIzquierda = null;
        NodoFAQ opcionDerecha = null;

        // Mostrar subcategorías (si existen)
        if (actual.izquierdo != null) {
            mensaje.append(opcionMenu)
                   .append(". ")
                   .append(actual.izquierdo.nombre)
                   .append("\n");
            opcionIzquierda = actual.izquierdo;
            opcionMenu++;
        }

        if (actual.derecho != null) {
            mensaje.append(opcionMenu)
                   .append(". ")
                   .append(actual.derecho.nombre)
                   .append("\n");
            opcionDerecha = actual.derecho;
            opcionMenu++;
        }

        // Mostrar preguntas SOLO si es hoja
        int inicioPreguntas = opcionMenu;

        if (actual.esHoja() && actual.preguntas != null) {
            mensaje.append("\nPreguntas disponibles:\n");

            Pregunta p = actual.preguntas.getPrimero();
            while (p != null) {
                mensaje.append(opcionMenu)
                       .append(". ")
                       .append(p.pregunta)
                       .append("\n");
                opcionMenu++;
                p = p.siguiente;
            }
        }

        // Opciones fijas
        mensaje.append("\n0. Regresar");
        mensaje.append("\n9. Salir");

        String opcionTxt = JOptionPane.showInputDialog(mensaje.toString());

        if (opcionTxt == null || opcionTxt.equals("9")) {
            JOptionPane.showMessageDialog(null,
                    "Gracias por usar el chatbot.\n¡Hasta luego!");
            salir = true;
        }
        else if (opcionTxt.equals("0")) {
            if (anterior != null) {
                actual = anterior;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Ya se encuentra en el menú principal.");
            }
        }
        else {
            try {
    int opcion = Integer.parseInt(opcionTxt);

    // Opción 1: primer submenú disponible
    if (opcion == 1) {
        if (opcionIzquierda != null) {
            anterior = actual;
            actual = opcionIzquierda;
        } else {
            JOptionPane.showMessageDialog(null,
                    "No hay opciones disponibles.");
        }
    }
    // Opción 2: segundo submenú (si existe)
    else if (opcion == 2) {
        if (opcionDerecha != null) {
            anterior = actual;
            actual = opcionDerecha;
        } else {
            JOptionPane.showMessageDialog(null,
                    "No hay más opciones.");
        }
    }
    // Preguntas (solo si es hoja)
    else if (actual.esHoja() && actual.preguntas != null
            && opcion >= inicioPreguntas) {
        mostrarRespuesta(actual, opcion, inicioPreguntas);
    }
     else {
        JOptionPane.showMessageDialog(null,
         "Opción inválida, intente nuevamente.");
           }

           } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(null,
             "Por favor ingrese un número válido.");
           }
        }
    }
}


/*
 * Muestra la respuesta de una pregunta seleccionada
 */
private void mostrarRespuesta(NodoFAQ nodo, int opcion, int inicioPreguntas) {

    int indice = opcion - inicioPreguntas;
    int contador = 0;

    Pregunta p = nodo.preguntas.getPrimero();

    while (p != null) {
        if (contador == indice) {
            JOptionPane.showMessageDialog(null,
                    "❓ Pregunta:\n" + p.pregunta +
                    "\n\n✅ Respuesta:\n" + p.respuesta);
            return;
        }
        contador++;
        p = p.siguiente;
    }

    JOptionPane.showMessageDialog(null,
            "No se encontró la pregunta seleccionada.");
}


    /*
 * Menú de mantenimiento del chatbot
 */
private void mantenimiento() {
    int opcion = 0;

    while (opcion != 6) {
        opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "=== MANTENIMIENTO CHATBOT ===\n"
              + "1. Insertar nodo padre\n"
              + "2. Insertar pregunta\n"
              + "3. Eliminar pregunta\n"
              + "4. Imprimir preguntas de un nodo\n"
              + "5. Ver estructura del árbol\n"
              + "6. Volver"
        ));

        if (opcion == 1) {
            insertarNodo();
        } else if (opcion == 2) {
            insertarPregunta();
        } else if (opcion == 3) {
            eliminarPregunta();
        } else if (opcion == 4) {
            imprimirPreguntasNodo();
        } else if (opcion == 5) {
            mostrarArbol(arbol.raiz, "");
        } else if (opcion == 6) {
            JOptionPane.showMessageDialog(null, "Saliendo del mantenimiento...");
        } else {
            JOptionPane.showMessageDialog(null, "Opción inválida");
        }
    }
}

/*
 * Inserta un nuevo nodo en el árbol binario
 */
private void insertarNodo() {
    String codigo = JOptionPane.showInputDialog("Ingrese el código del nodo:");
    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del nodo:");

    if (codigo == null || nombre == null) {
        JOptionPane.showMessageDialog(null, "Datos incompletos.");
        return;
    }

    if (arbol.buscar(codigo) != null) {
        JOptionPane.showMessageDialog(null, "Ya existe un nodo con ese código.");
        return;
    }

    arbol.insertarNodo(codigo, nombre);
    JOptionPane.showMessageDialog(null, "Nodo insertado correctamente.");
}

/*
 * Inserta una pregunta solo si el nodo es hoja
 */
private void insertarPregunta() {
    String codigoNodo = JOptionPane.showInputDialog("Código del nodo hoja:");
    NodoFAQ nodo = arbol.buscar(codigoNodo);

    if (nodo == null) {
        JOptionPane.showMessageDialog(null, "Nodo no encontrado.");
        return;
    }

    if (!nodo.esHoja()) {
        JOptionPane.showMessageDialog(null,
                "ERROR: Solo los nodos hoja pueden tener preguntas.");
        return;
    }

    String codigo = JOptionPane.showInputDialog("Código de la pregunta:");
    String texto = JOptionPane.showInputDialog("Pregunta:");
    String respuesta = JOptionPane.showInputDialog("Respuesta:");

    if (nodo.preguntas == null) {
        nodo.preguntas = new ListaPreguntas();
    }

    nodo.preguntas.insertar(codigo, texto, respuesta);
    JOptionPane.showMessageDialog(null, "Pregunta agregada correctamente.");
}

/*
 * Elimina una pregunta de un nodo hoja
 */
private void eliminarPregunta() {
    String codigoNodo = JOptionPane.showInputDialog("Código del nodo hoja:");
    NodoFAQ nodo = arbol.buscar(codigoNodo);

    if (nodo == null || nodo.preguntas == null) {
        JOptionPane.showMessageDialog(null, "Nodo o preguntas no existen.");
        return;
    }

    String codigoPregunta = JOptionPane.showInputDialog("Código de la pregunta:");
    boolean eliminado = nodo.preguntas.eliminar(codigoPregunta);

    if (eliminado) {
        JOptionPane.showMessageDialog(null, "Pregunta eliminada.");
    } else {
        JOptionPane.showMessageDialog(null, "Pregunta no encontrada.");
    }
}

/*
 * Muestra las preguntas de un nodo hoja
 */
private void imprimirPreguntasNodo() {
    String codigoNodo = JOptionPane.showInputDialog("Código del nodo hoja:");
    NodoFAQ nodo = arbol.buscar(codigoNodo);

    if (nodo == null || nodo.preguntas == null || nodo.preguntas.estaVacia()) {
        JOptionPane.showMessageDialog(null, "Este nodo no tiene preguntas.");
        return;
    }

    String texto = "Preguntas del nodo " + nodo.nombre + ":\n\n";
    Pregunta p = nodo.preguntas.getPrimero();

    while (p != null) {
        texto += "- " + p.pregunta + "\n";
        p = p.siguiente;
    }

    JOptionPane.showMessageDialog(null, texto);
}

/*
 * Muestra el árbol en forma de texto (preorden)
 */
private void mostrarArbol(NodoFAQ nodo, String nivel) {
    if (nodo != null) {
        JOptionPane.showMessageDialog(null, nivel + nodo.codigo + " - " + nodo.nombre);
        mostrarArbol(nodo.izquierdo, nivel + "   ");
        mostrarArbol(nodo.derecho, nivel + "   ");
    }
}

/*
 * Menú principal del Chatbot
 * Este método es el que se llama desde MenuJuego
 */
public void mostrarMenuChatbot() {

    int opcion = 0;

    while (opcion != 3) {

        opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "===== CHATBOT FAQ =====\n"
              + "1. Ver Chatbot (Usuarios)\n"
              + "2. Mantenimiento (Administrador)\n"
              + "3. Volver al menú del juego"
        ));

        if (opcion == 1) {
            verChatbot();          // navegación
        } 
        else if (opcion == 2) {
            mantenimiento();      // mantenimiento
        } 
        else if (opcion == 3) {
            JOptionPane.showMessageDialog(null, "Regresando al menú del juego...");
            menuJuego.mostrarMenu();  // 👈 vuelve a mostrar TODO el menú del juego
            return;
        } 
        else {
            JOptionPane.showMessageDialog(null, "Opción inválida.");
        }
    }
}



}