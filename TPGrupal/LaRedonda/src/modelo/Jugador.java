package modelo;
import java.time.LocalDate;
import java.util.List;

public class Jugador extends Persona {
private int idJugador;
private float peso;
private float estatura;
private String posicion;
private List<Estadistica>lstEstadistica;





public Jugador(String nombre, String apellido, int dni, LocalDate fechaNacimiento, int idJugador, float peso,
		float estatura, String posicion, List<Estadistica> lstEstadistica) {
	super(nombre, apellido, dni, fechaNacimiento);
	this.idJugador = idJugador;
	this.peso = peso;
	this.estatura = estatura;
	this.posicion = posicion;
	this.lstEstadistica = lstEstadistica;
}


public int getIdJugador() {
	return idJugador;
}


public void setIdJugador(int idJugador) {
	this.idJugador = idJugador;
}


public float getPeso() {
	return peso;
}


public void setPeso(float peso) {
	this.peso = peso;
}


public float getEstatura() {
	return estatura;
}


public void setEstatura(float estatura) {
	this.estatura = estatura;
}


public String getPosicion() {
	return posicion;
}


public void setPosicion(String posicion) {
	this.posicion = posicion;
}


public List<Estadistica> getLstEstadistica() {
	return lstEstadistica;
}


public void setLstEstadistica(List<Estadistica> lstEstadistica) {
	this.lstEstadistica = lstEstadistica;
}


@Override
public String toString() {
	return "Jugador [idJugador=" + idJugador + ", peso=" + peso + ", estatura=" + estatura + ", posicion=" + posicion
			+ ", lstEstadistica=" + lstEstadistica + "]";
}











}
