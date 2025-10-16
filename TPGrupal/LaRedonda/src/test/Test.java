package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.*;

public class Test {
    public static void main(String[] args) {

        Sistema sistema = new Sistema();

        // --- 1) Agrego entrenadores ---
        boolean ok = sistema.agregarEntrenador("Juan", "Perez", 37969779, LocalDate.of(1993, 12, 10), "estrategiaFavorita");
        System.out.println("agregarEntrenador Juan Perez -> " + ok);

        ok = sistema.agregarEntrenador("Roberto", "Ruiz", 1212121, LocalDate.of(2012, 9, 3), "metergoles");
        System.out.println("agregarEntrenador Roberto Ruiz -> " + ok);

        // Traigo referencias seguras
        Entrenador entrenador1 = sistema.traerEntrenador(1);
        Entrenador entrenador2 = sistema.traerEntrenador(2);

        if (entrenador1 == null || entrenador2 == null) {
            System.out.println("Error: no se encontraron entrenadores esperados.");
        }

        // --- 2) Creo un torneo ---
        ok = sistema.agregarTorneo(1, "Mundial", "1", null, null,
                LocalDate.of(2025, 3, 3), LocalDate.of(2025, 3, 3), null);
        System.out.println("agregarTorneo(1, Mundial) -> " + ok);

        Torneo torneo = sistema.traerTorneo(1);
        if (torneo == null) {
            System.out.println("No se creó/recuperó el torneo 1. Fin del test.");
            return;
        }

        // --- 3) Agrego equipos ---
        boolean addEq = torneo.agregarEquipo("Republica del Congo", entrenador1, "CON", LocalDate.of(2025, 3, 3));
        System.out.println("agregarEquipo Congo -> " + addEq);

        addEq = torneo.agregarEquipo("Malasia", entrenador2, "MAL", LocalDate.of(2020, 10, 10));
        System.out.println("agregarEquipo Malasia -> " + addEq);

        Equipo local = torneo.traerEquipo(1);
        Equipo visitante = torneo.traerEquipo(2);
        if (local == null || visitante == null) {
            System.out.println("Error al traer equipos. Revisar agregarEquipo.");
        }

        // --- 4) Agrego partido ---
        boolean addPartido = torneo.agregarPartido("Estadio Principal", local, visitante, LocalDate.of(2025, 3, 3));
        System.out.println("agregarPartido Estadio Principal -> " + addPartido);

        // --- 5) Agrego jugador y pruebo eliminación ---
        ok = sistema.agregarJugador("Nombre", "Apellido", 11111,
                LocalDate.of(2000, 12, 3), 120.f, 120.f, "1", 2);
        System.out.println("agregarJugador Nombre Apellido -> " + ok);

        Jugador j1 = sistema.traerJugador(1);
        if (j1 != null) {
            System.out.println("Jugador 1 encontrado: " + j1.getNombre() + " " + j1.getApellido());
        } else {
            System.out.println("Jugador 1 no encontrado.");
        }

        try {
            boolean eliminado = sistema.eliminarJugador(1);
            System.out.println("eliminarJugador(1) -> " + eliminado);
        } catch (Exception e) {
            System.out.println("Excepción al eliminar jugador 1:");
            e.printStackTrace();
        }

        // --- 6) Vuelvo a agregar entrenador y lo elimino ---
        ok = sistema.agregarEntrenador("Roberto", "Ruiz", 1212121, LocalDate.of(2012, 9, 3), "metergoles");
        System.out.println("re-agregarEntrenador Roberto Ruiz -> " + ok);

        try {
            boolean elimEntr = sistema.eliminarEntrenador(1);
            System.out.println("eliminarEntrenador(1) -> " + elimEntr);
        } catch (Exception e) {
            System.out.println("Excepción al eliminar entrenador 1:");
            e.printStackTrace();
        }

        // --- 7) Genero tabla de posiciones ---
        List<Posicion> tabla = torneo.generarTablaPosiciones();
        if (tabla != null) {
            System.out.println("\nTABLA DE POSICIONES");
            for (int i = 0; i < tabla.size(); i++) {
                Posicion p = tabla.get(i);
                System.out.println((i + 1) + "° " + p.getEquipo().getNombre() + " - " + p.getPuntos() + " pts");
            }
        } else {
            System.out.println("No se pudo generar tabla de posiciones.");
        }

        // --- 8) Creo jugadores para prueba de goles/asistencias ---
        Jugador p1 = new Jugador("Lionel", "Messi", 999, LocalDate.of(1987, 6, 24), 0, 0, 0, "", 0, 0);
        Jugador p2 = new Jugador("Angel", "Di María", 998, LocalDate.of(1988, 2, 14), 0, 0, 0, "", 0, 0);
        Jugador p3 = new Jugador("Julian", "Álvarez", 997, LocalDate.of(2000, 1, 31), 0, 0, 0, "", 0, 0);

        // Registro asistencias directamente
        sistema.registrarAsistencia(p1);
        sistema.registrarAsistencia(p2);
        sistema.registrarAsistencia(p1);
        sistema.registrarAsistencia(p3);
        sistema.registrarAsistencia(p1);
        sistema.registrarAsistencia(p3);

        // === 9) Mostrar tabla sin ordenar ===
        
        sistema.mostrarTablaAsistidores();

        // --- 10) Creo partido con goles ---
        Equipo e1 = new Equipo(100, "EquipoA", entrenador1, "EQA", LocalDate.now());
        Equipo e2 = new Equipo(101, "EquipoB", entrenador2, "EQB", LocalDate.now());

        Partido partido11 = new Partido(1, "Estadio A", e1, e2, LocalDate.of(2025, 5, 1));

        ParticipacionPartido pp1 = new ParticipacionPartido(p1, 2); // Messi
        ParticipacionPartido pp2 = new ParticipacionPartido(p2, 1); // Di María
        ParticipacionPartido pp3 = new ParticipacionPartido(p3, 1); // Álvarez

        // Agrego asistencias en las participaciones
        pp1.setAsistencias(2);
        pp2.setAsistencias(1);
        pp3.setAsistencias(3);

        partido11.getListParticipacionPartido().add(pp1);
        partido11.getListParticipacionPartido().add(pp2);
        partido11.getListParticipacionPartido().add(pp3);

        torneo.getLstPartidos().add(partido11);

        // --- 11) Tabla de goleadores ---
        ArrayList<Goleador> goleadores = torneo.generarTablaGoleadores();
        System.out.println("\nTABLA DE GOLEADORES");
        int posG = 1;
        for (Goleador g : goleadores) {
            System.out.println(posG + "° " + g.getJugador().getNombre() + " " + g.getJugador().getApellido() +
                    " - Goles: " + g.getGoles());
            posG++;
        }

        // --- 12) Tabla de asistidores ---
        ArrayList<Asistencia> asistidores = torneo.generarTablaAsistidores();
        System.out.println("\nTABLA DE ASISTIDORES");
        int posA = 1;
        for (Asistencia a : asistidores) {
            System.out.println(posA + "° " + a.getJugador().getNombre() + " " + a.getJugador().getApellido() +
                    " - Asistencias: " + a.getAsistencias());
            posA++;
        }

        
    }
}
