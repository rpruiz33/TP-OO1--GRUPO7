package modelo;
// Agrege clase Estadisticas que no esta en el UML. avisarle a roberto.

public class Estadistica {
	private int idEstadisticaM;
	private Partido partido;
    private Jugador jugador;
    private int  idEstadistica;
    private int goles;
    private int asistencias;
    private int minutosJugados;
    

    public int getIdEstadistica() {
		return idEstadistica;
	}

	public void setIdEstadistica(int idEstadistica) {
		this.idEstadistica = idEstadistica;
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

	public Estadistica(int idEstadisticaM, Partido partido, Jugador jugador, int idEstadistica, int goles,
			int asistencias, int minutosJugados) {
		super();
		this.idEstadisticaM = idEstadisticaM;
		this.partido = partido;
		this.jugador = jugador;
		this.idEstadistica = idEstadistica;
		this.goles = goles;
		this.asistencias = asistencias;
		this.minutosJugados = minutosJugados;
	}

}




    
