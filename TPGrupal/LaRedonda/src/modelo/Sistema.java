package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
List<Partido>lstPartidos;
List<Jugador>lstJugadores;
List<Estadistica> lstEstadisticas;
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
public List<Estadistica> getLstEstadisticas() {
	return lstEstadisticas;
}
public void setLstEstadisticas(List<Estadistica> lstEstadisticas) {
	this.lstEstadisticas = lstEstadisticas;
}
public Sistema() {
	super();
	this.lstPartidos = new ArrayList<Partido>();
	this.lstJugadores =  new ArrayList<Jugador>();
	this.lstEstadisticas =  new ArrayList<Estadistica>();
}





	public boolean agregarPartido(LocalDate fecha, String estadio, Equipo equipoLocal, Equipo equipoVisitante) {
		Partido p = null;
		int id = 0;
		if (lstPartidos.isEmpty()) {
			id = 1;
		} 
		else {
			id = lstPartidos.get(lstPartidos.size() - 1).getIdPartido() + 1;
		}
		p = new Partido(id, fecha,  estadio,  equipoLocal, equipoVisitante);
		
		return lstPartidos.add(p);
	}

	public Partido traerPartido(int idPartido) {
		int i = 0;
		boolean flag = false;
		Partido aux = null;
		while (lstPartidos.size() > i && flag != true) {
			
			if (lstPartidos.get(i).getIdPartido() == idPartido) {
				aux = lstPartidos.get(i);
				flag = true;
			}
			i++;
		}
		return aux;
	}

	public boolean eliminarPartido(int idPartido) throws Exception {
		boolean flag = false;
		Partido aux = null;
		aux = traerPartido(idPartido);
		if (aux == null) {
			throw new Exception("el partido no existe");
		} 
		
		else {
			flag = lstPartidos.remove(aux);
		}
		return flag;
	}


	public boolean agregarJugador(String nombre, String apellido, int dni, LocalDate fechaNacimiento, int idJugador, float peso,
			float estatura, String posicion, List<Estadistica> lstEstadistica) {
		Jugador j = null;
		
		int id = 0;
		
		if (lstJugadores.isEmpty()) {
			id = 1;
		} 
		else {
			id = lstJugadores.get(lstJugadores.size() - 1).getIdJugador() + 1;
		}
		j = new Jugador( nombre, apellido, dni,  fechaNacimiento, id,  peso,
				estatura, posicion, null);
		return lstJugadores.add(j);
	}

	public Jugador traerJugador(int idJugador) {
		int i = 0;
		boolean flag = false;
		Jugador aux = null;
		while (lstJugadores.size() > i && flag != true) {
			if (lstJugadores.get(i).getIdJugador() == idJugador) {
				aux = lstJugadores.get(i);
				flag = true;
			}
			i++;
		}
		return aux;
	}

	public boolean eliminarJugador(int idJugador) throws Exception {
		boolean flag = false;
		Jugador aux = null;
		aux = traerJugador(idJugador);
		if (aux == null) {
			throw new Exception("el jugador no existe");
		} 
		
		else {
			flag = lstJugadores.remove(aux);
		}
		return flag;
	}



	public boolean agregarEstadistica(int idEstadisticaM, Partido partido, Jugador jugador, int idEstadistica, int goles,
			int asistencias, int minutosJugados) throws Exception {
		Estadistica e = null;
		int id = 0;
		if (lstEstadisticas.isEmpty()) {
			id = 1;
		} 
		
		else {
			id = lstEstadisticas.get(lstEstadisticas.size() - 1).getIdEstadistica() + 1;
		}
		partido = traerPartido(partido.getIdPartido());
		
		jugador = traerJugador(jugador.getIdJugador());
		
		if (partido == null) {
			throw new Exception("el partido no existe");
		}
		if (jugador == null) {
			throw new Exception("el jugador no existe");
		}
		e = new Estadistica(id,  partido,  jugador,  idEstadistica,  goles,
				 asistencias,  minutosJugados);
		return lstEstadisticas.add(e);
	}

	public Estadistica traerEstadistica(int idEstadistica) {
		int i = 0;
		boolean flag = false;
		Estadistica aux = null;
		
		while (lstEstadisticas.size() > i && flag != true) {
			
				if (lstEstadisticas.get(i).getIdEstadistica() == idEstadistica) {
				aux = lstEstadisticas.get(i);
				flag = true;
			}
			i++;
		}
		return aux;
	}

	public boolean eliminarEstadistica(int idEstadistica) throws Exception {
		boolean flag = false;
		Estadistica aux = null;
		aux = traerEstadistica(idEstadistica);
		
		if (aux == null) {
			throw new Exception("la estadistica no existe");
		} 
		else {
			flag = lstEstadisticas.remove(aux);
		}
		return flag;
	}
}
