package modelo;
import java.time.LocalDate;
import java.util.*;

public class Equipo {
private int id;
private String Nombre;
private Entrenador Entrenador;
private List<Jugador> lstJugadores;
private String Codigo;
private LocalDate fechaFundacion;

 
 
public Equipo(int id, String nombre, modelo.Entrenador entrenador, List<Jugador> lstJugadores, String codigo,
		LocalDate fechaFundacion) {
	super();
	this.id = id;
	Nombre = nombre;
	Entrenador = entrenador;
	this.lstJugadores = lstJugadores;
	Codigo = codigo;
	this.fechaFundacion = fechaFundacion;
}

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

public List<Jugador> getLstJugadores() {
	return lstJugadores;
}

public void setLstJugadores(List<Jugador> lstJugadores) {
	this.lstJugadores = lstJugadores;
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

public boolean agregarJugador(String nombre, String apellido, int dni, LocalDate fechaNacimiento,
        float peso, float estatura, String posicion, int numCamiseta) {
int id = 1;
if (!lstJugadores.isEmpty()) {
id = lstJugadores.get(lstJugadores.size() - 1).getId() + 1;
}

Jugador j = new Jugador(nombre, apellido, dni, fechaNacimiento, id, peso, estatura, posicion, numCamiseta);


return lstJugadores.add(j);
}

public Jugador traerJugador(int idJugador) {
int i = 0;
boolean encontrado = false;
Jugador aux = null;
while (i < lstJugadores.size() && !encontrado) {
if (lstJugadores.get(i).getId() == idJugador)

{
aux = lstJugadores.get(i);
encontrado = true;
}
i++;
}
return aux;
}

public boolean eliminarJugador(int idJugador) throws Exception {
Jugador aux = null;
int i = 0;

boolean encontrado = false;


while (i < lstJugadores.size() && !encontrado) {
if (lstJugadores.get(i).getId() == idJugador) {
aux = lstJugadores.get(i);
encontrado = true;
}
i++;
}
if (aux == null) throw new Exception("El jugador no existe");
return lstJugadores.remove(aux);
}

@Override
public String toString() {
	return "Equipo [id=" + id + ", Nombre=" + Nombre + ", Entrenador=" + Entrenador + ", lstJugadores=" + lstJugadores
			+ ", Codigo=" + Codigo + ", fechaFundacion=" + fechaFundacion + "]";
}

 
 
}
