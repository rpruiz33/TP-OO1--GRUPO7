package test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.*;

public class Test {

    public static void main(String[] args) {

        Sistema sistema = new Sistema();

        // Entrenadores
       /* Entrenador entrenador1 = new Entrenador(1, "nombre", "apellido", 37969779, LocalDate.of(1993, 12, 10), "estrategiaFavorita");       
        Entrenador entrenador2 = new Entrenador(1, "nombre", "apellido", 37969779, LocalDate.of(1993, 12, 10), "estrategiaFavorita");
        */
        sistema.agregarEntrenador( "nombre", "apellido", 37969779, LocalDate.of(1993, 12, 10), "estrategiaFavorita");
        // Jugadores
        /*Jugador jugador1 = new Jugador("leo", "apellido", 11111111, LocalDate.of(1992, 10, 20), 1, 1.20f, 1.70f, "delantero", 10);

        List<Jugador> lstJugadores1 = new ArrayList<Jugador>();
        List<Jugador> lstJugadores2 = new ArrayList<Jugador>();
        
        
        lstJugadores1.add(jugador1);
        */
       /* 
        List<Integer> puntos = new ArrayList<Integer>();
        puntos.add(1);
        puntos.add(3);
        puntos.add(3);*/
        System.out.println(sistema.agregarEntrenador("roberto", "Ruiz", 1212121, LocalDate.of(2012, 9, 3), "metergoles"));
        System.out.println(sistema.agregarTorneo(1, "mundial", "1", null, null, LocalDate.of(2025, 3, 3), LocalDate.of(2025, 3, 3), null));
        Equipo equipo4 = new Equipo(1, "Republica del Congo", sistema.traerEntrenador(1), "con", LocalDate.of(2025, 3, 3));
        Equipo equipo3 = new Equipo(1, "Malasia", sistema.traerEntrenador(1), "mal", LocalDate.of(2020, 10, 10));
        /*	public Partido(int id, String estadio, Equipo equipoLocal, Equipo equipoVisitante, LocalDate fechaPartido)*/
        System.out.println(sistema.traerTorneo(1).agregarPartido("river",equipo4, equipo3,LocalDate.of(2025, 3, 3)));
        // Equipos
        /*Equipo equipo3 = new Equipo(1, "Malasia", entrenador1, "mal", LocalDate.of(2020, 10, 10));
       System.out.println( sistema.agregarJugador("leo", "apellido", 11111111, LocalDate.of(1992, 10, 20), 1, 1.20f, "delantero", 10));
        Equipo equipo5 = new Equipo(1, c);
        Equipo equipo4 = new Equipo(2, "Republica del Congo", entrenador2, "con", LocalDate.of(2025, 3, 3));*/

        // Agregamos jugador al sistema
        sistema.agregarJugador("nombre", "apellido", 11111, LocalDate.of(2025, 12, 3), 120.f, 120.f, "1", 2);
        System.out.println(sistema.getLstJugadores());
        System.out.println(sistema.traerJugador(1));
        try {
            System.out.println(sistema.eliminarJugador(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Entrenadores
        System.out.println(sistema.agregarEntrenador("roberto", "Ruiz", 1212121, LocalDate.of(2012, 9, 3), "metergoles"));
        System.out.println(sistema.traerEntrenador(1));
        try {
            System.out.println(sistema.eliminarEntrenador(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Lista de equipos y partidos
        



        /*List<Partido> lstPartidos = new ArrayList<>();
        lstPartidos.add(partido1);
        lstPartidos.add(partido2);*/
        System.out.println(sistema.agregarEntrenador("roberto", "Ruiz", 1212121, LocalDate.of(2012, 9, 3), "metergoles"));
        System.out.println(sistema.getLstTorneos().get(0).agregarEquipo("Malasia", sistema.traerEntrenador(0), "mal", LocalDate.of(2020, 10, 10)));
        
        System.out.println(sistema.getLstTorneos().get(0).agregarPartido("bocaa",sistema.traerTorneo(1).traerEquipo(1), sistema.traerTorneo(1).traerEquipo(1), LocalDate.of(2025, 3, 3)));
        System.out.println(sistema.getLstTorneos().get(0).agregarPartido("bocaa",sistema.traerTorneo(1).traerEquipo(1), sistema.traerTorneo(1).traerEquipo(1), LocalDate.of(2025, 3, 3)));

        /*int id, String nombre, String temporada, List<Equipo> lstEquipos, List<Partido> lstPartidos,
			LocalDate fechaDeInicio, LocalDate fechaDeFinalizacion,Equipo equipoGanador*/
        
        // Agregar torneo
        System.out.println(sistema.agregarTorneo(2, "libertadores","1", sistema.getLstTorneos().get(0).getLstEquipos(),sistema.getLstPartidos(), LocalDate.of(2025, 6, 3),LocalDate.of(2026, 3,2),sistema.traerTorneo(1).traerEquipo(0)));
        System.out.println(sistema.traerTorneo(1));
        try {
            System.out.println(sistema.eliminarTorneo(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Reagregar torneo
/*   System.out.println(sistema.agregarTorneo(1, "mundial", "1",  sistema.getLstTorneos().get(0).getLstEquipos(),sistema.getLstPartidos(), LocalDate.of(2025, 3, 3), LocalDate.of(2025, 3, 3), sistema.traerTorneo(1).traerEquipo(0)));
        System.out.println(sistema.traerTorneo(1));*/

        // Traer ganadores por fecha
        System.out.println(sistema.traerTorneoPorFecha(1, LocalDate.of(2025, 3, 3)));
        System.out.println(sistema.agregarEntrenador("roberto", "Ruiz", 1212121, LocalDate.of(2012, 9, 3), "metergoles"));

        System.out.println(sistema.busquedaEntrenadoresPorTactica("metergoles")); 
        sistema.agregarJugador("nombre", "apellido", 11111, LocalDate.of(2025, 12, 3), 120.f, 120.f, "1", 2);
        System.out.println(sistema.jugadoresFechaNacimento(LocalDate.of(1991, 1, 2), LocalDate.of(2025, 12, 24)));
    
    }

}
