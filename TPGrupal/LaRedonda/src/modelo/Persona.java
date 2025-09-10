package modelo;
import java.time.LocalDate;


// esto es para que  Jugadores y Entrenadores Hereden los datos necesarios

public class Persona {
private String Nombre;
private String Apellido;
private int Dni; 
private LocalDate FechaNacimiento;

public Persona(String nombre, String apellido, int dni, LocalDate fechaNacimiento) {
	super();
	Nombre = nombre;
	Apellido = apellido;
	Dni = dni;
	FechaNacimiento = fechaNacimiento;
}

public String getNombre() {
	return Nombre;
}

public void setNombre(String nombre) {
	Nombre = nombre;
}

public String getApellido() {
	return Apellido;
}

public void setApellido(String apellido) {
	Apellido = apellido;
}

public int getDni() {
	return Dni;
}

public void setDni(int dni) {
	Dni = dni;
}

public LocalDate getFechaNacimiento() {
	return FechaNacimiento;
}

public void setFechaNacimiento(LocalDate fechaNacimiento) {
	FechaNacimiento = fechaNacimiento;
}

@Override
public String toString() {
	return "Persona [Nombre=" + Nombre + ", Apellido=" + Apellido + ", Dni=" + Dni + ", FechaNacimiento="
			+ FechaNacimiento + "]";
}


}
