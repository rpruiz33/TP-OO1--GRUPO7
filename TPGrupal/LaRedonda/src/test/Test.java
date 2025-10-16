package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.*;

public class Test {
    public static void main(String[] args) {

        Sistema sistema = new Sistema();
        sistema.agregarEntrenador("nombre", "apellido", 37969779, LocalDate.of(1993, 12, 10), "estrategiaFavorita");
        System.out.println(sistema.agregarEntrenador("roberto", "Ruiz", 1212121, LocalDate.of(2012, 9, 3), "metergoles"));
        System.out.println(sistema.agregarTorneo(1, "mundial", "1", null, null, LocalDate.of(2025, 3, 3), LocalDate.of(2025, 3, 3), null));

        Jugador j1 = new Jugador("Lionel", "Messi", 0, null, 0, 0, 0, null, 0, 0);
        Jugador j2 = new Jugador("Ángel", "Di María", 0, null, 0, 0, 0, null, 0, 0);
        Jugador j3 = new Jugador("Julián", "Álvarez", 0, null, 0, 0, 0, null, 0, 0);

        Equipo equipo4 = new Equipo(1, "Republica del Congo", sistema.traerEntrenador(1), "con", LocalDate.of(2025, 3, 3));
        Equipo equipo3 = new Equipo(1, "Malasia", sistema.traerEntrenador(1), "mal", LocalDate.of(2020, 10, 10));

        Torneo torneo = sistema.traerTorneo(1);


        torneo.agregarEquipo("singapur", sistema.traerEntrenador(2), "MAL", LocalDate.of(2020, 10, 10));

        System.out.println(sistema.traerTorneo(1).agregarPartido("river", equipo4, equipo3, LocalDate.of(2025, 3, 3)));

        sistema.agregarJugador("nombre", "apellido", 11111, LocalDate.of(2025, 12, 3), 120.f, 120.f, "1", 2);
        System.out.println(sistema.getLstJugadores());
        System.out.println(sistema.traerJugador(1));

        try {
            System.out.println(sistema.eliminarJugador(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(sistema.agregarEntrenador("roberto", "Ruiz", 1212121, LocalDate.of(2012, 9, 3), "metergoles"));
        System.out.println(sistema.traerEntrenador(1));

        try {
            System.out.println(sistema.eliminarEntrenador(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(sistema.agregarEntrenador("roberto", "Ruiz", 1212121, LocalDate.of(2012, 9, 3), "metergoles"));
        System.out.println(sistema.getLstTorneos().get(0).agregarEquipo("Malasia", sistema.traerEntrenador(0), "mal", LocalDate.of(2020, 10, 10)));
        System.out.println(sistema.getLstTorneos().get(0).agregarPartido("bocaa", sistema.traerTorneo(1).traerEquipo(1), sistema.traerTorneo(1).traerEquipo(1), LocalDate.of(2025, 3, 3)));
        System.out.println(sistema.getLstTorneos().get(0).agregarPartido("bocaa", sistema.traerTorneo(1).traerEquipo(1), sistema.traerTorneo(1).traerEquipo(1), LocalDate.of(2025, 3, 3)));
        System.out.println(sistema.agregarTorneo(2, "libertadores", "1", sistema.getLstTorneos().get(0).getLstEquipos(), sistema.getLstPartidos(), LocalDate.of(2025, 6, 3), LocalDate.of(2026, 3, 2), sistema.traerTorneo(1).traerEquipo(0)));
        System.out.println(sistema.traerTorneo(1));

        try {
            System.out.println(sistema.eliminarTorneo(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(sistema.traerTorneoPorFecha(1, LocalDate.of(2025, 3, 3)));
        System.out.println(sistema.agregarEntrenador("roberto", "Ruiz", 1212121, LocalDate.of(2012, 9, 3), "metergoles"));
        System.out.println(sistema.busquedaEntrenadoresPorTactica("metergoles"));

        sistema.agregarJugador("nombre", "apellido", 11111, LocalDate.of(2025, 12, 3), 120.f, 120.f, "1", 2);
        System.out.println(sistema.jugadoresFechaNacimento(LocalDate.of(1991, 1, 2), LocalDate.of(2025, 12, 24)));

        Equipo equipo1 = new Equipo(1, "Republica del Congo", sistema.traerEntrenador(1), "CON", LocalDate.of(2025, 3, 3));
        Equipo equipo2 = new Equipo(2, "Malasia", sistema.traerEntrenador(2), "MAL", LocalDate.of(2020, 10, 10));

        torneo.agregarEquipo("Republica del Congo", sistema.traerEntrenador(1), "CON", LocalDate.of(2025, 3, 3));
        torneo.agregarEquipo("Malasia", sistema.traerEntrenador(2), "MAL", LocalDate.of(2020, 10, 10));

        // Traer equipos usando for tradicional
        Equipo local = null;
        Equipo visitante = null;
        for (int i = 0; i < torneo.getLstEquipos().size(); i++) {
            if (torneo.getLstEquipos().get(i).getId() == 1) local = torneo.getLstEquipos().get(i);
            if (torneo.getLstEquipos().get(i).getId() == 2) visitante = torneo.getLstEquipos().get(i);
        }

        if (local == null || visitante == null) {
            System.out.println("Los equipos no existen todavía");
            return;
        }

        sistema.agregarPartido("Estadio Principal", local, visitante, LocalDate.of(2025, 3, 3));

        System.out.println(torneo.traerEquipo(1).agregarPuntos(3));
        System.out.println(torneo.traerEquipo(1).agregarPuntos(1));
        System.out.println(torneo.traerEquipo(1).agregarPuntos(3));

        torneo.agregarPartido("River", torneo.traerEquipo(1), torneo.traerEquipo(2), LocalDate.of(2025, 3, 3));

        System.out.println("------------------");

        ArrayList<Jugador> jugadoresPartido = new ArrayList<Jugador>();
        jugadoresPartido.add(sistema.traerJugador(1));

        EstadisticaParticipacionPartido est1 = new EstadisticaParticipacionPartido(1, torneo.traerEquipo(0), torneo.traerEquipo(1), torneo.traerEquipo(0), "River", 2, 1, 90, LocalDate.of(2025, 3, 3), 2);
        EstadisticaParticipacionPartido est2 = new EstadisticaParticipacionPartido(2, torneo.traerEquipo(1), torneo.traerEquipo(0), torneo.traerEquipo(1), "Boca", 1, 0, 90, LocalDate.of(2025, 3, 10), 23);

        Partido partido1 = torneo.getLstPartidos().get(0);

        // Participaciones usando for tradicional
        for (int i = 0; i < est1.getListJugadorJugo().size(); i++) {
            Jugador j = est1.getListJugadorJugo().get(i);
            partido1.agregarParticipacion(j, est1.getGolesMetio(), est1.getAsistenciaParitodo(), est1.getMinutosJugados());
        }
        for (int i = 0; i < est2.getListJugadorJugo().size(); i++) {
            Jugador j = est2.getListJugadorJugo().get(i);
            partido1.agregarParticipacion(j, est2.getGolesMetio(), est2.getAsistenciaParitodo(), est2.getMinutosJugados());
        }

        List<Posicion> tabla = torneo.generarTablaPosiciones();
        System.out.println("TABLA DE POSICIONES");

        for (int i = 0; i < tabla.size(); i++) {
            Posicion p = tabla.get(i);
            System.out.println((i + 1) + "° " + p.getEquipo().getNombre() + " - " + p.getPuntos() + " pts");
        }

        Partido partido11 = new Partido(1, "Estadio A", equipo1, equipo2, LocalDate.of(2025, 5, 1));

        ParticipacionPartido pp1 = new ParticipacionPartido(j1, 2);
        ParticipacionPartido pp2 = new ParticipacionPartido(j2, 1);
        ParticipacionPartido pp3 = new ParticipacionPartido(j3, 1);

        partido11.getListParticipacionPartido().add(pp1);
        partido11.getListParticipacionPartido().add(pp2);
        partido11.getListParticipacionPartido().add(pp3);

        EstadisticaParticipacionPartido est11 = new EstadisticaParticipacionPartido(0, visitante, visitante, visitante, null, 0, 0, 0, null, 0);
        est11.setListJugadorJugo(new ArrayList<Jugador>());
        est11.getListJugadorJugo().add(j1);
        est11.getListJugadorJugo().add(j2);
        est11.getListJugadorJugo().add(j3);
        est11.setAsistenciaParitodo(1);

        partido11.setEstadisticas(new ArrayList<EstadisticaParticipacionPartido>());
        partido11.getEstadisticas().add(est11);

        torneo.getLstPartidos().add(partido11);

        ArrayList<Goleador> goleadores = torneo.generarTablaGoleadores();
        System.out.println();
        System.out.println("TABLA DE GOLEADORES");
        int pos = 1;
        for (int i = 0; i < goleadores.size(); i++) {
            Goleador g = goleadores.get(i);
            System.out.println(pos + "° " + g.getJugador().getNombre() + " " + g.getJugador().getApellido() +
                    " - Goles: " + g.getGoles());
            pos++;
        }
        
        ArrayList<Asistencia> asistidores = torneo.generarTablaAsistidores();
        System.out.println("\nTABLA DE ASISTIDORES");
        pos = 1;
        for (int i = 0; i < asistidores.size(); i++) {
            Asistencia a = asistidores.get(i);
            System.out.println(pos + "° " + a.getJugador().getNombre() + " " + a.getJugador().getApellido() +
                    " - Asistencias: " + a.getAsistencias());
            pos++;
        }
    }
}
