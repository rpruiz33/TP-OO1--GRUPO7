package modelo;
// Agrege clase Estadisticas que no esta en el UML. avisarle a roberto.

public class Estadisticas {
    private Jugador jugador;

    private int goles;
    private int asistencias;
    private int minutosJugados;
    


	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}


	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public int getMinutosJugados() {
		return minutosJugados;
	}

	public void setMinutosJugados(int minutosJugados) {
		this.minutosJugados = minutosJugados;
	}

	public Estadisticas(Jugador jugador, int goles, int asistencias, int minutosJugados) {
		super();
		this.jugador = jugador;
	
		this.goles = goles;
		this.asistencias = asistencias;
		this.minutosJugados = minutosJugados;
	}

	@Override
	public String toString() {
		return "Estadisticas [jugador=" + jugador + ", goles=" + goles + ", asistencias=" + asistencias
				+ ", minutosJugados=" + minutosJugados + "]";
	}
	
	
	

	
    
}