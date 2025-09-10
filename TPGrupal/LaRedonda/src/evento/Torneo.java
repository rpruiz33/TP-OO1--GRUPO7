package evento;
import java.time.LocalDate;
import java.util.*;

// Dentro de Torneo deberian ir las CU, consultarle a los chicos

public class Torneo {
	private int id;
	private String Nombre;
	private String Temporada;
	private List<Equipo>LstEquipos;
	private List<Partido>LstPartidos; //Agregado avisar
	private LocalDate fechaDeInicio;
	private LocalDate fechaDeFinalizacion;
	
	

	public Torneo(int id, String nombre, String temporada, List<Equipo> lstEquipos, List<Partido> lstPartidos,
			LocalDate fechaDeInicio, LocalDate fechaDeFinalizacion) {
		super();
		this.id = id;
		Nombre = nombre;
		Temporada = temporada;
		LstEquipos = lstEquipos;
		LstPartidos = lstPartidos;
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeFinalizacion = fechaDeFinalizacion;
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

	public String getTemporada() {
		return Temporada;
	}

	public void setTemporada(String temporada) {
		Temporada = temporada;
	}

	public List<Equipo> getLstEquipos() {
		return LstEquipos;
	}

	public void setLstEquipos(List<Equipo> lstEquipos) {
		LstEquipos = lstEquipos;
	}

	public LocalDate getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(LocalDate fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	public LocalDate getFechaDeFinalizacion() {
		return fechaDeFinalizacion;
	}

	public void setFechaDeFinalizacion(LocalDate fechaDeFinalizacion) {
		this.fechaDeFinalizacion = fechaDeFinalizacion;
	}

	public List<Partido> getLstPartidos() {
		return LstPartidos;
	}

	public void setLstPartidos(List<Partido> lstPartidos) {
		LstPartidos = lstPartidos;
	}
   
	
}
