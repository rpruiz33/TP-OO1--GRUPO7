package modelo;
import java.time.LocalDate;


public class Partido {
private int id;
private String Estadio;
private Equipo EquipoLocal ;
private Equipo EquipoVisitante;
private Partido	ListParticipacionPartido;
private LocalDate FechaPartido;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEstadio() {
	return Estadio;
}
public void setEstadio(String estadio) {
	Estadio = estadio;
}
public Equipo getEquipoLocal() {
	return EquipoLocal;
}
public void setEquipoLocal(Equipo equipoLocal) {
	EquipoLocal = equipoLocal;
}
public Equipo getEquipoVisitante() {
	return EquipoVisitante;
}
public void setEquipoVisitante(Equipo equipoVisitante) {
	EquipoVisitante = equipoVisitante;
}
public Partido getListParticipacionPartido() {
	return ListParticipacionPartido;
}
public void setListParticipacionPartido(Partido listParticipacionPartido) {
	ListParticipacionPartido = listParticipacionPartido;
}
public LocalDate getFechaPartido() {
	return FechaPartido;
}
public void setFechaPartido(LocalDate fechaPartido) {
	FechaPartido = fechaPartido;
}
public Partido(int id, String estadio, Equipo equipoLocal, Equipo equipoVisitante, Partido listParticipacionPartido,
		LocalDate fechaPartido) {
	super();
	this.id = id;
	Estadio = estadio;
	EquipoLocal = equipoLocal;
	EquipoVisitante = equipoVisitante;
	ListParticipacionPartido = listParticipacionPartido;
	FechaPartido = fechaPartido;
}



}