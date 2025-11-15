/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;
import javax.swing.JOptionPane;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Clase que permite visualizar el menu principal y secundario del juego MVP donde se encuentra
 * la mayor parte de la logica de metodos como agregar y jugar.
 * Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */

public class MenuJuego {
    // para traer los objetos que ya inicializo naty en el m ain y trabajarlos aca

    private preparadosListosCola jugadores;
    private PilaPremios pilaPremios;
    private PilaCastigo pilaCastigos;
    private int posicionMaxima;
    private boolean permitirNuevosJugadores;
    private Bitacora bitacora; // bitácora (texto simple)
    private ListaJugadoresBitacora listaJugadoresHist; // lista doble circular con lista interna de posiciones
    private ListaEstadoCircular estadoJuego; // lista circular con posiciones 1..N
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //fin de los objetos inicializados por naty
    
    /**
     * Constructor que permite extraer los elementos ya inicializados en el main
     * @param jugadores Cola de jugadores
     * @param pilaPremios Pila de premios
     * @param pilaCastigos Pila de castigos
     */
    public MenuJuego(preparadosListosCola jugadores, PilaPremios pilaPremios, PilaCastigo pilaCastigos, int posicionMaxima, boolean permitirNuevosJugadores) {
        this.jugadores = jugadores;
        this.pilaPremios = pilaPremios;
        this.pilaCastigos = pilaCastigos;
        this.posicionMaxima = posicionMaxima;
        this.permitirNuevosJugadores = permitirNuevosJugadores;
        this.bitacora = new Bitacora();
        this.listaJugadoresHist = new ListaJugadoresBitacora();
        this.estadoJuego = new ListaEstadoCircular();
        this.estadoJuego.inicializar(Math.max(1, posicionMaxima));
        // Registrar jugadores existentes en la cola dentro de la bitácora (orden alfabético) con posición inicial
        Nodo actual = jugadores.getFrente();
        while (actual != null) {
            DatoJugador dj = actual.getNombreJugador();
            if (dj != null) {
                NodoJugadorHist node = listaJugadoresHist.insertarOObtener(dj.getValor());
                node.getHistorial().agregar(dj.getPosicion(), new Date(), "Posición <<" + dj.getPosicion() + ">> inicial");
                // si la posición está dentro del rango, ubicar en estadoJuego
                if (dj.getPosicion() >= 1 && dj.getPosicion() <= this.posicionMaxima) {
                    estadoJuego.colocarJugadorEnPosicion(dj.getPosicion(), dj.getValor());
                }
            }
            actual = actual.getSiguiente();
        }
        bitacora.agregar(timeStamp() + " - MenuJuego inicializado. PosicionMaxima=" + posicionMaxima + ", permitirNuevosJugadores=" + (permitirNuevosJugadores?"S":"N"));
    } // fin del constructor que reconoce

    private String timeStamp() {
        return LocalDateTime.now().format(dtf);
    }

