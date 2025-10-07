package modelo;

import java.time.LocalDate;

public class EstadisticaParticipacionPartido {
private Equipo equipoLocal;
private String Estadio;
private LocalDate fechaPartido;
private Equipo equpoVisitante;
public Equipo getEquipoLocal() {
	return equipoLocal;
}
public void setEquipoLocal(Equipo equipoLocal) {
	this.equipoLocal = equipoLocal;
}
public String getEstadio() {
	return Estadio;
}
public void setEstadio(String estadio) {
	Estadio = estadio;
}
public LocalDate getFechaPartido() {
	return fechaPartido;
}
public void setFechaPartido(LocalDate fechaPartido) {
	this.fechaPartido = fechaPartido;
}
public Equipo getEqupoVisitante() {
	return equpoVisitante;
}
public void setEqupoVisitante(Equipo equpoVisitante) {
	this.equpoVisitante = equpoVisitante;
}
public EstadisticaParticipacionPartido(Equipo equipoLocal, String estadio, LocalDate fechaPartido, Equipo equpoVisitante) {
	super();
	this.equipoLocal = equipoLocal;
	Estadio = estadio;
	this.fechaPartido = fechaPartido;
	this.equpoVisitante = equpoVisitante;
}




}
