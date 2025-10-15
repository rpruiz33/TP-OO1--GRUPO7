package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private List<Partido> lstPartidos;
    private List<Jugador> lstJugadores;

    private List<Entrenador> lstEntrenadores;
    private List<Torneo> lstTorneos;

    public Sistema() {
        super();
        this.lstPartidos = new ArrayList<Partido>();
        this.lstJugadores = new ArrayList<Jugador>();
        this.lstEntrenadores = new ArrayList<Entrenador>();
        this.lstTorneos = new ArrayList<Torneo>();

    }

    public List<Torneo> getLstTorneos() {
        return lstTorneos;
    }

    public void setLstTorneos(List<Torneo> lstTorneos) {
        this.lstTorneos = lstTorneos;
    }

    public List<Partido> getLstPartidos() {
        return lstPartidos;
    }

    public void setLstPartidos(List<Partido> lstPartidos) {
        this.lstPartidos = lstPartidos;
    }

    public List<Jugador> getLstJugadores() {
        return lstJugadores;
    }

    public void setLstJugadores(List<Jugador> lstJugadores) {
        this.lstJugadores = lstJugadores;
    }

    public List<Entrenador> getLstEntrenadores() {
        return lstEntrenadores;
    }

    public void setLstEntrenadores(List<Entrenador> lstEntrenadores) {
        this.lstEntrenadores = lstEntrenadores;
    }

    /*1. Generar todos los métodos para que se puedan agregar elementos a todas las
    listas.
    2. Generar los métodos eliminar solo si necesarios (física o lógica) elementos a
    todas las listas por regla de negocio. Por ejemplo baja a un jugador del equipo.
    3. Generar todos los métodos traer por atributo único (o id)*/

    public boolean agregarPartido(String estadio, Equipo equipoLocal, Equipo equipoVisitante, LocalDate fechaPartido) {
        int id = 1;
        if (!lstPartidos.isEmpty()) {
            id = lstPartidos.get(lstPartidos.size() - 1).getId() + 1;
        }

        Partido p = new Partido(id, estadio, equipoLocal, equipoVisitante, fechaPartido);
        return lstPartidos.add(p);
    }

    public Partido traerPartido(int idPartido) {
        int i = 0;
        boolean encontrado = false;
        Partido aux = null;
        while (i < lstPartidos.size() && !encontrado) {
            if (lstPartidos.get(i).getId() == idPartido) {
                aux = lstPartidos.get(i);
                encontrado = true;
            }
            i++;
        }
        return aux;
    }

    public boolean eliminarPartido(int idPartido) throws Exception {
        Partido aux = traerPartido(idPartido);
        if (aux == null) throw new Exception("El partido no existe");
        return lstPartidos.remove(aux);
    }

    public boolean agregarJugador(String nombre, String apellido, int dni, LocalDate fechaNacimiento,
                                  float peso, float estatura, String posicion, int numCamiseta) {
        int id = 1;
        if (!lstJugadores.isEmpty()) {
            id = lstJugadores.get(lstJugadores.size() - 1).getId() + 1;
        }

        Jugador j = new Jugador(nombre, apellido, dni, fechaNacimiento, id, peso, estatura, posicion, numCamiseta);

        return lstJugadores.add(j);
    }

    public Jugador traerJugador(int idJugador) {
        int i = 0;
        boolean encontrado = false;
        Jugador aux = null;
        while (lstJugadores.size() > i && !encontrado) {
            if (lstJugadores.get(i).getId() == idJugador) {
                aux = lstJugadores.get(i);
                encontrado = true;
            }
            i++;
        }
        return aux;
    }

    public boolean eliminarJugador(int idJugador) throws Exception {
        Jugador aux = traerJugador(idJugador);
        if (aux == null) throw new Exception("El jugador no existe");
        return lstJugadores.remove(aux);
    }

    public boolean agregarEntrenador(String nombre, String apellido, int dni, LocalDate fechaNacimiento,
                                     String estrategiaFavorita) {
        int id = 1;
        if (!lstEntrenadores.isEmpty()) {
            id = lstEntrenadores.get(lstEntrenadores.size() - 1).getId() + 1;
        }
        Entrenador e = new Entrenador(id, nombre, apellido, dni, fechaNacimiento, estrategiaFavorita);
        return lstEntrenadores.add(e);
    }

    public Entrenador traerEntrenador(int idEntrenador) {
        int i = 0;
        boolean encontrado = false;
        Entrenador aux = null;
        while (i < lstEntrenadores.size() && !encontrado) {
            if (lstEntrenadores.get(i).getId() == idEntrenador) {
                aux = lstEntrenadores.get(i);
                encontrado = true;
            }
            i++;
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

    public boolean agregarTorneo(int id, String nombre, String temporada, List<Equipo> lstEquipos, List<Partido> lstPartidos,
                                 LocalDate fechaDeInicio, LocalDate fechaDeFinalizacion, Equipo equipoGanador) {
        int id1 = 1;
        if (!lstTorneos.isEmpty()) {
            id1 = lstTorneos.get(lstTorneos.size() - 1).getId() + 1;
        }

        Torneo t = new Torneo(id1, nombre, temporada, lstEquipos, lstPartidos, fechaDeInicio, fechaDeFinalizacion, equipoGanador);

        return lstTorneos.add(t);
    }

    public Torneo traerTorneo(int idTorneo) {
        int i = 0;
        boolean encontrado = false;
        Torneo aux = null;
        while (i < lstTorneos.size() && !encontrado) {
            if (lstTorneos.get(i).getId() == idTorneo) {
                aux = lstTorneos.get(i);
                encontrado = true;
            }
            i++;
        }
        return aux;
    }

    public boolean eliminarTorneo(int idTorneo) throws Exception {
        Torneo aux = traerTorneo(idTorneo);
        if (aux == null) {
            throw new Exception("El torneo no existe");
        }
        return lstTorneos.remove(aux);
    }

    /*4. Traer para un torneo y un número de fecha, la lista de los equipos ganadores
    utilizando una clase (Ganador, no se persiste es solo para generar reporte) con
    fecha, el equipo ganador, cantidad de goles*/

    public List<Ganador> traerTorneoPorFecha(int idTorneo, LocalDate fecha) {
        Torneo taux = this.traerTorneo(idTorneo);
        List<Ganador> ganadores = new ArrayList<>();

        if (taux != null) {
            for (int j = 0; j < taux.getLstPartidos().size(); j++) {
                Partido partido = taux.getLstPartidos().get(j);
                if (partido.getFechaPartido().equals(fecha)) {
                    if (partido.getListParticipacionPartido().size() >= 2) {
                        int golesLocal = partido.getListParticipacionPartido().get(0).getGolesMetio();
                        int golesVisitante = partido.getListParticipacionPartido().get(1).getGolesMetio();
                        if (golesLocal > golesVisitante) {
                            ganadores.add(new Ganador(fecha, partido.getEquipoLocal(), golesLocal));
                        } else if (golesVisitante > golesLocal) {
                            ganadores.add(new Ganador(fecha, partido.getEquipoVisitante(), golesVisitante));
                        }
                    }
                }
            }
        }
        return ganadores;
    }

    /* Búsqueda de entrenadores: Crear un método que, dada una táctica preferida,
    devuelva una lista de todos los entrenadores que la utilicen*/

    public List<Entrenador> busquedaEntrenadoresPorTactica(String tacticaPreferida) {
        List<Entrenador> listAux = new ArrayList<Entrenador>();
        for (int g = 0; g < lstEntrenadores.size(); g++) {
            if (lstEntrenadores.get(g).getEstrategiaFavorita().equals(tacticaPreferida)) {
                listAux.add(lstEntrenadores.get(g));
            }
        }
        return listAux;
    }

    /*Búsqueda de jugadores por fecha de nacimiento: Implementar una método que
    retorne una lista de jugadores nacidos entre dos fechas dadas.*/

    public List<Jugador> jugadoresFechaNacimento(LocalDate fecha1, LocalDate fecha2) {
        List<Jugador> listAux = new ArrayList<Jugador>();
        for (int g = 0; g < lstJugadores.size(); g++) {
            LocalDate fn = lstJugadores.get(g).getFechaNacimiento();
            if (!( fn.isBefore(fecha1) && fn.isAfter(fecha2))) {
                listAux.add(lstJugadores.get(g));
            }
        }
        return listAux;
    }

}