    /**
     * Menu principal del proyecto MVP, donde permite ejecutar la opcion jugar, mantenimiento de premios
     * y castigos ademas de futuras implementaciones.
     */
    public void mostrarMenu() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "..........Menu de Juego.........."
                    + "\n1. Jugar MVP"
                    + "\n2. Ver jugadores"
                    + "\n3. Ver lista de premios"
                    + "\n4. Mantenimiento de premios"
                    + "\n5. Ver lista de castigos"
                    + "\n6. Mantenimiento de castigos"
                    + "\n7. Agregar Jugador"
                    + "\n8. Estado actual del Juego"
                    + "\n9. Bitacora-Historial"
                    + "\n10. Cerrar programa"
            ));
            switch (opcion) {
                case 1: 
                    menuJugar();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, jugadores.toString(), "Lista de Jugadores", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, pilaPremios.toString(), "Pila de Premios", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4:
                    new MantenimientoPilaPremio(pilaPremios).menuPilaPremio();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, pilaCastigos.toString(), "Pila de Castigos", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 6:
                    new MantenimientoPilaCastigo(pilaCastigos).menuPilaCastigo();
                    break;
                case 7:
                    if (permitirNuevosJugadores) {
                        String nombreJugador = JOptionPane.showInputDialog(null, "Ingrese el nombre del nuevo jugador:", "Adicionar Jugador", JOptionPane.INFORMATION_MESSAGE);
                        if (nombreJugador != null && !nombreJugador.trim().isEmpty()) {
                            DatoJugador dato = new DatoJugador(nombreJugador);
                            jugadores.encolar(dato);
                            // registrar en la lista de jugadores de la bitacora (si no existe lo crea)
                            NodoJugadorHist node = listaJugadoresHist.insertarOObtener(nombreJugador);
                            // añadir una posición inicial (por ejemplo posición actual 0 sin castigo/premio)
                            node.getHistorial().agregar(0, new Date(), "Posición <<0>> no tiene castigos/premios");
                            bitacora.agregar(timeStamp() + " - Jugador agregado: " + nombreJugador);
                            JOptionPane.showMessageDialog(null, "Jugador '" + nombreJugador + "' agregado a la cola.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "El nombre del jugador no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se permite el ingreso de nuevos jugadores en esta partida.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, estadoJuego.toString(), "Estado del Juego", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 9:
                    // mostrar bitácora completa con la lista doble circular (jugadores y sus historiales)
                    JOptionPane.showMessageDialog(null, listaJugadoresHist.toString(), "Bitácora - Historial", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "Cerrando programa");
                    bitacora.agregar(timeStamp() + " - Programa cerrado por el usuario");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida, intente de nuevo.");
            }
        } while (opcion != 10);
    }
    
    /**
     * Muestra el submeno de jugar, donde permite iniciar el jeugo de las jugadores
     * ademas de las opciones de ver jugadores, eliminar jugadores y la opcion ayuda.
     */
    public void menuJugar(){
        int opcion;
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "----------Jugar MVP----------\n"
                    + "\n1. Iniciar juego de los participantes"
                    + "\n2.Ver lista de posiciones "
                    + "\n3. Eliminar jugador de la cola MVP"
                    + "\n4. Ayuda"
                    + "\n5. Volver al menu principal"

            ));
            switch (opcion){
                case 1:
                    jugar();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, jugadores.toString(), "Lista de Jugadores", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    //aqui pedimos el nombre con JOption para llamar al metodo eliminarJugador y poder comparar lo que ingreso el usuario
                     String nombreEliminar = JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador que desea eliminar:");
                         //aqui verificamos que el usuario no haya cancelado la accion o que no haya puesto nada y si es asi llamamos al metodo
                         if (nombreEliminar != null && !nombreEliminar.isEmpty()) {
                              boolean eliminado = jugadores.eliminarJugador(nombreEliminar);
                         if (eliminado) {
                             bitacora.agregar(timeStamp() + " - Jugador eliminado: " + nombreEliminar);
                             JOptionPane.showMessageDialog(null, "El jugador '" + nombreEliminar + "' ha sido eliminado del juego.");
                         } else {
                             JOptionPane.showMessageDialog(null, "No se encontró ningún jugador con el nombre '" + nombreEliminar + "'.");
                             }
                         } else {
                             JOptionPane.showMessageDialog(null, "Debe ingresar un nombre válido.");
                             }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Informacion" + "\nVersion del juego: V 1.0.1." 
                                                         +"\nDesarrolladores: " 
                                                         + "\nAnthony Potoy Aleman"+ "\nSebastian Alvarez Murillo"+ "\nArianna Rodriguez Badilla"+ "\nNatalie Barboza Garcia");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida, intente de nuevo.");
                    
            }
        } while(opcion != 5);
        
    }

    /**
     * Metodo principal que permite ejecutar la logica del juego donde se lanzaran dos dados por rondas
     * dependiendo de su resultado se aplicará premio o castigo al jugador afectando su posicion.
     */
    public void jugar(){
        //inicio del juego
        if (!jugadores.estaVacia()){
            JOptionPane.showMessageDialog(null, "Iniciando ronda...");
            bitacora.agregar(timeStamp() + " - Inicio de ronda. Jugadores en cola: " + jugadores.cantidad());

            DatoJugador jugadorActual = null;
            try {
                jugadorActual = jugadores.desencolar();
                bitacora.agregar(timeStamp() + " - Se desencola al jugador: " + jugadorActual.getValor());
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                bitacora.agregar(timeStamp() + " - Error al desencolar jugador: " + e.getMessage());
                return;
            }
            //lanzamiento de los dados
            int dado1 = (int) (Math.random() * 6) + 1;
            JOptionPane.showMessageDialog(null, "Primer dado lanzado, resultado: " + dado1);
            bitacora.agregar(timeStamp() + " - Dado1: " + dado1);

            int dado2 = (int) (Math.random() * 6) + 1;
            JOptionPane.showMessageDialog(null, "Segundo dado lanzado, resultado: " + dado2);
            bitacora.agregar(timeStamp() + " - Dado2: " + dado2);

            int sumaDados = dado1 + dado2; //suma de los dados
            bitacora.agregar(timeStamp() + " - Suma de dados: " + sumaDados);

            int nuevaPosicion = jugadorActual.getPosicion() + sumaDados;
            jugadorActual.setPosicion(nuevaPosicion);
            
            JOptionPane.showMessageDialog(null,
                    "\nJugador: "+ jugadorActual.getValor()
                    + "\nEstas en la posicion: " + (nuevaPosicion - sumaDados)
                    + "\nPuedes avanzar: "+ sumaDados + " posiciones en la carrera"
                    + "\nAhora su nueva posicion es: "+ nuevaPosicion
            
            );
            String descripcionMovimiento = "Posición <<" + nuevaPosicion + ">> no tiene castigos/premios";
            //inicio de premio premio o castigo
            if (sumaDados % 2 == 0){
                
                JOptionPane.showMessageDialog(null, "Obtuviste un numero par, debes tomar un premio de la pila. \nMucha Suerte");
                bitacora.agregar(timeStamp() + " - Evento: premio por suma par. Jugador: " + jugadorActual.getValor());
                DatoPremio premioObtenido = null;
                
                try{
                    premioObtenido = pilaPremios.desencolar();
                    bitacora.agregar(timeStamp() + " - Se obtiene premio: " + (premioObtenido!=null? premioObtenido.getDescripcion():"(null)"));
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No hay premios disponibles");
                    bitacora.agregar(timeStamp() + " - Intento de obtener premio pero no hay disponibles: " + e.getMessage());
                }
                
                //aparicion de premios
                if (premioObtenido != null){
                    JOptionPane.showMessageDialog(null,
                            "El premio es: " + premioObtenido.getDescripcion()
                            + "\nSe aplicará su premio: " + premioObtenido.getOperacion() + premioObtenido.getNumero()
                    
                    );
                    bitacora.agregar(timeStamp() + " - Aplicando premio: " + premioObtenido.getOperacion() + premioObtenido.getNumero() + " al jugador " + jugadorActual.getValor());
                    if (premioObtenido.getOperacion() == '+') {
                        jugadorActual.setPosicion(jugadorActual.getPosicion() + premioObtenido.getNumero());
                    } else if (premioObtenido.getOperacion() == '-') {
                        jugadorActual.setPosicion(jugadorActual.getPosicion() - premioObtenido.getNumero());
                    } else if (premioObtenido.getOperacion() == '=') {
                        jugadorActual.setPosicion(premioObtenido.getNumero());
                    }
                    descripcionMovimiento = premioObtenido.getDescripcion() + " (" + premioObtenido.getOperacion() + premioObtenido.getNumero() + ")";
                }else{
                    JOptionPane.showMessageDialog(null, "Ya no hay premios disponibles");
                    descripcionMovimiento = "Posición <<" + jugadorActual.getPosicion() + ">> no tiene castigos/premios";
                }

                JOptionPane.showMessageDialog(null, "Ahora su posicion colocada es: " + jugadorActual.getPosicion());
                bitacora.agregar(timeStamp() + " - Posicion final del jugador " + jugadorActual.getValor() + ": " + jugadorActual.getPosicion());

            }else{//aqui empiezan los castigos
                if (sumaDados % 2 == 1){
                
                JOptionPane.showMessageDialog(null, "Obtuviste un numero impar, debes tomar un castigo de la pila. \nMucha Suerte");
                bitacora.agregar(timeStamp() + " - Evento: castigo por suma impar. Jugador: " + jugadorActual.getValor());
                DatoCastigo castigoObtenido = null;
                
                try{
                    castigoObtenido = pilaCastigos.desencolar();
                    bitacora.agregar(timeStamp() + " - Se obtiene castigo: " + (castigoObtenido!=null? castigoObtenido.getDescripcion():"(null)"));
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No hay castigos disponibles");
                    bitacora.agregar(timeStamp() + " - Intento de obtener castigo pero no hay disponibles: " + e.getMessage());
                }
                
                //aparicion de castigos
                if (castigoObtenido != null){
                    JOptionPane.showMessageDialog(null,
                            "El castigo es: " + castigoObtenido.getDescripcion()
                            + "\nSe aplicará su castigo: " + castigoObtenido.getOperacion() + castigoObtenido.getNumero()
                    
                    );
                    bitacora.agregar(timeStamp() + " - Aplicando castigo: " + castigoObtenido.getOperacion() + castigoObtenido.getNumero() + " al jugador " + jugadorActual.getValor());
                    if (castigoObtenido.getOperacion() == '+') {
                        jugadorActual.setPosicion(jugadorActual.getPosicion() + castigoObtenido.getNumero());
                    } else if (castigoObtenido.getOperacion() == '-') {
                        jugadorActual.setPosicion(jugadorActual.getPosicion() - castigoObtenido.getNumero());
                    } else if (castigoObtenido.getOperacion() == '=') {
                        jugadorActual.setPosicion(castigoObtenido.getNumero());
                    }
                    descripcionMovimiento = castigoObtenido.getDescripcion() + " (" + castigoObtenido.getOperacion() + castigoObtenido.getNumero() + ")";

                    
                }else{
                    JOptionPane.showMessageDialog(null, "Ya no hay castigos disponibles");
                    descripcionMovimiento = "Posición <<" + jugadorActual.getPosicion() + ">> no tiene castigos/premios";
                }

                JOptionPane.showMessageDialog(null, "Ahora su posicion colocada es: " + jugadorActual.getPosicion()); 
                bitacora.agregar(timeStamp() + " - Posicion final del jugador " + jugadorActual.getValor() + ": " + jugadorActual.getPosicion());
                }
            }

            if (jugadorActual.getPosicion() >= posicionMaxima) {
                JOptionPane.showMessageDialog(null, "¡Felicidades " + jugadorActual.getValor() + "! ¡Has ganado el juego!", "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
                bitacora.agregar(timeStamp() + " - Jugador ganador: " + jugadorActual.getValor() + ", posicion: " + jugadorActual.getPosicion());
                // Here we could end the game, but for now we just put the player back.
            }

            // registrar movimiento en el historial del jugador (lista doble circular)
            NodoJugadorHist nodoHistorial = listaJugadoresHist.buscar(jugadorActual.getValor());
            if (nodoHistorial != null) {
                nodoHistorial.getHistorial().agregar(jugadorActual.getPosicion(), new Date(), descripcionMovimiento);
            }
            // actualizar estado en la lista de estado circular
            estadoJuego.actualizarPosicion(jugadorActual.getValor(), jugadorActual.getPosicion());
            jugadores.encolar(jugadorActual);
            bitacora.agregar(" - Jugador reingresado a la cola: " + jugadorActual.getValor());

        }else{ //else de los jugadores si esta vacio, tira esto
            JOptionPane.showMessageDialog(null, "No hay jugadores en la cola de preparados");
            bitacora.agregar(" - Intento de iniciar ronda pero no hay jugadores en la cola");
        }
    }// fin del metodo jugar
    
}// fin de la clase
