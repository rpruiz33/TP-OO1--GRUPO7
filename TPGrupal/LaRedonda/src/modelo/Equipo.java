package modelo;
import java.time.LocalDate;
import java.util.*;

public class Equipo {
private int id;
private String Nombre;
 private Entrenador Entrenador;
 private List<Jugador> LstJugador;
 private String Codigo;
 private LocalDate fechaFundacion;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
}
public Entrenador getEntrenador() {
	return Entrenador;
}
public void setEntrenador(Entrenador entrenador) {
	Entrenador = entrenador;
}
public List<Jugador> getLstJugador() {
	return LstJugador;
}
public void setLstJugador(List<Jugador> lstJugador) {
	LstJugador = lstJugador;
}
public String getCodigo() {
	return Codigo;
}
public void setCodigo(String codigo) {
	Codigo = codigo;
}
public LocalDate getFechaFundacion() {
	return fechaFundacion;
}
public void setFechaFundacion(LocalDate fechaFundacion) {
	this.fechaFundacion = fechaFundacion;
}
public Equipo(int id, String nombre, modelo.Entrenador entrenador, List<Jugador> lstJugador, String codigo,
		LocalDate fechaFundacion) {
	super();
	this.id = id;
	Nombre = nombre;
	Entrenador = entrenador;
	LstJugador = lstJugador;
	Codigo = codigo;
	this.fechaFundacion = fechaFundacion;
}
@Override
public String toString() {
	return "Equipo [id=" + id + ", Nombre=" + Nombre + ", Entrenador=" + Entrenador + ", LstJugador=" + LstJugador
			+ ", Codigo=" + Codigo + ", fechaFundacion=" + fechaFundacion + "]";
}

 
 

 
 
}
