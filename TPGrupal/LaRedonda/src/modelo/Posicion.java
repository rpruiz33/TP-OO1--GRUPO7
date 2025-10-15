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

    public int getPuntos() {
        return puntos;
    }

    public void sumarPuntos(int p) {
        this.puntos += p;
    }

    @Override
    public String toString() {
        return equipo.getNombre() + " - Puntos: " + puntos;
    }
}
