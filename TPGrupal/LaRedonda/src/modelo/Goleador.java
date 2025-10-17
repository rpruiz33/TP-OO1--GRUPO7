package modelo;

public class Goleador {
    private Jugador jugador;
    private int goles;

    public Goleador(Jugador jugador, int goles) {
        this.jugador = jugador;
        this.goles = goles;
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
}
