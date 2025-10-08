package modelo;
import java.time.LocalDate;
import java.util.ArrayList;


public class Partido {
private int id;
private String Estadio;
private Equipo EquipoLocal ;
private Equipo EquipoVisitante;
private ArrayList<EstadisticaParticipacionPartido>listParticipacionPartido;
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




public ArrayList<EstadisticaParticipacionPartido> getListParticipacionPartido() {
	return listParticipacionPartido;
}




public void setListParticipacionPartido(ArrayList<EstadisticaParticipacionPartido> listParticipacionPartido) {
	this.listParticipacionPartido = listParticipacionPartido;
}




public LocalDate getFechaPartido() {
	return FechaPartido;
}




public void setFechaPartido(LocalDate fechaPartido) {
	FechaPartido = fechaPartido;
}




public Partido(int id, String estadio, Equipo equipoLocal, Equipo equipoVisitante,LocalDate fechaPartido) {
	super();
	this.id = id;
	Estadio = estadio;
	EquipoLocal = equipoLocal;
	EquipoVisitante = equipoVisitante;
	this.listParticipacionPartido=new ArrayList <EstadisticaParticipacionPartido>();
	FechaPartido = fechaPartido;
}

}