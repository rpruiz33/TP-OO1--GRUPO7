package modelo;
import java.time.LocalDate;
import java.util.List;

public class Jugador extends Persona {
	
private int id;
private float peso;
private float estatura;
private String posicion;
private int numCamiseta;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public int getNumCamiseta() {
	return numCamiseta;
}
public void setNumCamiseta(int numCamiseta) {
	this.numCamiseta = numCamiseta;
}
public Jugador(String nombre, String apellido, int dni, LocalDate fechaNacimiento, int id, float peso, float estatura,
		String posicion, int numCamiseta) {
	super(nombre, apellido, dni, fechaNacimiento);
	this.id = id;
	this.peso = peso;
	this.estatura = estatura;
	this.posicion = posicion;
	this.numCamiseta = numCamiseta;
}










}
