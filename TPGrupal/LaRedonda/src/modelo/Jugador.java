package modelo;
import java.time.LocalDate;
import java.util.List;

public class Jugador extends Persona {
private float peso;
private float estatura;
private String posicion;
private List<Estadisticas>lstEstadistica;


public Jugador(String nombre, String apellido, int dni, LocalDate fechaNacimiento, float peso, float estatura,
		String posicion, List<Estadisticas> lstEstadistica) {
	super(nombre, apellido, dni, fechaNacimiento);
	this.peso = peso;
	this.estatura = estatura;
	this.posicion = posicion;
	this.lstEstadistica = lstEstadistica;
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


public List<Estadisticas> getLstEstadistica() {
	return lstEstadistica;
}


public void setLstEstadistica(List<Estadisticas> lstEstadistica) {
	this.lstEstadistica = lstEstadistica;
}


@Override
public String toString() {
	return "Jugador [peso=" + peso + ", estatura=" + estatura + ", posicion=" + posicion + "]";
}






}
