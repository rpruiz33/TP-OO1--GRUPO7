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

    public int getGoles() {
        return goles;
    }

    public void sumarGoles(int g) {
        this.goles += g;
    }

    @Override
    public String toString() {
        return jugador.getNombre() + " " + jugador.getApellido() + " - " + goles + " goles";
    }
}
