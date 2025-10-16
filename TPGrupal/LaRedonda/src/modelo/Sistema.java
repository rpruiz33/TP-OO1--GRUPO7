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

	public List<Torneo> getLstTorneos() {
		return lstTorneos;
	}

	public void setLstTorneos(List<Torneo> lstTorneos) {
		this.lstTorneos = lstTorneos;
	}



	// Agregar partido
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


    // Eliminar partido
    public boolean eliminarPartido(int idPartido) throws Exception {
        Partido aux = traerPartido(idPartido);
        if (aux == null) {
        	throw new Exception("El partido no existe");
        }
        return lstPartidos.remove(aux);
    }

    // Agregar jugador
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

    // Agregar entrenador
    public boolean agregarEntrenador(String nombre, String apellido, int dni, LocalDate fechaNacimiento,
                                     String estrategiaFavorita) {
        int id = 1;
        if (lstEntrenadores.size() > 0) {
            id = lstEntrenadores.get(lstEntrenadores.size() - 1).getId() + 1;
        }
        Entrenador e = new Entrenador(id, nombre, apellido, dni, fechaNacimiento, estrategiaFavorita);
        return lstEntrenadores.add(e);
    }

    // Traer entrenador
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

    // Agregar torneo
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


    // Eliminar torneo
    public boolean eliminarTorneo(int idTorneo) throws Exception {
        Torneo aux = traerTorneo(idTorneo);
        if (aux == null) throw new Exception("El torneo no existe");
        return lstTorneos.remove(aux);
    }

    // Traer torneo por fecha (lista de ganadores)
    public List<Ganador> traerTorneoPorFecha(int idTorneo, LocalDate fecha) {
        Torneo taux = this.traerTorneo(idTorneo);
        List<Ganador> ganadores = new ArrayList<Ganador>();

        if (taux != null) {
            for (int j = 0; j < taux.getLstPartidos().size(); j++) {
                Partido partido = taux.getLstPartidos().get(j);
                if (partido.getFechaPartido().equals(fecha)) {
                    if (partido.getListParticipacionPartido().size() >= 2) {
                        int golesLocal = partido.getListParticipacionPartido().get(0).getGoles();
                        int golesVisitante = partido.getListParticipacionPartido().get(1).getGoles();
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

    // Búsqueda de entrenadores por táctica
    public List<Entrenador> busquedaEntrenadoresPorTactica(String tacticaPreferida) {
        List<Entrenador> listAux = new ArrayList<Entrenador>();
        for (int g = 0; g < lstEntrenadores.size(); g++) {
            if (lstEntrenadores.get(g).getEstrategiaFavorita().equals(tacticaPreferida)) {
                listAux.add(lstEntrenadores.get(g));
            }
        }
        return listAux;
    }

    // Búsqueda de jugadores por fecha de nacimiento
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

}
