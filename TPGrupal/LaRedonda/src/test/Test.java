package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.*;

public class Test {
    public static void main(String[] args) {

        Sistema sistema = new Sistema();

        // --- 1) Agrego entrenadores de forma controlada y guardo referencias ---
        boolean ok = sistema.agregarEntrenador("Juan", "Perez", 37969779, LocalDate.of(1993, 12, 10), "estrategiaFavorita");
        System.out.println("agregarEntrenador Juan Perez -> " + ok);

        ok = sistema.agregarEntrenador("Roberto", "Ruiz", 1212121, LocalDate.of(2012, 9, 3), "metergoles");
        System.out.println("agregarEntrenador Roberto Ruiz -> " + ok);

        // Obtengo referencias seguras (alternativa a llamar por ID si no estás seguro de la asignación)
        Entrenador entrenador1 = sistema.traerEntrenador(1);
        Entrenador entrenador2 = sistema.traerEntrenador(2);

        if (entrenador1 == null || entrenador2 == null) {
            System.out.println("Error: no se encontraron entrenadores esperados (revisar IDs).");
            // Si dependés de estos entrenadores para continuar, podés return; aquí continúo pero con checks abajo.
        }

        // --- 2) Creo un torneo y verifico resultado ---
        ok = sistema.agregarTorneo(1, "mundial", "1", null, null, LocalDate.of(2025, 3, 3), LocalDate.of(2025, 3, 3), null);
        System.out.println("agregarTorneo(1, mundial) -> " + ok);

        Torneo torneo = sistema.traerTorneo(1);
        if (torneo == null) {
            System.out.println("No se creó/recuperó el torneo 1. Fin del test.");
            return;
        }

        // --- 3) Agrego equipos al torneo usando referencias seguras a entrenadores ---
        // Evitar IDs duplicados: uso 1 y 2
        boolean addEq = torneo.agregarEquipo("Republica del Congo", entrenador1, "CON", LocalDate.of(2025, 3, 3));
        System.out.println("agregarEquipo Congo -> " + addEq);

        addEq = torneo.agregarEquipo("Malasia", entrenador2, "MAL", LocalDate.of(2020, 10, 10));
        System.out.println("agregarEquipo Malasia -> " + addEq);

        // Traigo equipos desde el torneo (seguro si se agregaron correctamente)
        Equipo local = torneo.traerEquipo(1);      // asumo que el primer equipo tiene id 1
        Equipo visitante = torneo.traerEquipo(2);  // asumo id 2
        if (local == null || visitante == null) {
            System.out.println("No se encontraron equipos en el torneo. Revisa agregarEquipo o IDs.");
        } else {
            // --- 4) Agrego un partido al torneo (uso los objetos locales para evitar confusiones de ID) ---
            boolean addPartido = torneo.agregarPartido("Estadio Principal", local, visitante, LocalDate.of(2025, 3, 3));
            System.out.println("agregarPartido Estadio Principal -> " + addPartido);
        }

        // --- 5) Agrego jugadores al sistema y compruebo existencia ---
        ok = sistema.agregarJugador("Nombre", "Apellido", 11111, LocalDate.of(2000, 12, 3), 120.f, 120.f, "1", 2);
        System.out.println("agregarJugador Nombre Apellido -> " + ok);

        // Asumo que el primer jugador creado tiene id = 1, pero lo comprobamos:
        Jugador j1 = sistema.traerJugador(1);
        if (j1 == null) {
            System.out.println("Jugador 1 no encontrado. Revisar método agregarJugador o la asignación de ID.");
        } else {
            System.out.println("Jugador 1: " + j1.getNombre() + " " + j1.getApellido());
        }

        // --- 6) Pruebo eliminar jugador con try/catch (como tenías) ---
        try {
            boolean eliminado = sistema.eliminarJugador(1);
            System.out.println("eliminarJugador(1) -> " + eliminado);
        } catch (Exception e) {
            System.out.println("Excepción al eliminar jugador 1:");
            e.printStackTrace();
        }

        // --- 7) Pruebo volver a agregar entrenador y eliminar (ejemplo de CRUD) ---
        ok = sistema.agregarEntrenador("Roberto", "Ruiz", 1212121, LocalDate.of(2012, 9, 3), "metergoles");
        System.out.println("re-agregarEntrenador Roberto Ruiz -> " + ok);
        Entrenador eRepetido = sistema.traerEntrenador(1); // chequear cuál ID te devuelve
        System.out.println("traerEntrenador(1) -> " + (eRepetido != null ? eRepetido.getApellido() : "null"));

        try {
            boolean elimEntr = sistema.eliminarEntrenador(1);
            System.out.println("eliminarEntrenador(1) -> " + elimEntr);
        } catch (Exception e) {
            System.out.println("Excepción al eliminar entrenador 1:");
            e.printStackTrace();
        }

        // --- 8) Generar tabla de posiciones / goleadores con validaciones ---
        List<Posicion> tabla = torneo.generarTablaPosiciones();
        if (tabla != null) {
            System.out.println("TABLA DE POSICIONES");
            for (int i = 0; i < tabla.size(); i++) {
                Posicion p = tabla.get(i);
                System.out.println((i + 1) + "° " + p.getEquipo().getNombre() + " - " + p.getPuntos() + " pts");
            }
        } else {
            System.out.println("No se pudo generar tabla de posiciones (null).");
        }

        // --- 9) Ejemplo de creación y uso de Partido/Participaciones independiente ---
        // Creo jugadores locales para pruebas
        Jugador p1 = new Jugador("Lionel", "Messi", 999, LocalDate.of(1987,6,24), 0,0,0, "",0, 0);
        Jugador p2 = new Jugador("Angel", "Di María", 998, LocalDate.of(1988,2,14), 0,0,0, "",0, 0);
        Jugador p3 = new Jugador("Julian", "Álvarez", 997, LocalDate.of(2000,1,31), 0,0,0, "",0, 0);

        Equipo e1 = new Equipo(100, "EquipoA", entrenador1, "EQA", LocalDate.now());
        Equipo e2 = new Equipo(101, "EquipoB", entrenador2, "EQB", LocalDate.now());

        Partido partido11 = new Partido(1, "Estadio A", e1, e2, LocalDate.of(2025, 5, 1));
        ParticipacionPartido pp1 = new ParticipacionPartido(p1, 2);
        ParticipacionPartido pp2 = new ParticipacionPartido(p2, 1);
        ParticipacionPartido pp3 = new ParticipacionPartido(p3, 1);

        partido11.getListParticipacionPartido().add(pp1);
        partido11.getListParticipacionPartido().add(pp2);
        partido11.getListParticipacionPartido().add(pp3);

        torneo.getLstPartidos().add(partido11); // si getLstPartidos() devuelve null, esto fallará -> comprobar si fuera necesario.

        System.out.println("Test finalizado correctamente.");
        
        ArrayList<Goleador> goleadores = torneo.generarTablaGoleadores();
        System.out.println("\nTABLA DE GOLEADORES");
        int posG = 1;
        for (Goleador g : goleadores) {
            System.out.println(posG + "° " + g.getJugador().getNombre() + " " + g.getJugador().getApellido() +
                    " - Goles: " + g.getGoles());
            posG++;
        }

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

