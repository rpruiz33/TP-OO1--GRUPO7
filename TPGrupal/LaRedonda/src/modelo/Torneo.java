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
    private String codigo;

    public Torneo(int id, String codigo, String nombre, String temporada,
                  LocalDate fechaDeInicio, LocalDate fechaDeFinalizacion) {
        this.id = id;
        this.nombre = nombre;
        this.temporada = temporada;
        this.lstEquipos = new ArrayList<>();
        this.lstPartidos = new ArrayList<>();
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeFinalizacion = fechaDeFinalizacion;
        this.codigo = codigo;
    }
    
    
    

    public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getTemporada() {
		return temporada;
	}




	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}




	public List<Equipo> getLstEquipos() {
		return lstEquipos;
	}




	public void setLstEquipos(List<Equipo> lstEquipos) {
		this.lstEquipos = lstEquipos;
	}




	public List<Partido> getLstPartidos() {
		return lstPartidos;
	}




	public void setLstPartidos(List<Partido> lstPartidos) {
		this.lstPartidos = lstPartidos;
	}




	public LocalDate getFechaDeInicio() {
		return fechaDeInicio;
	}




	public void setFechaDeInicio(LocalDate fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}




	public LocalDate getFechaDeFinalizacion() {
		return fechaDeFinalizacion;
	}




	public void setFechaDeFinalizacion(LocalDate fechaDeFinalizacion) {
		this.fechaDeFinalizacion = fechaDeFinalizacion;
	}




	public Equipo getEquipoGanador() {
		return equipoGanador;
	}




	public void setEquipoGanador(Equipo equipoGanador) {
		this.equipoGanador = equipoGanador;
	}




	public String getCodigo() {
		return codigo;
	}




	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}




	// ---- Métodos de gestión de equipos ----
    public boolean agregarEquipo(String nombre, Entrenador e1, String codigo, LocalDate fechaFundacion) {
        int id = lstEquipos.isEmpty() ? 1 : lstEquipos.get(lstEquipos.size() - 1).getId() + 1;
        return lstEquipos.add(new Equipo(id, nombre, e1, codigo, fechaFundacion));
    }

    public Equipo traerEquipo(int idEquipo) {
        for (Equipo e : lstEquipos) {
            if (e.getId() == idEquipo) return e;
        }
        return null;
    }

    public boolean eliminarEquipo(int idEquipo) throws Exception {
        Equipo e = traerEquipo(idEquipo);
        if (e == null) throw new Exception("El equipo no existe");
        return lstEquipos.remove(e);
    }

    // ---- Métodos de gestión de partidos ----
    public boolean agregarPartido(String estadio, Equipo local, Equipo visitante, LocalDate fechaPartido) {
        int id = lstPartidos.isEmpty() ? 1 : lstPartidos.get(lstPartidos.size() - 1).getId() + 1;
        return lstPartidos.add(new Partido(id, estadio, local, visitante, fechaPartido));
    }

    public Partido traerPartido(int idPartido) {
        for (Partido p : lstPartidos) {
            if (p.getId() == idPartido) return p;
        }
        return null;
    }

    public boolean eliminarPartido(int idPartido) throws Exception {
        Partido p = traerPartido(idPartido);
        if (p == null) throw new Exception("El partido no existe");
        return lstPartidos.remove(p);
    }

    // ---- Tabla de posiciones ----
    public List<Posicion> generarTablaPosiciones() {
        List<Posicion> tabla = new ArrayList<>();

        for (Partido partido : lstPartidos) {
            Equipo local = partido.getEquipoLocal();
            Equipo visitante = partido.getEquipoVisitante();

            int golesLocal = 0;
            int golesVisitante = 0;

            // Sumar goles de los jugadores
            for (ParticipacionPartido pp : partido.getListParticipacionPartido()) {
                if (local.getLstJugadores().contains(pp.getJugador())) {
                    golesLocal += pp.getGoles();
                } else if (visitante.getLstJugadores().contains(pp.getJugador())) {
                    golesVisitante += pp.getGoles();
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
                if (ganador.equals(local)) posLocal.setPuntos(posLocal.getPuntos() + 3);
                else posVisitante.setPuntos(posVisitante.getPuntos() + 3);
            } else { // Empate
                posLocal.setPuntos(posLocal.getPuntos() + 1);
                posVisitante.setPuntos(posVisitante.getPuntos() + 1);
            }
        }

        // Orden descendente por puntos
        tabla.sort((p1, p2) -> Integer.compare(p2.getPuntos(), p1.getPuntos()));

        return tabla;
    }




    private Posicion buscarPosicion(List<Posicion> tabla, Equipo equipo) {
        for (Posicion p : tabla) {
            if (p.getEquipo().equals(equipo)) return p;
        }
        return null;
    }

    // ---- Tabla de goleadores ----
    public List<Goleador> generarTablaGoleadores() {
        List<Goleador> tabla = new ArrayList<>();

        for (Partido partido : lstPartidos) {
            for (ParticipacionPartido pp : partido.getListParticipacionPartido()) {
                Jugador jugador = pp.getJugador();
                int goles = pp.getGoles();

                Goleador encontrado = null;
                for (Goleador g : tabla) {
                    if (g.getJugador().equals(jugador)) {
                        encontrado = g;
                        break;
                    }
                }

                if (encontrado != null) {
                    encontrado.setGoles(encontrado.getGoles() + goles);
                } else {
                    tabla.add(new Goleador(jugador, goles));
                }
            }
        }

        // Orden descendente por goles
        tabla.sort((g1, g2) -> Integer.compare(g2.getGoles(), g1.getGoles()));

        return tabla;
    }

    // ---- Tabla de asistencias ----
    public List<Asistencia> generarTablaAsistidores() {
        List<Asistencia> tabla = new ArrayList<>();

        for (Partido partido : lstPartidos) {
            for (ParticipacionPartido pp : partido.getListParticipacionPartido()) {
                Jugador jugador = pp.getJugador();
                int asistencias = pp.getAsistencias();

                Asistencia existente = null;
                for (Asistencia a : tabla) {
                    if (a.getJugador().equals(jugador)) {
                        existente = a;
                        break;
                    }
                }

                if (existente != null) {
                    existente.setAsistencias(existente.getAsistencias() + asistencias);
                } else {
                    tabla.add(new Asistencia(jugador, asistencias));
                }
            }
        }

        // Orden descendente por asistencias
        tabla.sort((a1, a2) -> Integer.compare(a2.getAsistencias(), a1.getAsistencias()));

        return tabla;
    }

    @Override
    public String toString() {
        return "Torneo [id=" + id + ", nombre=" + nombre + ", temporada=" + temporada +
               ", fechaInicio=" + fechaDeInicio + ", fechaFin=" + fechaDeFinalizacion + "]";
    }
}
