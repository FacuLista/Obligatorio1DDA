package Principal;

import java.util.*; // es uno de los paquetes que nos permite agregar uno o varias clases(paquete) estructuras de datos genericas segun
// lo necesitemos y otras cosas

import clases.*;
import Principal.Cambios;

public class Principal {
    // Se genera la listaArbitral, el EquipoLocal y el EquipoVisitante, siendo estos últimos provenientes de Equipo
    static List<Arbitro> listaArbitral = new ArrayList();
    static Equipo EquipoLocal = new Equipo();
    static Equipo EquipoVisitante = new Equipo();
    public static String equipoLocal = "";
    public static String equipoVisitante = "";

    public static void main(String[] args) {        //El main llama al método partido e inicia.
        Scanner scanner = new Scanner(System.in);
        partido();
    }

    public static void partido() {
        Scanner scanner = new Scanner(System.in);
        boolean partido = false;    // Se crean tres variables de tipo boolean igualadas a false
        boolean jugadores = false;
        boolean arbitraje = false;
        System.out.println("Ingrese el Equipo Local");      // Se pide que se ingrese el equipo local y se va a guardar en el dato equipoLocal
        equipoLocal = scanner.nextLine();
        System.out.println("Ingrese el Equipo Visitante");  // Se pide que se ingrese el equipo visitante y se va a guardar en el dato equipoVisitante
        equipoVisitante = scanner.nextLine();
        byte fin = 1;       // Se crea fin, el cual es un dato tipo byte iguala a 1
        while (fin != 0) {  // Se genera un bucle en el cual se dice que mientras fin sea distinto de 0 ese while va a seguir ocurriendo
            System.out.println("1  Ingresar datos sobre el partido");   // Se pide que se ingrese un número en específico dependiendo de cual dato se quiera agregar
            System.out.println("2  ingresar jugadores");
            System.out.println("3  Ingresar arbitraje");
            System.out.println("0  Comenzar Partido");
            byte opcion = scanner.nextByte();               // Se crea otro dato "opcion" de tipo byte, el cual va a estar involucrado en un switch
            switch (opcion) {
                case 1:
                    if (partido == false) {         // Si opcion es 1 va a entrar en un if en el cual te dice que si el dato boolean partido es false entonces va a ir al método agregarPartido de la clase Cambios
                        Cambios.agregarPartido();
                        partido = true;             // Una vez que se terminó el recorrido de agregarPartido la variable partido va a retornar true
                    } else {
                        System.out.println("Los datos ya fueron ingresados");   // En el caso de que partido ya fuera true va a saltar un mensaje
                    }
                    break;
                case 2:
                    if (jugadores == false) {       // Si opcion es 2 va a entrar en un if en el cual te dice que si el dato boolean jugadores es false entonces va a ir al método ingresarEquipoLocal y ingresarEquipoVisitante de la clase Cambios
                        boolean equipolocal = Cambios.ingresarEquipoLocal();
                        boolean equipovisitante = Cambios.ingresarEquipoVisitante();
                        EquipoLocal = Cambios.equipoLocal();        // A EquipoLocal y EquipoVisitante (creados en la línea 11 y 12) se le va a asignar los datos de sus respectivos equipos.
                        EquipoVisitante = Cambios.equipoVisitante();
                        if (equipolocal == true && equipovisitante == true)     //Si equipolocal y equipoVisitante retornan true entonces el dato jugadores va a ser igualado a true
                            jugadores = true;
                    } else {
                        System.out.println("Los jugadores ya se encuentran ingresados");    // En el caso de que jugadores ya fuera true va a saltar un mensaje
                    }
                    break;
                case 3:
                    if (arbitraje == false) {       // Si opcion es 3 va a entrar en un if en el cual te dice que si el dato boolean arbitraje es false entonces va a ir al método agregarArbitros de la clase Cambios
                        listaArbitral = Cambios.agregarArbitros();      // A listaArbitral (Creado en línea 10) se le va a asignar los datos del agregarArbitros
                        arbitraje = true;           // Luego de que ocurran los pasos anteriores arbitraje va a pasar a ser true
                    } else {
                        System.out.println("El arbitraje ya se encuentra ingresado");   // En el caso de que arbitraje ya fuera true va a saltar un mensaje
                    }
                    break;
                case 0:
                    if (partido == true && jugadores == true && arbitraje == true) {    // Si opcion es 0 va a entrar en un if en el cual te dice que si los datos boolean partido, jugadores y arbitraje son true entonces va a saltar al método iniciarPartido
                        iniciarPartido();
                        fin = 0;        // Y fin va a ser igualado a 0 generando que se termine el while
                    }
                    break;
                default:
                    System.out.println("Seleccione una de las opciones que se muestran arriba"); // En el caso de que se ingrese un número que no está indicado arriba va a saltar un mensaje pidiendo que ingrese otro número
                    break;
            }
        }
    }

