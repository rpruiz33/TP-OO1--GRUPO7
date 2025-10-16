package modelo;

public class ParticipacionPartido {
    private Jugador jugador;
    private int goles;
    private int asistencias;
    private int minutosJugados;

    public ParticipacionPartido(Jugador jugador, int goles) {
        this.jugador = jugador;
        this.goles = goles;
        this.asistencias = asistencias;
        this.minutosJugados = minutosJugados;
    }

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
}
