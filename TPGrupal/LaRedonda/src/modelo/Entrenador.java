package modelo;

import java.time.LocalDate;

public class Entrenador extends Persona {

	private int id ;
	private String EstrategiaFavorita;

	public Entrenador(int id ,String nombre, String apellido, int dni, LocalDate fechaNacimiento, String estrategiaFavorita) {
		super(nombre, apellido, dni, fechaNacimiento);
		EstrategiaFavorita = estrategiaFavorita;
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstrategiaFavorita() {
		return EstrategiaFavorita;
	}

	public void setEstrategiaFavorita(String estrategiaFavorita) {
		EstrategiaFavorita = estrategiaFavorita;
	}

	@Override
	public String toString() {
		return "Entrenador [id=" + id + ", EstrategiaFavorita=" + EstrategiaFavorita + "]";
	}




	
	
}

