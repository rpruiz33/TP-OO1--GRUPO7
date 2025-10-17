package modelo;

public class Posicion {
    private Equipo equipo;
    private int puntos;

    public Posicion(Equipo equipo, int puntos) {
        this.equipo = equipo;
        this.puntos = puntos;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
