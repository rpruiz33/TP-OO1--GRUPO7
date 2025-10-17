package modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Partido {
    private int id;
    private String estadio;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private LocalDate fechaPartido;
    private List<ParticipacionPartido> listParticipacionPartido;
    private ArrayList<EstadisticaParticipacionPartido> estadisticas;
    public ArrayList<EstadisticaParticipacionPartido> getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(ArrayList<EstadisticaParticipacionPartido> estadisticas) {
		this.estadisticas = estadisticas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public LocalDate getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(LocalDate fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public void setListParticipacionPartido(List<ParticipacionPartido> listParticipacionPartido) {
		this.listParticipacionPartido = listParticipacionPartido;
	}

	public Partido(int id, String estadio, Equipo equipoLocal, Equipo equipoVisitante, LocalDate fechaPartido) {
        this.id = id;
        this.estadio = estadio;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fechaPartido = fechaPartido;
        this.listParticipacionPartido = new ArrayList<>();
        this.estadisticas = new ArrayList<>();
    }

    public List<ParticipacionPartido> getListParticipacionPartido() {
        return listParticipacionPartido;
    }
    // Agregar participación del jugador
    public boolean agregarParticipacion(Jugador jugador, int goles, int asistencias,int minutosJugados) {
        if (jugador == null) return false;

        // Creamos la participación con goles, asistencias y minutos
        ParticipacionPartido participacion = new ParticipacionPartido(jugador, goles, asistencias, minutosJugados);
        return listParticipacionPartido.add(participacion);
    }
    
    
}

