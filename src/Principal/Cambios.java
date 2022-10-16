package Principal;

import Principal.Principal;

import java.util.*;
import clases.*;
import java.util.*;

public class Cambios {
    //Se crean los métodos
    private static Partido Partido = new Partido();
    private static Equipo EquipoLocal = new Equipo();
    static List<Jugador> listaJugLoc = new ArrayList();
    static List<Jugador> listaSuplentesLoc = new ArrayList();
    private static Equipo EquipoVisitante = new Equipo();
    static List<Jugador> listaJugVis = new ArrayList();
    static List<Jugador> listaSuplentesVis = new ArrayList();
    static List<Arbitro> listaArbitral = new ArrayList();
    public static Partido partido() {
        return Partido;
    }

    public static Equipo equipoLocal() {
        return EquipoLocal;
    }

    public static Equipo equipoVisitante() {
        return EquipoVisitante;
    }

    //METODOS PARA AGREGAR DATOS:

    public static void agregarPartido() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los datos del partido");
        System.out.println("");
        System.out.println("Ingrese el estadio");
        String estadio = scan.next();
        System.out.println("Ingrese el dia del partido");
        System.out.println("Ejemplo: 'dd/mm/aaaa'");
        String dia = scan.next();
        System.out.println("Ingrese la hora a la que comienza el partido");
        System.out.println("Ejemplo: xx:xx");
        String hora = scan.next();
        System.out.println("Ingrese el clima que hay");
        String clima = scan.next();
        String minutos = "00:00";
        Partido partido = new Partido(estadio, dia, hora, clima, minutos);
        Partido = partido;
    }

    public static boolean ingresarEquipoLocal() {
        String nombre = Principal.equipoLocal;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los datos del equipo: " + nombre);
        System.out.println("");

        System.out.println("Ingrese al DT");

        System.out.println("Ingrese su Nombre");
        String nombreDT = scan.next();

        System.out.println("Ingrese su Apellido");
        String apellidoDT = scan.next();

        System.out.println("Ingrese su Edad");
        byte edadDT = scan.nextByte();

        DT TecnicoEqLoc = new DT(nombreDT, apellidoDT, edadDT);

        System.out.println("Ingrese a todos los Jugadores Titulares");
        System.out.println("Recuerde no repetir el número de Dorsales");
        System.out.println("");
        for (int i = 0; i < 11; i++) {
            System.out.println("Ingrese el nombre del jugador");
            String nombreTitu = scan.next();

            System.out.println("Ingrese el apellido del jugador");
            String apellidoTitu = scan.next();

            System.out.println("Ingrese la edad del jugador");
            byte edadTitu = scan.nextByte();

            System.out.println("Ingrese el puesto del jugador");
            String puestoTitu = scan.next();

            System.out.println("Ingrese el dorsal del jugador");
            byte dorsalTitu = scan.nextByte();

            byte golesTitu = 0;

            if (listaJugLoc.size() == 0) {
                Jugador jugador = new Jugador(nombreTitu, apellidoTitu, edadTitu, puestoTitu, dorsalTitu, golesTitu);
                listaJugLoc.add(jugador);
                System.out.println("Jugadores del Equipo local Cargados");
            } else {
                boolean existe = false;
                for (Jugador unJugador : listaJugLoc) {
                    if (unJugador.get_numero() == dorsalTitu) {
                        System.out.println("No se pudo ingresar porque ya hay un jugador con ese número \n Ingrese los datos nuevamente.");
                        i--;
                    } else {
                        existe = true;
                    }
                }
                if (existe == true) {
                    Jugador jugador = new Jugador(nombreTitu, apellidoTitu, edadTitu, puestoTitu, dorsalTitu, golesTitu);
                    listaJugLoc.add(jugador);
                    System.out.println(listaJugLoc.get(0));
                }
            }
        }
        System.out.println("Ingrese a los jugadores suplentes");
        System.out.println(" ");
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese el nombre del jugador");
            String nombreSup = scan.next();

            System.out.println("Ingrese el apellido del jugador");
            String apellidoSup = scan.next();

            System.out.println("Ingrese la edad del jugador");
            byte edadSup = scan.nextByte();

            System.out.println("Ingrese el puesto del jugador");
            String puestoSup = scan.next();

            System.out.println("Ingrese el dorsal del jugador");
            byte dorsalSup = scan.nextByte();

            byte golesSup = 0;

            boolean existeTitu = false;
            boolean existeSup = false;

            for (Jugador unJugador : listaJugLoc) {
                if (unJugador.get_numero() == dorsalSup) {
                    existeTitu = true;
                }
            }
            for (Jugador unJugador : listaSuplentesLoc) {
                if (unJugador.get_numero() == dorsalSup) {
                    existeSup = true;
                }
            }
            if (existeTitu == true || existeSup == true) {
                System.out.println("No se pudo ingresar porque ya hay un jugador con ese número \n Ingrese los datos nuevamente.");
                i--;
            } else {
                Jugador jugador = new Jugador(nombreSup, apellidoSup, edadSup, puestoSup, dorsalSup, golesSup);
                listaSuplentesLoc.add(jugador);
                System.out.println("Jugadores del equipo local agregados");
            }
        }
        Equipo eq = new Equipo((byte) 1, nombre, listaJugLoc, listaSuplentesLoc, TecnicoEqLoc);
        EquipoLocal = eq;

        if (TecnicoEqLoc != null && listaJugLoc.size() == 11 && listaSuplentesLoc.size() == 5) {
            return true;
        }
        return false;
    }

    public static boolean ingresarEquipoVisitante() {
        String nombre = Principal.equipoVisitante;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los datos del Equipo Visitante: " + nombre);
        System.out.println("");

        System.out.println("Ingrese los datos del DT");

        System.out.println("Ingrese su nombre");
        String nombreDT = scan.next();

        System.out.println("Ingrese su Apellido");
        String apellidoDT = scan.next();

        System.out.println("Ingrese su edad");
        byte edadDT = scan.nextByte();

        DT TecnicoEqVis = new DT(nombreDT, apellidoDT, edadDT);

        System.out.println("Ingrese los Jugadores Titulares");
        System.out.println("");
        for (int i = 0; i < 11; i++) {
            System.out.println("Ingrese el nombre del jugador");
            String nombreTitu = scan.next();

            System.out.println("Ingrese el apellido del jugador");
            String apellidoTitu = scan.next();

            System.out.println("Ingrese la edad del jugador");
            byte edadTitu = scan.nextByte();

            System.out.println("Ingrese el puesto del jugador");
            String puestoTitu = scan.next();

            System.out.println("Ingrese el dorsal del jugador");
            byte dorsalTitu = scan.nextByte();

            byte golesTitu = 0;

            if (listaJugVis.size() == 0) {
                Jugador jugador = new Jugador(nombreTitu, apellidoTitu, edadTitu, puestoTitu, dorsalTitu, golesTitu);
                listaJugVis.add(jugador);
                System.out.println("Jugadores titulares del equipo visitante agregados");
            } else {
                boolean existe = false;
                for (Jugador unJugador : listaJugVis) {
                    if (unJugador.get_numero() == dorsalTitu) {
                        System.out.println("No se pudo ingresar porque ya hay un jugador con ese número \n Ingrese los datos nuevamente.");
                        i--;
                    } else {
                        existe = true;
                    }
                }
                if (existe == true) {
                    Jugador jugador = new Jugador(nombreTitu, apellidoTitu, edadTitu, puestoTitu, dorsalTitu, golesTitu);
                    listaJugVis.add(jugador);
                    System.out.println("Jugadores titulares del equipo visitante agregados");
                }
            }
        }
        System.out.println("Ingrese a los jugadores suplentes");
        System.out.println(" ");
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese el nombre del jugador");
            String nombreSup = scan.next();

            System.out.println("Ingrese el apellido del jugador");
            String apellidoSup = scan.next();

            System.out.println("Ingrese la edad del jugador");
            byte edadSup = scan.nextByte();

            System.out.println("Ingrese el puesto del jugador");
            String puestoSup = scan.next();

            System.out.println("Ingrese el dorsal del jugador");
            byte dorsalSup = scan.nextByte();

            byte golesSup = 0;

            boolean existeTitu = false;
            boolean existeSup = false;
            for (Jugador unJugador : listaJugVis) {
                if (unJugador.get_numero() == dorsalSup) {
                    existeTitu = true;
                }
            }
            for (Jugador unJugador : listaSuplentesVis) {
                if (unJugador.get_numero() == dorsalSup) {
                    existeSup = true;
                }
            }
            if (existeTitu == true || existeSup == true) {
                System.out.println("No se pudo ingresar porque ya hay un jugador con ese número \n Ingrese los datos nuevamente.");
                i--;
            } else {
                Jugador jugador = new Jugador(nombreSup, apellidoSup, edadSup, puestoSup, dorsalSup, golesSup);
                listaSuplentesVis.add(jugador);
                System.out.println("Jugadores suplentes del equipo visitante agregados");
            }
        }
        Equipo eq = new Equipo((byte) 1, nombre, listaJugVis, listaSuplentesVis, TecnicoEqVis);
        EquipoVisitante = eq;

        if (TecnicoEqVis != null && listaJugVis.size() == 11 && listaSuplentesVis.size() == 5) {
            return true;
        }
        return false;
    }

    public static List<Arbitro> agregarArbitros() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los arbitros");
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese su Nombre");
            String nombre = scan.next();
            System.out.println("Ingrese su Apellido");
            String apellido = scan.next();
            System.out.println("Ingrese el Puesto en el que arbitran");
            String puesto = scan.next();
            Arbitro arbitro = new Arbitro(nombre, apellido, puesto);
            listaArbitral.add(arbitro);

        }
        return listaArbitral;
    }

    public static boolean ingresarGoles() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el número del equipo en el que se hizo el gol");    // Se pide que se ingrese un número y en base al número que se ingrese se va a seleccionar el equipo al que se le quiera agregar un gol
        System.out.println("Ingrese 1 para el equipo " + equipoLocal().get_nombre());
        System.out.println("Ingrese 2 para el equipo " + equipoVisitante().get_nombre());
        byte equipoGol = scan.nextByte();

        System.out.println("Ingrese el dorsal del jugador que hizo el gol");            // Se pide ingresar el dorsal de un jugador
        byte dorsalGol = scan.nextByte();

        Jugador jugador = new Jugador();

        boolean JugGol = false;

        if (equipoGol == 1){        // Si el número que se pidió al principio es 1 entonces el equipo seleccionado va a ser el equipo local
            for (Jugador unJugador : listaJugLoc) {         // Se recorre la lista de los jugadores locales
                if (unJugador.get_numero() == dorsalGol) {  // En el if se pregunta que si el nùmero del dorsal que se ingresó pertenece a un dorsal existente de la lista recorrida anteriormente
                    System.out.println("El jugador " + unJugador.get_nombre() + " " + unJugador.get_apellido() + " ha hecho un gol"); // entonces se va a mostrar en consola el nombre y apellido del jugador que hizo el gol
                    unJugador.set_goles((byte) (unJugador.get_goles() + 1));    // A su vez a la variable goles del jugador se le va a sumar 1
                    jugador = unJugador;
                    JugGol = true;
                }
                else {
                    System.out.println("Ese dorsal no pertenece a ningún jugador");     // Si lo que se pregunta en el if no se cumple, va a saltar un mensaje diciendo que ese jugador no existe.
                    return false;
                }
            }
            return true;
        }
        else if(equipoGol == 2)     // Si el número que se pidió al principio es 2 entonces el equipo seleccionado va a ser el equipo visitante
        {
            for(Jugador unJugador : listaJugVis)        // Se recorre la lista de los jugadores visitantes
            {
                if (unJugador.get_numero() == dorsalGol) {      // En el if se pregunta que si el numero del dorsal que se ingresó pertenece a un dorsal existente de la lista recorrida anteriormente
                    System.out.println("El jugador " + unJugador.get_nombre() + " " + unJugador.get_apellido() + " ha hecho un gol");   // entonces se va a mostrar en consola el nombre y apellido del jugador que hizo el gol
                    unJugador.set_goles((byte) (unJugador.get_goles() + 1));    // A su vez a la variable goles del jugador se le va a sumar 1
                    jugador = unJugador;
                    JugGol = true;
                }
                else {
                    System.out.println("Ese dorsal no pertenece a ningún jugador");     // Si lo que se pregunta en el if no se cumple, va a saltar un mensaje diciendo que ese jugador no existe.
                    return false;
                }
            }
            return true;
        }
        else
        {
            System.out.println("Ese equipo no existe, intente nuevamente");     // Si el número del equipo ingresado no existe va a saltar un alert.
            return false;
        }
    }
    public static void ingresarMinutosJugados() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los datos del partido");
        System.out.println("");
        System.out.println("Ingrese los minutos jugados");
        String minutos = scan.next();                       // Se pide que se ingrese los minutos jugados y se van a guardar en la variable minutos

        String estadio = partido().get_estadio();           // Los datos ingresados anteriormente en el metodo agregarPartido quedan con su valor
        String dia = partido().get_dia();
        String hora = partido().get_hora();
        String clima = partido().get_clima();
        Partido partido = new Partido(estadio, dia, hora, clima, minutos); // Se actualizan los datos de la clase partido, obteniendo los minutos con los que termina el partido
        Partido = partido;
    }

    // MÉTODOS PARA HACER MODIFICACIONES
    public static boolean cambiarJugador() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el número del equipo, en el que se encuentra el jugador que desea sustituir ");
        System.out.println("Ingrese 1 para cambiar al equipo " + equipoLocal().get_nombre());
        System.out.println("Ingrese 2 para cambiar al equipo " + equipoVisitante().get_nombre());
        byte acambiar = scan.nextByte();

        System.out.println("Ingrese el dorsal del jugador titular");
        byte dorsalTitular = scan.nextByte();

        System.out.println("Ingrese el dorsal del jugador suplente");
        byte dorsalSuplente = scan.nextByte();

        Jugador jugador = new Jugador();
        Jugador jugador1 = new Jugador();

        boolean JugTit = false;
        boolean JugSup = false;

        if (acambiar == 1)
        {
            for(Jugador unJugador : listaJugLoc)
            {
                if(unJugador.get_numero() == dorsalTitular)
                {
                    jugador = unJugador;
                    JugTit = true;
                }
            }
            for(Jugador unJugador1 : listaSuplentesLoc)
            {
                if (unJugador1.get_numero() == dorsalSuplente)
                {
                    jugador1 = unJugador1;
                    JugSup = true;
                }
            }
            if (JugTit == true && JugSup == true)
            {
                EquipoLocal.get_listaTitulares().remove(jugador);
                EquipoLocal.get_listaTitulares().add(jugador1);
                EquipoLocal.get_listaSuplentes().remove(jugador1);
                EquipoLocal.get_listaSuplentes().add(jugador);
                System.out.println("Salió el jugador " + jugador.get_nombre() + " "+ jugador.get_apellido());
                System.out.println("Ingresó el jugador " + jugador1.get_nombre() + " " + jugador1.get_apellido());
                return true;
            }
            else {
                System.out.println("Uno o ambos de esos dorsales no pertenece a al dorsal de algún jugador");
                return false;
            }
        }
        else if(acambiar == 2)
        {
            for(Jugador unJugador : listaJugVis)
            {
                if(unJugador.get_numero() == dorsalTitular)
                {
                    jugador = unJugador;
                    JugTit = true;
                }
            }
            for(Jugador unJugador1 : listaSuplentesVis)
            {
                if (unJugador1.get_numero() == dorsalSuplente)
                {
                    jugador1 = unJugador1;
                    JugSup = true;
                }
            }
            if (JugTit == true && JugSup == true)
            {
                EquipoVisitante.get_listaTitulares().remove(jugador);
                EquipoVisitante.get_listaTitulares().add(jugador1);
                EquipoVisitante.get_listaSuplentes().remove(jugador1);
                EquipoVisitante.get_listaSuplentes().add(jugador);
                System.out.println("Salió el jugador " + jugador.get_nombre() + " "+ jugador.get_apellido());
                System.out.println("Ingresó el jugador " + jugador1.get_nombre() + " " + jugador1.get_apellido());
                return true;
            }
            else
            {
                System.out.println("Uno de los dorsale no es correcto!");
                return false;
            }
        }
        else
        {
            System.out.println("Ese equipo no existe, intente nuevamente");
            return false;
        }
    }

    //MÉTODOS PARA LISTAR
    public static void listarJugadores() {
        System.out.println("Equipo Local: " + equipoLocal().get_nombre() + " - Equipo Visitante: " + equipoVisitante().get_nombre()); // Se muestra cual es el equipo local y el visitante
        System.out.println(" ");
        System.out.println("Descipción del equipo local: " + equipoLocal().get_nombre());           // Se muestra el nombre del equipo local
        System.out.println("Director Técnico:");                // Se muestran los datos del técnico del equipo local
        System.out.println(equipoLocal().get_tecnico());
        System.out.println("Jugadores Titulares:");             // Se muestra la lista de los jugadores titulares del equipo local
        System.out.println(listaJugLoc);
        System.out.println("Jugadores Suplentes:");             // Se muestra la lista de los jugadores suplentes del equipo local
        System.out.println(listaSuplentesLoc);
        System.out.println(" ");
        System.out.println("Descipción del equipo visitante: " + equipoVisitante().get_nombre());   // Se muestra el nombre del equipo visitante
        System.out.println("Director Técnico:");                // Se muestran los datos del técnico del equipo visitante
        System.out.println(equipoVisitante().get_tecnico());
        System.out.println("Jugadores Titulares:");             // Se muestra la lista de los jugadores titulares del equipo visitante
        System.out.println(listaJugVis);
        System.out.println("Jugadores Suplentes:");             // Se muestra la lista de los jugadores suplentes del equipo visitante
        System.out.println(listaSuplentesVis);
        System.out.println(" ");
    }

    public static void listarTernaArbitral() {
        System.out.println("La terna arbitral se compone por: ");   //Se muestra la lista de la terna arbitral en la cual se va a mostrar todos sus datos
        System.out.println(listaArbitral);
        System.out.println(" ");
    }

    public static void listarPartido() {
        System.out.println("Los datos del partido son los siguientes: ");
        System.out.println("Estadio: " + partido().get_estadio());                  // Se muestra el estadio en el cual se juega el partido
        System.out.println("Día: " + partido().get_dia());                          // Se muestra el día del partido
        System.out.println("Hora: " + partido().get_hora());                        // Se muestra la hora de comienzo del partido
        System.out.println("Clima: " + partido().get_clima());                      // Se muestra el clima que hay el día del partido
        System.out.println("Minutos Jugados: " + partido().get_minutosJugados());   // Se muestran los minutos jugados del partido, al principio siempre van a ser 00:00 pero al finalizarlos se van a modificar a los minutos finales del partido
    }

    public static void listarGoleadores() {
        System.out.println("Resultados del partido:");
        System.out.println("");
        System.out.println("Goleadores del equipo: " + equipoLocal().get_nombre());
        byte cantGolesLoc = 0;                      // Se crea tres variables de tipo byte igualadas a 0
        byte cantGolesLocSup = 0;
        byte cantGolesLocTot = 0;
        for (Jugador unJugador : listaJugLoc) {     // Luego se recorre la lista de los jugadores locales a través de un foreach
            if (unJugador.get_goles() > 0) {        // En el if se van a buscar todos los jugadores que en su variable de goles tengan más de 0
                System.out.println(unJugador.get_nombre() + " " + unJugador.get_apellido() + ": " + unJugador.get_goles() + " goles."); // Y en la consola se va a mostrar el nombre, el apellido y los goles que ese jugador hizo
                cantGolesLoc = (byte) (unJugador.get_goles() + cantGolesLoc); // La variable que se creó al principio va a ser la encargada de contar la cantidad de goles totales de ese equipo.
            }
        }
        for (Jugador unJugador : listaSuplentesLoc) {     // Luego se recorre la lista de los jugadores locales suplentes a través de un foreach
            if (unJugador.get_goles() > 0) {        // En el if se van a buscar todos los jugadores que en su variable de goles tengan más de 0
                System.out.println(unJugador.get_nombre() + " " + unJugador.get_apellido() + ": " + unJugador.get_goles() + " goles."); // Y en la consola se va a mostrar el nombre, el apellido y los goles que ese jugador hizo
                cantGolesLocSup = (byte) (unJugador.get_goles() + cantGolesLocSup); // La variable que se creó al principio va a ser la encargada de contar la cantidad de goles totales de ese equipo.
            }
        }
        cantGolesLocTot = (byte) (cantGolesLoc + cantGolesLocSup);
        System.out.println("Cantidad total de goles del equipo local: " + cantGolesLocTot); // Se muestra la cantidad de goles totales del equipo

        System.out.println(" ");

        System.out.println("Goleadores del equipo: " + equipoVisitante().get_nombre());
        byte cantGolesVis = 0;                      // Se crea tres variables de tipo byte igualadas a 0
        byte cantGolesVisSup = 0;
        byte cantGolesVisTot = 0;
        for (Jugador unJugador : listaJugVis) {     // Luego se recorre la lista de los jugadores locales a través de un foreach
            if (unJugador.get_goles() > 0) {        // En el if se van a buscar todos los jugadores que en su variable de goles tengan más de 0
                System.out.println(unJugador.get_nombre() + " " + unJugador.get_apellido() + ": " + unJugador.get_goles() + " goles."); // Y en la consola se va a mostrar el nombre, el apellido y los goles que ese jugador hizo
                cantGolesVis = (byte) (unJugador.get_goles() + cantGolesVis); // La variable que se creó al principio va a ser la encargada de contar la cantidad de goles totales de ese equipo.
            }
        }
        for (Jugador unJugador : listaSuplentesVis) {     // Luego se recorre la lista de los jugadores locales suplentes a través de un foreach
            if (unJugador.get_goles() > 0) {        // En el if se van a buscar todos los jugadores que en su variable de goles tengan más de 0
                System.out.println(unJugador.get_nombre() + " " + unJugador.get_apellido() + ": " + unJugador.get_goles() + " goles."); // Y en la consola se va a mostrar el nombre, el apellido y los goles que ese jugador hizo
                cantGolesVisSup = (byte) (unJugador.get_goles() + cantGolesVisSup); // La variable que se creó al principio va a ser la encargada de contar la cantidad de goles totales de ese equipo.
            }
        }
        cantGolesVisTot = (byte) (cantGolesVis + cantGolesVisSup);
        System.out.println("Cantidad total de goles del equipo visitante: " + cantGolesVisTot);  // Se muestra la cantidad de goles totales del equipo

    }
}
