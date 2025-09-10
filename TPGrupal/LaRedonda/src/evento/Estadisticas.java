package evento;
// Agrege clase Estadisticas que no esta en el UML. avisarle a roberto.

public class Estadisticas {
    private Jugador Jugador;
    private Partido Partido;
    private int Goles;
    private int Asistencias;
    private int MinutosJugados;
    
	public Estadisticas(evento.Jugador jugador, evento.Partido partido, int goles, int asistencias,
			int minutosJugados) {
		super();
		Jugador = jugador;
		Partido = partido;
		Goles = goles;
		Asistencias = asistencias;
		MinutosJugados = minutosJugados;
	}

	public Jugador getJugador() {
		return Jugador;
	}

	public void setJugador(Jugador jugador) {
		Jugador = jugador;
	}

	public Partido getPartido() {
		return Partido;
	}

	public void setPartido(Partido partido) {
		Partido = partido;
	}

	public int getGoles() {
		return Goles;
	}

	public void setGoles(int goles) {
		Goles = goles;
	}

	public int getAsistencias() {
		return Asistencias;
	}

	public void setAsistencias(int asistencias) {
		Asistencias = asistencias;
	}

	public int getMinutosJugados() {
		return MinutosJugados;
	}

	public void setMinutosJugados(int minutosJugados) {
		MinutosJugados = minutosJugados;
	}
    
}