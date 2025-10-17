package test;

import modelo.*;
import java.time.LocalDate;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("=== INICIO DEL TEST TORNEO CLAUSURA 2025 ===\n");

        // ========================
        // 1. Crear entrenadores
        // ========================
        System.out.println("-- Creando entrenadores --");
        Entrenador entrenadorLeones = new Entrenador(1, "Carlos", "Gómez", 12345678, LocalDate.of(1970, 5, 10), "4-4-2");
        Entrenador entrenadorTigres = new Entrenador(2, "Luis", "Martínez", 22345678, LocalDate.of(1975, 8, 21), "4-3-3");
        Entrenador entrenadorHalcones = new Entrenador(3, "Jorge", "Pérez", 32345678, LocalDate.of(1972, 2, 14), "3-5-2");
        Entrenador entrenadorLobos = new Entrenador(4, "Andrés", "Suárez", 42345678, LocalDate.of(1978, 12, 30), "5-3-2");
        System.out.println("Entrenadores creados.\n");

        // ========================
        // 2. Crear torneo
        // ========================
        System.out.println("-- Creando torneo --");
        Torneo clausura2025 = new Torneo(1, "T001", "Torneo Clausura 2025",
                "2025", LocalDate.of(2025, 10, 1), LocalDate.of(2025, 10, 14));
        System.out.println("Torneo creado: " + clausura2025.getNombre() + "\n");

        // ========================
        // 3. Agregar equipos
        // ========================
        System.out.println("-- Agregando equipos --");
        clausura2025.agregarEquipo("Leones", entrenadorLeones, "E001", LocalDate.of(2010,1,1));
        clausura2025.agregarEquipo("Tigres", entrenadorTigres, "E002", LocalDate.of(2012,3,15));
        clausura2025.agregarEquipo("Halcones", entrenadorHalcones, "E003", LocalDate.of(2015,7,20));
        clausura2025.agregarEquipo("Lobos", entrenadorLobos, "E004", LocalDate.of(2013,9,5));
        System.out.println("Equipos agregados.\n");

        Equipo leones = clausura2025.traerEquipo(1);
        Equipo tigres = clausura2025.traerEquipo(2);
        Equipo halcones = clausura2025.traerEquipo(3);
        Equipo lobos = clausura2025.traerEquipo(4);

        // ========================
        // 4. Agregar jugadores
        // ========================
        System.out.println("-- Agregando jugadores a equipos --");

        // Leones
        leones.agregarJugador("Juan","Pérez",11111111,LocalDate.of(2000,2,10),75,1.80f,"Delantero",9);
        leones.agregarJugador("Martín","López",11111112,LocalDate.of(1998,6,12),78,1.82f,"Defensor",4);
        leones.agregarJugador("Lucas","Díaz",11111113,LocalDate.of(2001,4,18),70,1.75f,"Mediocampista",8);
        leones.agregarJugador("Franco","Ruiz",11111114,LocalDate.of(1999,11,3),82,1.85f,"Arquero",1);
        leones.agregarJugador("Agustín","Torres",11111115,LocalDate.of(2002,7,21),74,1.78f,"Delantero",11);
        System.out.println("Jugadores agregados a Leones.");

        // Tigres
        tigres.agregarJugador("Diego","González",22222221,LocalDate.of(1999,2,4),80,1.83f,"Arquero",1);
        tigres.agregarJugador("Nicolás","Romero",22222222,LocalDate.of(1997,9,10),77,1.80f,"Defensor",2);
        tigres.agregarJugador("Rodrigo","Sosa",22222223,LocalDate.of(2000,12,12),73,1.74f,"Mediocampista",8);
        tigres.agregarJugador("Matías","Vera",22222224,LocalDate.of(2002,1,5),76,1.79f,"Delantero",9);
        tigres.agregarJugador("Pablo","Castro",22222225,LocalDate.of(1998,5,22),79,1.81f,"Defensor",5);
        System.out.println("Jugadores agregados a Tigres.");

        // Halcones
        halcones.agregarJugador("Emiliano","Cabrera",33333331,LocalDate.of(1999,3,14),84,1.86f,"Arquero",1);
        halcones.agregarJugador("Javier","Morales",33333332,LocalDate.of(2001,10,19),76,1.79f,"Defensor",3);
        halcones.agregarJugador("Gonzalo","Rivas",33333333,LocalDate.of(2000,8,30),74,1.77f,"Mediocampista",8);
        halcones.agregarJugador("Lautaro","Fernández",33333334,LocalDate.of(2003,2,17),79,1.83f,"Delantero",10);
        halcones.agregarJugador("Mateo","Blanco",33333335,LocalDate.of(2002,4,23),70,1.72f,"Mediocampista",6);
        System.out.println("Jugadores agregados a Halcones.");

        // Lobos
        lobos.agregarJugador("Facundo","Herrera",44444441,LocalDate.of(1998,12,8),82,1.84f,"Arquero",1);
        lobos.agregarJugador("Ignacio","Ramos",44444442,LocalDate.of(1999,9,1),76,1.80f,"Defensor",4);
        lobos.agregarJugador("Tomás","Benítez",44444443,LocalDate.of(2000,5,15),73,1.74f,"Mediocampista",8);
        lobos.agregarJugador("Sebastián","Luna",44444444,LocalDate.of(2001,7,7),78,1.81f,"Delantero",9);
        lobos.agregarJugador("Enzo","Correa",44444445,LocalDate.of(2002,3,28),75,1.78f,"Defensor",2);
        System.out.println("Jugadores agregados a Lobos.\n");

        // ========================
        // 5. Crear partidos y estadísticas
        // ========================
        System.out.println("-- Agregando partidos y estadísticas --");

        // Partido 1: Leones 2 - 1 Tigres
        clausura2025.agregarPartido("Estadio Central", leones, tigres, LocalDate.of(2025,10,10));
        Partido p1 = clausura2025.traerPartido(1);
        p1.agregarParticipacion(leones.getLstJugadores().get(0),1,0,90); // Juan Pérez
        p1.agregarParticipacion(leones.getLstJugadores().get(4),1,0,85); // Agustín Torres
        p1.agregarParticipacion(tigres.getLstJugadores().get(3),1,0,90); // Matías Vera
        System.out.println("Partido 1 agregado con goles y asistencias.");

        // Partido 2: Halcones 1 - 1 Lobos
        clausura2025.agregarPartido("Estadio Norte", halcones, lobos, LocalDate.of(2025,10,17));
        Partido p2 = clausura2025.traerPartido(2);
        p2.agregarParticipacion(halcones.getLstJugadores().get(3),1,0,90); // Lautaro
        p2.agregarParticipacion(lobos.getLstJugadores().get(3),1,0,90); // Sebastián Luna
        System.out.println("Partido 2 agregado con goles y asistencias.");

        // Partido 3: Leones 3 - 0 Halcones
        clausura2025.agregarPartido("Estadio Central", leones, halcones, LocalDate.of(2025,10,24));
        Partido p3 = clausura2025.traerPartido(3);
        p3.agregarParticipacion(leones.getLstJugadores().get(0),2,0,90); // Juan Pérez
        p3.agregarParticipacion(leones.getLstJugadores().get(4),1,0,90); // Agustín Torres
        System.out.println("Partido 3 agregado con goles y asistencias.");

        // Partido 4: Tigres 0 - 2 Lobos
        clausura2025.agregarPartido("Estadio Sur", tigres, lobos, LocalDate.of(2025,10,31));
        Partido p4 = clausura2025.traerPartido(4);
        p4.agregarParticipacion(lobos.getLstJugadores().get(3),1,0,90); // Sebastián Luna
        p4.agregarParticipacion(lobos.getLstJugadores().get(4),1,0,90); // Enzo Correa
        System.out.println("Partido 4 agregado con goles y asistencias.");

        // Partido 5: Leones 1 - 3 Lobos
        clausura2025.agregarPartido("Estadio Central", leones, lobos, LocalDate.of(2025,11,7));
        Partido p5 = clausura2025.traerPartido(5);
        p5.agregarParticipacion(leones.getLstJugadores().get(4),1,0,90); // Agustín Torres
        p5.agregarParticipacion(lobos.getLstJugadores().get(3),2,0,80); // Sebastián Luna
        p5.agregarParticipacion(lobos.getLstJugadores().get(4),1,0,90); // Enzo Correa
        System.out.println("Partido 5 agregado con goles y asistencias.");

        // Partido 6: Tigres 2 - 2 Halcones
        clausura2025.agregarPartido("Estadio Sur", tigres, halcones, LocalDate.of(2025,11,14));
        Partido p6 = clausura2025.traerPartido(6);
        p6.agregarParticipacion(tigres.getLstJugadores().get(2),1,0,80); // Rodrigo Sosa
        p6.agregarParticipacion(tigres.getLstJugadores().get(3),1,0,90); // Matías Vera
        p6.agregarParticipacion(halcones.getLstJugadores().get(2),1,0,85); // Gonzalo Rivas
        p6.agregarParticipacion(halcones.getLstJugadores().get(3),1,0,90); // Lautaro Fernández
        System.out.println("Partido 6 agregado con goles y asistencias.\n");

        // ========================
        // 6. Imprimir resultados
        // ========================
        System.out.println("--- TABLA DE POSICIONES ---");
        List<Posicion> tablaPosiciones = clausura2025.generarTablaPosiciones();
        for(Posicion pos: tablaPosiciones){
            System.out.println(pos.getEquipo().getNombre() + " - " + pos.getPuntos() + " pts");
        }

        System.out.println("\n--- GOLEADORES ---");
        List<Goleador> tablaGoleadores = clausura2025.generarTablaGoleadores();
        for(Goleador g: tablaGoleadores){
            System.out.println(g.getJugador().getNombre() + " " + g.getJugador().getApellido() + " - " + g.getGoles());
        }

        System.out.println("\n--- ASISTIDORES ---");
        List<Asistencia> tablaAsistencias = clausura2025.generarTablaAsistidores();
        for(Asistencia a: tablaAsistencias){
            System.out.println(a.getJugador().getNombre() + " " + a.getJugador().getApellido() + " - " + a.getAsistencias());
        }

        System.out.println("\n=== FIN DEL TEST TORNEO CLAUSURA 2025 ===");
    }
}
