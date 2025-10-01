package modelo;

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






}
