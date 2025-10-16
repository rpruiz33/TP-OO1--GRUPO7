package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Torneo {
    private int id;
    private String nombre;
    private String temporada;
    private List<Equipo> lstEquipos;
    private List<Partido> lstPartidos;
    private LocalDate fechaDeInicio;
    private LocalDate fechaDeFinalizacion;
    private Equipo equipoGanador;

    public Torneo(int id, String nombre, String temporada,
                  LocalDate fechaDeInicio, LocalDate fechaDeFinalizacion, Equipo equipoGanador) {
        this.id = id;
        this.nombre = nombre;
        this.temporada = temporada;
        this.lstEquipos = new ArrayList<Equipo>();
        this.lstPartidos = new ArrayList<Partido>();
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeFinalizacion = fechaDeFinalizacion;
        this.equipoGanador = equipoGanador;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTemporada() { return temporada; }
    public void setTemporada(String temporada) { this.temporada = temporada; }

    public List<Equipo> getLstEquipos() { return lstEquipos; }
    public void setLstEquipos(List<Equipo> lstEquipos) { this.lstEquipos = lstEquipos; }

    public List<Partido> getLstPartidos() { return lstPartidos; }
    public void setLstPartidos(List<Partido> lstPartidos) { this.lstPartidos = lstPartidos; }

    public LocalDate getFechaDeInicio() { return fechaDeInicio; }
    public void setFechaDeInicio(LocalDate fechaDeInicio) { this.fechaDeInicio = fechaDeInicio; }

    public LocalDate getFechaDeFinalizacion() { return fechaDeFinalizacion; }
    public void setFechaDeFinalizacion(LocalDate fechaDeFinalizacion) { this.fechaDeFinalizacion = fechaDeFinalizacion; }

    public Equipo getEquipoGanador() { return equipoGanador; }
    public void setEquipoGanador(Equipo equipoGanador) { this.equipoGanador = equipoGanador; }

    // Métodos para agregar, traer y eliminar equipos
    public boolean agregarEquipo(String nombre, Entrenador e1, String codigo, LocalDate fechaFundacion) {
        int id = lstEquipos.isEmpty() ? 1 : lstEquipos.get(lstEquipos.size() - 1).getId() + 1;
        return lstEquipos.add(new Equipo(id, nombre, e1, codigo, fechaFundacion));
    }

    public Equipo traerEquipo(int idEquipo) {
        Equipo aux = null;
        for (int i = 0; i < lstEquipos.size(); i++) {
            if (lstEquipos.get(i).getId() == idEquipo) {
                aux = lstEquipos.get(i);
                break;
            }
        }
        return aux;
    }

    public boolean eliminarEquipo(int idEquipo) throws Exception {
        Equipo e = traerEquipo(idEquipo);
        if (e == null) throw new Exception("El equipo no existe");
        return lstEquipos.remove(e);
    }

    // Métodos para partidos
    public boolean agregarPartido(String estadio, Equipo equipoLocal, Equipo equipoVisitante, LocalDate fechaPartido) {
        int id = lstPartidos.isEmpty() ? 1 : lstPartidos.get(lstPartidos.size() - 1).getId() + 1;
        return lstPartidos.add(new Partido(id, estadio, equipoLocal, equipoVisitante, fechaPartido));
    }

    public Partido traerPartido(int idPartido) {
        Partido aux = null;
        for (int i = 0; i < lstPartidos.size(); i++) {
            if (lstPartidos.get(i).getId() == idPartido) {
                aux = lstPartidos.get(i);
                break;
            }
        }
        return aux;
    }

    public boolean eliminarPartido(int idPartido) throws Exception {
        Partido p = traerPartido(idPartido);
        if (p == null) throw new Exception("El partido no existe");
        return lstPartidos.remove(p);
    }

    // Generar tabla de posiciones
    public List<Posicion> generarTablaPosiciones() {
        List<Posicion> tabla = new ArrayList<Posicion>();

        for (int i = 0; i < lstPartidos.size(); i++) {
            Partido partido = lstPartidos.get(i);
            Equipo local = partido.getEquipoLocal();
            Equipo visitante = partido.getEquipoVisitante();

            int golesLocal = 0;
            int golesVisitante = 0;

            for (int j = 0; j < partido.getListParticipacionPartido().size(); j++) {
                ParticipacionPartido pp = partido.getListParticipacionPartido().get(j);
                // sumamos goles según equipo
                boolean encontradoLocal = false;
                boolean encontradoVisitante = false;
                for (int k = 0; k < local.getLstJugadores().size(); k++) {
                    if (local.getLstJugadores().get(k).equals(pp.getJugador())) {
                        golesLocal += pp.getGoles();
                        encontradoLocal = true;
                        break;
                    }
                }
                if (!encontradoLocal) {
                    for (int k = 0; k < visitante.getLstJugadores().size(); k++) {
                        if (visitante.getLstJugadores().get(k).equals(pp.getJugador())) {
                            golesVisitante += pp.getGoles();
                            break;
                        }
                    }
                }
            }

            Equipo ganador = null;
            if (golesLocal > golesVisitante) ganador = local;
            else if (golesVisitante > golesLocal) ganador = visitante;

            Posicion posLocal = buscarPosicion(tabla, local);
            Posicion posVisitante = buscarPosicion(tabla, visitante);

            if (posLocal == null) { posLocal = new Posicion(local, 0); tabla.add(posLocal); }
            if (posVisitante == null) { posVisitante = new Posicion(visitante, 0); tabla.add(posVisitante); }

            if (ganador != null) {
                if (ganador.equals(local)) posLocal.sumarPuntos(3);
                else posVisitante.sumarPuntos(3);
            } else { // empate
                posLocal.sumarPuntos(1);
                posVisitante.sumarPuntos(1);
            }
        }

        // ordenar tabla
        for (int i = 0; i < tabla.size() - 1; i++) {
            for (int j = i + 1; j < tabla.size(); j++) {
                if (tabla.get(j).getPuntos() > tabla.get(i).getPuntos()) {
                    Posicion temp = tabla.get(i);
                    tabla.set(i, tabla.get(j));
                    tabla.set(j, temp);
                }
            }
        }

        return tabla;
    }

    private Posicion buscarPosicion(List<Posicion> tabla, Equipo equipo) {
        Posicion pb = null;
        for (int i = 0; i < tabla.size(); i++) {
            if (tabla.get(i).getEquipo().equals(equipo)) {
                pb = tabla.get(i);
                break;
            }
        }
        return pb;
    }

    // Generar tabla de goleadores
    public ArrayList<Goleador> generarTablaGoleadores() {
        ArrayList<Goleador> tabla = new ArrayList<Goleador>();

        for (int i = 0; i < lstPartidos.size(); i++) {
            Partido partido = lstPartidos.get(i);
            for (int j = 0; j < partido.getListParticipacionPartido().size(); j++) {
                ParticipacionPartido pp = partido.getListParticipacionPartido().get(j);
                Jugador jugador = pp.getJugador();
                int goles = pp.getGoles();

                Goleador encontrado = null;
                for (int k = 0; k < tabla.size(); k++) {
                    if (tabla.get(k).getJugador().getId() == jugador.getId()) {
                        encontrado = tabla.get(k);
                        break;
                    }
                }

                if (encontrado != null) encontrado.sumarGoles(goles);
                else tabla.add(new Goleador(jugador, goles));
            }
        }

        // ordenar de mayor a menor
        for (int i = 0; i < tabla.size() - 1; i++) {
            for (int j = i + 1; j < tabla.size(); j++) {
                if (tabla.get(j).getGoles() > tabla.get(i).getGoles()) {
                    Goleador temp = tabla.get(i);
                    tabla.set(i, tabla.get(j));
                    tabla.set(j, temp);
                }
            }
        }

        return tabla;
    }

    // Generar tabla de asistidores
    public ArrayList<Asistencia> generarTablaAsistidores() {
        ArrayList<Asistencia> tabla = new ArrayList<Asistencia>();

        for (int i = 0; i < lstPartidos.size(); i++) {
            Partido partido = lstPartidos.get(i);
            ArrayList<EstadisticaParticipacionPartido> estadisticas = partido.getEstadisticas();
            if (estadisticas == null) continue;

            for (int j = 0; j < estadisticas.size(); j++) {
                EstadisticaParticipacionPartido est = estadisticas.get(j);
                if (est.getListJugadorJugo() == null) continue;

                for (int k = 0; k < est.getListJugadorJugo().size(); k++) {
                    Jugador jugador = est.getListJugadorJugo().get(k);
                    Asistencia existente = null;
                    for (int m = 0; m < tabla.size(); m++) {
                        if (tabla.get(m).getJugador().equals(jugador)) {
                            existente = tabla.get(m);
                            break;
                        }
                    }

                    if (existente != null) {
                        existente.setAsistencias(
                            existente.getAsistencias() + est.getAsistenciaParitodo()
                        );
                    } else {
                        tabla.add(new Asistencia(jugador, est.getAsistenciaParitodo()));
                    }
                }
            }
        }

        // ordenar de mayor a menor
        for (int i = 0; i < tabla.size() - 1; i++) {
            for (int j = i + 1; j < tabla.size(); j++) {
                if (tabla.get(j).getAsistencias() > tabla.get(i).getAsistencias()) {
                    Asistencia temp = tabla.get(i);
                    tabla.set(i, tabla.get(j));
                    tabla.set(j, temp);
                }
            }
        }

        return tabla;
    }

    @Override
    public String toString() {
        return "Torneo [id=" + id + ", nombre=" + nombre + ", temporada=" + temporada +
               ", lstEquipos=" + lstEquipos + ", lstPartidos=" + lstPartidos +
               ", fechaDeInicio=" + fechaDeInicio + ", fechaDeFinalizacion=" + fechaDeFinalizacion +
               ", equipoGanador=" + equipoGanador + "]";
    }
}
