package modelo;

public class ParticipacionPartido {

    private Partido partido;
    private Equipo equipo;
    private int golesMetio;

    // Constructor vacío
    public ParticipacionPartido() {
    }

    // Constructor con parámetros
    public ParticipacionPartido(Partido partido, Equipo equipo, int golesMetio) {
        this.partido = partido;
        this.equipo = equipo;
        this.golesMetio = golesMetio;
    }

    // Getters y setters
    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getGolesMetio() {
        return golesMetio;
    }

    public void setGolesMetio(int golesMetio) {
        this.golesMetio = golesMetio;
    }

    @Override
    public String toString() {
        return "ParticipacionPartido [equipo=" + equipo.getNombre() + ", golesMetio=" + golesMetio + "]";
    }
}
