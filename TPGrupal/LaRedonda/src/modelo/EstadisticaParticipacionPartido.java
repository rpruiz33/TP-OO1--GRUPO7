package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class EstadisticaParticipacionPartido {
private int id;
private Equipo equipoLocal;
private Equipo equpoVisitante;
private Equipo ganador;
private String Estadio;
private ArrayList<Jugador>listJugadorJugo;
private int golesMetio;
private int asistenciaParitodo;
private int minutosJugados;
private LocalDate fechaPartido;
private int asistencias;




public int getAsistencias() {
	return asistencias;
}
public void setAsistencias(int asistencias) {
	this.asistencias = asistencias;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Equipo getEquipoLocal() {
	return equipoLocal;
}
public void setEquipoLocal(Equipo equipoLocal) {
	this.equipoLocal = equipoLocal;
}
public Equipo getEqupoVisitante() {
	return equpoVisitante;
}
public void setEqupoVisitante(Equipo equpoVisitante) {
	this.equpoVisitante = equpoVisitante;
}
public Equipo getGanador() {
	return ganador;
}
public void setGanador(Equipo ganador) {
	this.ganador = ganador;
}
public String getEstadio() {
	return Estadio;
}
public void setEstadio(String estadio) {
	Estadio = estadio;
}
public ArrayList<Jugador> getListJugadorJugo() {
	return listJugadorJugo;
}
public void setListJugadorJugo(ArrayList<Jugador> listJugadorJugo) {
	this.listJugadorJugo = listJugadorJugo;
}
public int getGolesMetio() {
	return golesMetio;
}
public void setGolesMetio(int golesMetio) {
	this.golesMetio = golesMetio;
}
public int getAsistenciaParitodo() {
	return asistenciaParitodo;
}
public void setAsistenciaParitodo(int asistenciaParitodo) {
	this.asistenciaParitodo = asistenciaParitodo;
}
public int getMinutosJugados() {
	return minutosJugados;
}
public void setMinutosJugados(int minutosJugados) {
	this.minutosJugados = minutosJugados;
}
public LocalDate getFechaPartido() {
	return fechaPartido;
}
public void setFechaPartido(LocalDate fechaPartido) {
	this.fechaPartido = fechaPartido;
}
public EstadisticaParticipacionPartido(int id, Equipo equipoLocal, Equipo equpoVisitante, Equipo ganador,
		String estadio, int golesMetio, int asistenciaParitodo, int minutosJugados,
		LocalDate fechaPartido,int asistencias) {
	super();
	this.id = id;
	this.equipoLocal = equipoLocal;
	this.equpoVisitante = equpoVisitante;
	this.ganador = ganador;
	Estadio = estadio;
	this.listJugadorJugo = new ArrayList<Jugador>();
	this.golesMetio = golesMetio;
	this.asistenciaParitodo = asistenciaParitodo;
	this.minutosJugados = minutosJugados;
	this.fechaPartido = fechaPartido;
	this.asistencias=asistencias;
}



public int totalGolesJugador(Jugador jugador) {
    int totalGoles = 0;
    // Si el jugador participó en este partido, sumamos los goles de este partido
    if (listJugadorJugo.contains(jugador)) {
        totalGoles = golesMetio; // Todos los jugadores en la lista suman los mismos goles en este partido
       
    }
    return totalGoles;
}

public int totalAsistenciasJugador(Jugador jugador) {
    int totalAsistencias = 0;
    if (listJugadorJugo.contains(jugador)) {
        totalAsistencias = asistenciaParitodo;
    }
    return totalAsistencias;
}









}
