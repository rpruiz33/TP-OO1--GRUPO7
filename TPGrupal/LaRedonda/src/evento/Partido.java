package evento;
import java.time.LocalDate;
import java.util.List;

public class Partido {
private LocalDate Fecha;
private String Estadio;
private Equipo EquipoLocal ;
private Equipo EquipoVisitante;
private List<Estadisticas>lstEstadistica;

public Partido(LocalDate fecha, String estadio, Equipo equipoLocal, Equipo equipoVisitante,
		List<Estadisticas> lstEstadistica) {
	super();
	this.Fecha = fecha;
	this.Estadio = estadio;
	this.EquipoLocal = equipoLocal;
	this.EquipoVisitante = equipoVisitante;
	this.lstEstadistica = lstEstadistica;
}

public LocalDate getFecha() {
	return Fecha;
}

public void setFecha(LocalDate fecha) {
	Fecha = fecha;
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

public List<Estadisticas> getLstEstadistica() {
	return lstEstadistica;
}

public void setLstEstadistica(List<Estadisticas> lstEstadistica) {
	this.lstEstadistica = lstEstadistica;
}





}