    public static void iniciarPartido() {   // Luego de que los datos boolean dieran true en el método anterior van a saltar a este método
        Scanner scanner = new Scanner(System.in);
        byte fin = -1;      // En este método hay otro dato de tipo byte igualado a -1
        while (fin != 0) {  // Se genera un bucle en el cual se dice que mientras fin sea distinto de 0 ese while va a seguir ocurriendo
            System.out.println("1 Mostrar lista de datos ingresados");      // Se pide que se ingrese un número en específico dependiendo de cual dato se quiera revisar o agregar
            System.out.println("2 Hacer Cambio de jugador");
            System.out.println("3 Ingresar Gol");
            System.out.println("0 Finalizar partido");
            byte opcion = scanner.nextByte();   // Se crea otro dato "opcion" de tipo byte, el cual va a estar involucrado en un switch
            switch (opcion) {
                case 1:     // Si opcion es 1 va a entrar en la clase Cambios y va a mostrar los siguientes métodos: listarJugadores, listarTernaArbitral y listarPartido, en ese órden
                    Cambios.listarJugadores();
                    Cambios.listarTernaArbitral();
                    Cambios.listarPartido();
                    break;
                case 2:     // Si opcion es 2 va a entrar en la clase Cambios y va a ir al método cambiarJugador donde se va a poder hacer cambios entre suplentes y titulares
                    Cambios.cambiarJugador();
                    break;
                case 3:     // Si opcion es 3 va a entrar en la clase Cambios y va a ir al método ingresarGoles donde se va a poder ingresar de a un gol a cierto jugador titular.
                    Cambios.ingresarGoles();
                    break;
                case 0:
                    Cambios.ingresarMinutosJugados();   // Si opcion es 0 va a entrar en la clase Cambios y va ir al método ingresarMinutosJugados.
                    finPartido();                       // Luego de haber ido a ese método va a pasar al método finPartido de la clase Principal
                    fin = 0;        // El dato fin va a ser igualado a 0 generando que se termine el while de este método
                    break;
                default:
                    System.out.println("Ingrese una opción válida");    // En el caso de que se ingrese un número que no está indicado arriba va a saltar un mensaje pidiendo que ingrese otro número
                    break;
            }
        }
    }

    public static void finPartido(){    // Luego de terminar el método anterior va a saltar a este método
        Scanner scanner = new Scanner(System.in);
        byte fin = -1;      // En este método hay otro dato de tipo byte igualado a -1
        while (fin != 0) {  // Se genera un bucle en el cual se dice que mientras fin sea distinto de 0 ese while va a seguir ocurriendo
            System.out.println("1 Mostrar lista final de jugadores");       // Se pide que se ingrese un número en específico dependiendo de cual dato se quiera revisar
            System.out.println("2 Mostrar goleadores");
            System.out.println("3 Mostrar los datos finales del partido");
            System.out.println("0 Salir del sistema");
            byte opcion = scanner.nextByte();       // Se crea otro dato "opcion" de tipo byte, el cual va a estar involucrado en un switch
            switch (opcion) {
                case 1:     // Si opcion es 1 va a entrar en la clase Cambios y va a mostrar el método listarJugadores
                    Cambios.listarJugadores();
                    break;
                case 2:     // Si opcion es 2 va a entrar en la clase Cambios y va a mostrar el método listarGoleadores
                    Cambios.listarGoleadores();
                    break;
                case 3:     // Si opcion es 2 va a entrar en la clase Cambios y va a mostrar el método listarPartido
                    Cambios.listarPartido();
                    break;
                case 0:     // Si opcion es 0 va a mostrar un mensaje que dice "Fin" y el dato fin va a ser igualado a 0 generando que el switch termine
                    System.out.println("Fin.");
                    fin = 0;
                    break;
                default:
                    System.out.println("Opción no válida");     // En el caso de que se ingrese un número que no está indicado arriba va a saltar un mensaje diciendo que la opción no es válida
                    break;
            }
        }
    }
}