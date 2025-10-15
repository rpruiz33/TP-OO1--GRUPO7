package modelo;

public class Asistencia {
    private Jugador jugador;
    private int asistencias;

    public Asistencia(Jugador jugador, int asistencias) {
        this.jugador = jugador;
        this.asistencias = asistencias;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }
}
