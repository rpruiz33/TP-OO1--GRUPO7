package evento;

import java.time.LocalDate;

public class Entrenador extends Persona {

	
	private String EstrategiaFavorita;

	public Entrenador(String nombre, String apellido, int dni, LocalDate fechaNacimiento, String estrategiaFavorita) {
		super(nombre, apellido, dni, fechaNacimiento);
		EstrategiaFavorita = estrategiaFavorita;
	}

	public String getEstrategiaFavorita() {
		return EstrategiaFavorita;
	}

	public void setEstrategiaFavorita(String estrategiaFavorita) {
		EstrategiaFavorita = estrategiaFavorita;
	}
	
	
}

