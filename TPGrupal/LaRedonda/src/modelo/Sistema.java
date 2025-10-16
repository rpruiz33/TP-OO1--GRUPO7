package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sistema {

    private List<Partido> lstPartidos;
    private List<Jugador> lstJugadores;
    private List<Entrenador> lstEntrenadores;
    private List<Torneo> lstTorneos;
    private List<Asistencia> lstAsistencias; // 👈 NUEVO

    public Sistema() {
        super();
        this.lstPartidos = new ArrayList<Partido>();
        this.lstJugadores = new ArrayList<Jugador>();
        this.lstEntrenadores = new ArrayList<Entrenador>();
        this.lstTorneos = new ArrayList<Torneo>();
        this.lstAsistencias = new ArrayList<Asistencia>(); // 👈 NUEVO
    }

    // ======================  ASISTENCIAS  ========================= //

    public void registrarAsistencia(Jugador jugador) {
        Asistencia asistencia = buscarAsistenciaPorJugador(jugador);
        if (asistencia == null) {
            lstAsistencias.add(new Asistencia(jugador, 1));
        } else {
            asistencia.setAsistencias(asistencia.getAsistencias() + 1);
        }
    }

    private Asistencia buscarAsistenciaPorJugador(Jugador jugador) {
        for (Asistencia a : lstAsistencias) {
            if (a.getJugador().equals(jugador)) {
                return a;
            }
        }
        return null;
    }

    public List<Asistencia> traerTablaAsistencias() {
        return lstAsistencias;
    }

    public List<Asistencia> traerTablaAsistenciasOrdenada() {
        List<Asistencia> copia = new ArrayList<>(lstAsistencias);
        copia.sort(Comparator.comparingInt(Asistencia::getAsistencias).reversed());
        return copia;
    }

    // ===================  PARTIDOS  =================== //

    public boolean agregarPartido(String estadio, Equipo equipoLocal, Equipo equipoVisitante, LocalDate fechaPartido) {
        int id = 1;
        if (lstPartidos.size() > 0) {
            id = lstPartidos.get(lstPartidos.size() - 1).getId() + 1;
        }
        Partido p = new Partido(id, estadio, equipoLocal, equipoVisitante, fechaPartido);
        return lstPartidos.add(p);
    }

    public Partido traerPartido(int idPartido) {
        Partido aux = null;
        int i = 0;
        boolean encontrado = false;

        while (i < lstPartidos.size() && !encontrado) {
            if (lstPartidos.get(i).getId() == idPartido) {
                aux = lstPartidos.get(i);
                encontrado = true;
            } else {
                i++;
            }
        }

        return aux;
    }

    public boolean eliminarPartido(int idPartido) throws Exception {
        Partido aux = traerPartido(idPartido);
        if (aux == null) {
            throw new Exception("El partido no existe");
        }
        return lstPartidos.remove(aux);
    }

    // ===================  JUGADORES  =================== //

    public boolean agregarJugador(String nombre, String apellido, int dni, LocalDate fechaNacimiento,
                                  float peso, float estatura, String posicion, int numCamiseta) {
        int id = 1;
        if (lstJugadores.size() > 0) {
            id = lstJugadores.get(lstJugadores.size() - 1).getId() + 1;
        }
        Jugador j = new Jugador(nombre, apellido, dni, fechaNacimiento, id, peso, estatura, posicion, numCamiseta, 5);
        return lstJugadores.add(j);
    }

    public Jugador traerJugador(int idJugador) {
        Jugador aux = null;
        int i = 0;
        boolean encontrado = false;

        while (i < lstJugadores.size() && !encontrado) {
            if (lstJugadores.get(i).getId() == idJugador) {
                aux = lstJugadores.get(i);
                encontrado = true;
            } else {
                i++;
            }
        }
        return aux;
    }

    public boolean eliminarJugador(int idJugador) throws Exception {
        Jugador aux = traerJugador(idJugador);
        if (aux == null) {
            throw new Exception("El jugador no existe");
        }
        return lstJugadores.remove(aux);
    }

    // ===================  ENTRENADORES  =================== //

    public boolean agregarEntrenador(String nombre, String apellido, int dni, LocalDate fechaNacimiento,
                                     String estrategiaFavorita) {
        int id = 1;
        if (lstEntrenadores.size() > 0) {
            id = lstEntrenadores.get(lstEntrenadores.size() - 1).getId() + 1;
        }
        Entrenador e = new Entrenador(id, nombre, apellido, dni, fechaNacimiento, estrategiaFavorita);
        return lstEntrenadores.add(e);
    }

    public Entrenador traerEntrenador(int idEntrenador) {
        Entrenador aux = null;
        int i = 0;
        boolean encontrado = false;

        while (i < lstEntrenadores.size() && !encontrado) {
            if (lstEntrenadores.get(i).getId() == idEntrenador) {
                aux = lstEntrenadores.get(i);
                encontrado = true;
            } else {
                i++;
            }
        }

        return aux;
    }

    public boolean eliminarEntrenador(int idEntrenador) throws Exception {
        Entrenador aux = traerEntrenador(idEntrenador);
        if (aux == null) {
            throw new Exception("El entrenador no existe");
        }
        return lstEntrenadores.remove(aux);
    }

    // ===================  TORNEOS  =================== //

    public boolean agregarTorneo(int id, String nombre, String temporada, List<Equipo> lstEquipos, List<Partido> lstPartidos,
                                 LocalDate fechaDeInicio, LocalDate fechaDeFinalizacion, Equipo equipoGanador) {
        int id1 = 1;
        if (lstTorneos.size() > 0) {
            id1 = lstTorneos.get(lstTorneos.size() - 1).getId() + 1;
        }
        Torneo t = new Torneo(id1, nombre, temporada, fechaDeInicio, fechaDeFinalizacion, equipoGanador);
        return lstTorneos.add(t);
    }

    public Torneo traerTorneo(int idTorneo) {
        Torneo aux = null;
        int i = 0;
        boolean encontrado = false;

        while (i < lstTorneos.size() && !encontrado) {
            if (lstTorneos.get(i).getId() == idTorneo) {
                aux = lstTorneos.get(i);
                encontrado = true;
            } else {
                i++;
            }
        }

        return aux;
    }

    public boolean eliminarTorneo(int idTorneo) throws Exception {
        Torneo aux = traerTorneo(idTorneo);
        if (aux == null) throw new Exception("El torneo no existe");
        return lstTorneos.remove(aux);
    }



    public List<Entrenador> busquedaEntrenadoresPorTactica(String tacticaPreferida) {
        List<Entrenador> listAux = new ArrayList<Entrenador>();
        for (int g = 0; g < lstEntrenadores.size(); g++) {
            if (lstEntrenadores.get(g).getEstrategiaFavorita().equals(tacticaPreferida)) {
                listAux.add(lstEntrenadores.get(g));
            }
        }
        return listAux;
    }

    public List<Jugador> jugadoresFechaNacimento(LocalDate fecha1, LocalDate fecha2) {
        List<Jugador> listAux = new ArrayList<Jugador>();
        for (int g = 0; g < lstJugadores.size(); g++) {
            LocalDate fn = lstJugadores.get(g).getFechaNacimiento();
            if (!(fn.isBefore(fecha1) && fn.isAfter(fecha2))) {
                listAux.add(lstJugadores.get(g));
            }
        }
        return listAux;
    }

    public void mostrarTablaAsistidores() {
        if (lstAsistencias.isEmpty()) {
            System.out.println("No hay asistencias registradas.");
        } else {
            System.out.println("===TABLA DE ASISTIDORES ===");
            for (Asistencia a : lstAsistencias) {
                System.out.println("Jugador: " + a.getJugador().getNombre() + " " 
                                   + a.getJugador().getApellido() 
                                   + " | Asistencias: " + a.getAsistencias());
            }
        }
    }

}
