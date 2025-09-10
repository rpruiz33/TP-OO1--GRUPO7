package evento;
import java.time.LocalDate;
import java.util.List;

public class Jugador extends Persona {
private int Peso;
private float Estatura;
private String Posicion;
private List<Estadisticas>lstEstadistica;


public Jugador(String nombre, String apellido, int dni, LocalDate fechaNacimiento, int peso, float estatura,
		String posicion, List<Estadisticas> lstEstadistica) {
	super(nombre, apellido, dni, fechaNacimiento);
	Peso = peso;
	Estatura = estatura;
	Posicion = posicion;
	this.lstEstadistica = lstEstadistica;
}

public int getPeso() {
	return Peso;
}

public void setPeso(int peso) {
	Peso = peso;
}

public float getEstatura() {
	return Estatura;
}

public void setEstatura(float estatura) {
	Estatura = estatura;
}

public String getPosicion() {
	return Posicion;
}

public void setPosicion(String posicion) {
	Posicion = posicion;
}

public List<Estadisticas> getLstEstadistica() {
	return lstEstadistica;
}

public void setLstEstadistica(List<Estadisticas> lstEstadistica) {
	this.lstEstadistica = lstEstadistica;
}
}
