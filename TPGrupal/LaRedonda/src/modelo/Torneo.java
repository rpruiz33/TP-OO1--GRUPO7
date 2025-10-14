package modelo;
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
	private Equipo equipoGanador;
	

	public Torneo(int id, String nombre, String temporada, List<Equipo> lstEquipos, List<Partido> lstPartidos,
			LocalDate fechaDeInicio, LocalDate fechaDeFinalizacion,Equipo equipoGanador) {
		super();
		this.id = id;
		Nombre = nombre;
		Temporada = temporada;
		LstEquipos = lstEquipos;
		LstPartidos = lstPartidos;
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeFinalizacion = fechaDeFinalizacion;
		this.equipoGanador=equipoGanador;
	}

	public Equipo getEquipoGanador() {
		return equipoGanador;
	}

	public void setEquipoGanador(Equipo equipoGanador) {
		this.equipoGanador = equipoGanador;
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

	@Override
	public String toString() {
		return "Torneo [id=" + id + ", Nombre=" + Nombre + ", Temporada=" + Temporada + ", LstEquipos=" + LstEquipos
				+ ", LstPartidos=" + LstPartidos + ", fechaDeInicio=" + fechaDeInicio + ", fechaDeFinalizacion="
				+ fechaDeFinalizacion + "]";
	}
   
    /*Búsqueda de equipos por fecha de fundación: Desarrollar un método que devuelva
una lista de equipos fundados antes de una fecha específica.*/
	
    public List<Equipo> jugadoresFechaNacimento(LocalDate fecha1){
    	List<Equipo>listAux=new ArrayList<Equipo>();
    	for(int g=0;g<LstEquipos.size();g++) {



    		if(LstEquipos.get(g).getFechaFundacion().isBefore(fecha1)) {

    			listAux.add(LstEquipos.get(g));
    		}
    	}
    	
    	
    	return listAux;
    	
    	
    }

    /*Cálculo de altura promedio de equipo: Escribir un método que calcule y retorne la
    altura promedio de un equipo.*/
    
    public float alturaPromedio(Equipo e) {
    	float prom=0;
    	int cont=0;	
    		
    		for(int h=0;h<e.getLstJugadores().size();h++) {
    			
    			if(e.getLstJugadores().get(h).getEstatura()>0) {
    				prom+=e.getLstJugadores().get(h).getEstatura();
    				
    			cont++;
    				
    			
    		}
    		
    	}
    	
    	prom=prom/(float)cont;
    	
    	return prom;
    }

    
   
    /*Identificación de equipo con mayor altura promedio: Crear un método que devuelva
 el objeto Equipo con la mayor altura promedio en el torneo.*/
     public Equipo alturaPromedioMayr(Torneo t) {
     	 List<Float>j=new ArrayList<Float>();
     	int cont=0;	
     		float prom=0;
     		float mayor=0;
     		Equipo e=null;
     		for(int h=0;h<t.getLstEquipos().size();h++) {
     			for(int i=0;i<t.getLstEquipos().get(h).getLstJugadores().size();i++) {
     			if(t.getLstEquipos().get(h).getLstJugadores().get(i).getEstatura()>0) {
     				prom+=t.getLstEquipos().get(h).getLstJugadores().get(i).getEstatura();
     				
     			cont++;
     				
     			}
     			prom=prom/(float)cont;
     			
     			
     		}
     			
     		
     			j.add(prom);
     			if(j.get(h)>mayor) {
     				mayor=j.get(h);
     				e=t.getLstEquipos().get(h);
     			}
     			
     		
     	}
     	
     
     	return e;
     }
    
	
}
