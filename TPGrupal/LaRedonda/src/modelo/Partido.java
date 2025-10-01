package modelo;
import java.time.LocalDate;


public class Partido {
private int idPartido;

private LocalDate Fecha;
private String Estadio;
private Equipo EquipoLocal ;
private Equipo EquipoVisitante;

public int getIdPartido() {
	return idPartido;
}

public void setIdPartido(int idPartido) {
	this.idPartido = idPartido;
}



public Partido(int idPartido, LocalDate fecha, String estadio, Equipo equipoLocal, Equipo equipoVisitante) {
	super();
	this.idPartido = idPartido;
	Fecha = fecha;
	Estadio = estadio;
	EquipoLocal = equipoLocal;
	EquipoVisitante = equipoVisitante;
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

@Override
public String toString() {
	return "Partido [Fecha=" + Fecha + ", Estadio=" + Estadio + ", EquipoLocal=" + EquipoLocal + ", EquipoVisitante="
			+ EquipoVisitante + "]";
}






}