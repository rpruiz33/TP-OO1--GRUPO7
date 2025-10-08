package modelo;

import java.time.LocalDate;

public class Ganador {
    private LocalDate fecha;
    private Equipo equipoGanador;
    private int cantidadGoles;

    public Ganador(LocalDate fecha, Equipo equipoGanador, int cantidadGoles) {
        this.fecha = fecha;
        this.equipoGanador = equipoGanador;
        this.cantidadGoles = cantidadGoles;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Equipo getEquipoGanador() {
        return equipoGanador;
    }

    public int getCantidadGoles() {
        return cantidadGoles;
    }

    @Override
    public String toString() {
        return "Ganador [fecha=" + fecha + ", equipo=" + equipoGanador.getNombre() + ", goles=" + cantidadGoles + "]";
    }
}
