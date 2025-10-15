
package modelo;

import java.time.LocalDate;
import java.util.*;

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
        this.lstEquipos = new ArrayList<>();
        this.lstPartidos = new ArrayList<>();
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeFinalizacion = fechaDeFinalizacion;
        this.equipoGanador = equipoGanador;
    }

    // Getters y setters

    // Métodos para agregar, traer y eliminar equipos
    public boolean agregarEquipo(String nombre, Entrenador e1, String codigo, LocalDate fechaFundacion) {
        int id = lstEquipos.isEmpty() ? 1 : lstEquipos.get(lstEquipos.size() - 1).getId() + 1;
        return lstEquipos.add(new Equipo(id, nombre, e1, codigo, fechaFundacion));
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

    // Métodos para partidos
    public boolean agregarPartido(String estadio, Equipo equipoLocal, Equipo equipoVisitante, LocalDate fechaPartido) {
        int id = lstPartidos.isEmpty() ? 1 : lstPartidos.get(lstPartidos.size() - 1).getId() + 1;
        return lstPartidos.add(new Partido(id, estadio, equipoLocal, equipoVisitante, fechaPartido));
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

    // Generar tabla de posiciones
    public List<Posicion> generarTablaPosiciones() {
        List<Posicion> tabla = new ArrayList<>();

        for (Partido partido : lstPartidos) {
            Equipo local = partido.getEquipoLocal();
            Equipo visitante = partido.getEquipoVisitante();

            int golesLocal = 0;
            int golesVisitante = 0;

            for (ParticipacionPartido pp : partido.getListParticipacionPartido()) {
                if (local.getLstJugadores().contains(pp.getJugador())) golesLocal += pp.getGoles();
                if (visitante.getLstJugadores().contains(pp.getJugador())) golesVisitante += pp.getGoles();
            }

            Equipo ganador = null;
            if (golesLocal > golesVisitante) ganador = local;
            else if (golesVisitante > golesLocal) ganador = visitante;

            // Actualizar tabla
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

        // Ordenar tabla
        tabla.sort((a, b) -> b.getPuntos() - a.getPuntos());
        return tabla;
    }

    private Posicion buscarPosicion(List<Posicion> tabla, Equipo equipo) {
       Posicion pb=null;
    	boolean encontrado=false;
    	int i=0;
    	
        while(tabla.size()>i&& !encontrado) {  
        	if(tabla.get(i).getEquipo().equals(equipo)){
        	pb=	tabla.get(i);
        			encontrado=true;
        	}
        i++;
        }
        return pb;
    }

    // Generar tabla de goleadores
    public ArrayList<Goleador> generarTablaGoleadores() {
        ArrayList<Goleador> tabla = new ArrayList<>();

        for (Partido partido : lstPartidos) {
            for (ParticipacionPartido pp : partido.getListParticipacionPartido()) {
                Jugador jugador = pp.getJugador();
                int goles = pp.getGoles();

                // Buscar si ya está en la tabla
                Goleador encontrado = null;
                for (Goleador g : tabla) {
                    if (g.getJugador().getId() == jugador.getId()) {
                        encontrado = g;
                        break;
                    }
                }

                if (encontrado != null) encontrado.sumarGoles(goles);
                else tabla.add(new Goleador(jugador, goles));
            }
        }

        // Ordenar
        tabla.sort((a, b) -> b.getGoles() - a.getGoles());
        return tabla;
    }
    
    
    
    public ArrayList<Asistencia> generarTablaAsistidores() {
        ArrayList<Asistencia> tabla = new ArrayList<>();

        for (Partido partido : lstPartidos) {
            ArrayList<EstadisticaParticipacionPartido> estadisticas = partido.getEstadisticas();

            // 🚨 Protegemos de NullPointer
            if (estadisticas == null) continue;

            for (EstadisticaParticipacionPartido est : estadisticas) {
                if (est.getListJugadorJugo() == null) continue;

                for (Jugador jugador : est.getListJugadorJugo()) {
                    Asistencia existente = null;
                    for (Asistencia a : tabla) {
                        if (a.getJugador().equals(jugador)) {
                            existente = a;
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

        // Ordenar de mayor a menor por cantidad de asistencias
        tabla.sort((a1, a2) -> Integer.compare(a2.getAsistencias(), a1.getAsistencias()));

        return tabla;
    }



	@Override
	public String toString() {
		return "Torneo [id=" + id + ", nombre=" + nombre + ", temporada=" + temporada + ", lstEquipos=" + lstEquipos
				+ ", lstPartidos=" + lstPartidos + ", fechaDeInicio=" + fechaDeInicio + ", fechaDeFinalizacion="
				+ fechaDeFinalizacion + ", equipoGanador=" + equipoGanador + "]";
	}

}
