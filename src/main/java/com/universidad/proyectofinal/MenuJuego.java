/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universidad.proyectofinal;
import javax.swing.JOptionPane;
/**
 *
 * @author potoy
 */

public class MenuJuego {
    // para traer los objetos que ya inicializo naty en el m ain y trabajarlos aca

    private preparadosListosCola jugadores;
    private PilaPremios pilaPremios;
    private PilaCastigo pilaCastigos;
    
    //fin de los objetos inicializados por naty
    
    //constructor para que los reconozca
    public MenuJuego(preparadosListosCola jugadores, PilaPremios pilaPremios, PilaCastigo pilaCastigos) {
        this.jugadores = jugadores;
        this.pilaPremios = pilaPremios;
        this.pilaCastigos = pilaCastigos;
    } // fin del constructor que reconoce
    
    
    
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
                    + "\n7.Opcion no dispinible "
                    + "\n8.Opcion no dispinible "
                    + "\n9.Opcion no dispinible"
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
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "Cerrando programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida, intente de nuevo.");
            }
        } while (opcion != 10);
    }
    public void menuJugar(){
        int opcion;
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "----------Jugar MVP----------\n"
                    +"\n1. Iniciar juego de los participantes"
                    +"\n2.Ver lista de posiciones "
                    +"\n3. Eliminar jugador de la cola MVP"
                    +"\n4. Ayuda"
                    +"\n5. Volver al menu principal"
            
            
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
                                                         + "\nAnthony Potoy Aleman"+ "\nSebastian Alvarez Murillo"+ "\nArianna Rodriguez Badilla"+ "\nAnthony Potoy Aleman");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida, intente de nuevo.");
                    
            }
        } while(opcion != 5);
        
    }
    
    public void jugar(){
        //inicio del juego
        if (!jugadores.estaVacia()){
            JOptionPane.showMessageDialog(null, "Iniciando ronda...");
            
            Dato jugadorActual = null;
            try {
                jugadorActual = jugadores.desencolar();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                return;
            }
            //lanzamiento de los dados
            int dado1 = (int) (Math.random() * 6) + 1;
            JOptionPane.showMessageDialog(null, "Primer dado lanzado, resultado: " + dado1);
            
            int dado2 = (int) (Math.random() * 6) + 1;
            JOptionPane.showMessageDialog(null, "Segundo dado lanzado, resultado: " + dado2);
            
            int sumaDados = dado1 + dado2; //suma de los dados
            
            int nuevaPosicion = jugadorActual.getPosicion() + sumaDados;
            jugadorActual.setPosicion(nuevaPosicion);
            
            JOptionPane.showMessageDialog(null,
                    "\nJugador: "+ jugadorActual.getValor()
                    + "\nEstas en la posicion: " + (nuevaPosicion - sumaDados)
                    + "\nPuedes avanzar: "+ sumaDados + " posiciones en la carrera"
                    + "\nAhora su nueva posicion es: "+ nuevaPosicion
            
            );
            //inicio de premio premio o castigo 
            if (sumaDados % 2 == 0){
                
                JOptionPane.showMessageDialog(null, "Obtuviste un numero par, debes tomar un premio de la pila. \nMucha Suerte");
                DatoPremio premioObtenido = null;
                
                try{
                    premioObtenido = pilaPremios.desencolar();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No hay premios disponibles");
                }
                
                //aparicion de premios
                if (premioObtenido != null){
                    JOptionPane.showMessageDialog(null,
                            "El premio es: " + premioObtenido.getDescripcion()
                            + "\nSe aplicará su premio: " + premioObtenido.getOperacion() + premioObtenido.getNumero()
                    
                    );
                    if (premioObtenido.getOperacion() == '+') {
                        jugadorActual.setPosicion(jugadorActual.getPosicion() + premioObtenido.getNumero());
                    } else if (premioObtenido.getOperacion() == '-') {
                        jugadorActual.setPosicion(jugadorActual.getPosicion() - premioObtenido.getNumero());
                    } else if (premioObtenido.getOperacion() == '=') {
                        jugadorActual.setPosicion(premioObtenido.getNumero());
                    }
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Ya no hay premios disponibles");
                }

                JOptionPane.showMessageDialog(null, "Ahora su posicion colocada es: " + jugadorActual.getPosicion());
                
            }else{//aqui empiezan los castigos
                if (sumaDados % 2 == 1){
                
                JOptionPane.showMessageDialog(null, "Obtuviste un numero impar, debes tomar un castigo de la pila. \nMucha Suerte");
                DatoCastigo castigoObtenido = null;
                
                try{
                    castigoObtenido = pilaCastigos.desencolar();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No hay castigos disponibles");
                }
                
                //aparicion de castigos
                if (castigoObtenido != null){
                    JOptionPane.showMessageDialog(null,
                            "El castigo es: " + castigoObtenido.getDescripcion()
                            + "\nSe aplicará su castigo: " + castigoObtenido.getOperacion() + castigoObtenido.getNumero()
                    
                    );
                    if (castigoObtenido.getOperacion() == '+') {
                        jugadorActual.setPosicion(jugadorActual.getPosicion() + castigoObtenido.getNumero());
                    } else if (castigoObtenido.getOperacion() == '-') {
                        jugadorActual.setPosicion(jugadorActual.getPosicion() - castigoObtenido.getNumero());
                    } else if (castigoObtenido.getOperacion() == '=') {
                        jugadorActual.setPosicion(castigoObtenido.getNumero());
                    }
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Ya no hay castigos disponibles");
                }

                JOptionPane.showMessageDialog(null, "Ahora su posicion colocada es: " + jugadorActual.getPosicion()); 
                }
            }
            jugadores.encolar(jugadorActual);
            
        }else{ //else de los jugadores si esta vacio, tira esto
            JOptionPane.showMessageDialog(null, "No hay jugadores en la cola de preparados");
        }
    }// fin del metodo jugar
    
}// fin de la clase 
