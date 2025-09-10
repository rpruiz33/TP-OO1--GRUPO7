package evento;
import java.util.*;

public class Equipo {
 private String Nombre;
 Entrenador Entrenador;
 private List<Jugador> LstJugador;
 private String Codigo;
 
public Equipo(String nombre, evento.Entrenador entrenador, List<Jugador> lstJugador, String codigo) {
	super();
	Nombre = nombre;
	Entrenador = entrenador;
	LstJugador = lstJugador;
	Codigo = codigo;
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
 
 
}
