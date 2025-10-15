package modelo;

import java.time.LocalDate;
import java.util.*;

public class Equipo {
    private int id;
    private String Nombre;
    private Entrenador Entrenador;
    private List<Jugador> lstJugadores;
    private String Codigo;
    private LocalDate fechaFundacion;
    private List<Integer> puntos;

    public Equipo(int id, String nombre, Entrenador entrenador, String codigo, LocalDate fechaFundacion) {
        super();
        this.id = id;
        this.Nombre = nombre;
        this.Entrenador = entrenador;
        this.lstJugadores = new ArrayList<>(); // inicializamos la lista de jugadores
        this.Codigo = codigo;
        this.fechaFundacion = fechaFundacion;
        this.puntos = new ArrayList<>(); // inicializamos la lista de puntos
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return Nombre; }
    public void setNombre(String nombre) { Nombre = nombre; }

    public Entrenador getEntrenador() { return Entrenador; }
    public void setEntrenador(Entrenador entrenador) { Entrenador = entrenador; }

    public List<Jugador> getLstJugadores() { return lstJugadores; }
    public void setLstJugadores(List<Jugador> lstJugadores) { this.lstJugadores = lstJugadores; }

    public String getCodigo() { return Codigo; }
    public void setCodigo(String codigo) { Codigo = codigo; }

    public LocalDate getFechaFundacion() { return fechaFundacion; }
    public void setFechaFundacion(LocalDate fechaFundacion) { this.fechaFundacion = fechaFundacion; }

    public List<Integer> getPuntos() { return puntos; }
    public void setPuntos(List<Integer> puntos) { this.puntos = puntos; }

    // Agregar jugador
    public boolean agregarJugador(String nombre, String apellido, int dni, LocalDate fechaNacimiento,
                                  float peso, float estatura, String posicion, int numCamiseta) {
        int id = 1;
        if (!lstJugadores.isEmpty()) {
            id = lstJugadores.get(lstJugadores.size() - 1).getId() + 1;
        }
        Jugador j = new Jugador(nombre, apellido, dni, fechaNacimiento, id, peso, estatura, posicion, numCamiseta,9);
        return lstJugadores.add(j);
    }

    // Traer jugador
    public Jugador traerJugador(int idJugador) {
        for (Jugador j : lstJugadores) {
            if (j.getId() == idJugador) return j;
        }
        return null;
    }

    // Eliminar jugador
    public boolean eliminarJugador(int idJugador) throws Exception {
        Jugador aux = traerJugador(idJugador);
        if (aux == null) throw new Exception("El jugador no existe");
        return lstJugadores.remove(aux);
    }

    // Agregar puntos
    public boolean agregarPuntos(int puntos) {
        return this.puntos.add(puntos);
    }

    // Calcular total de puntos
    public int totalPuntos() {
        int suma = 0;
        for (int p : puntos) {
            suma += p;
        }
        return suma;
    }

    @Override
    public String toString() {
        return "Equipo [id=" + id + ", Nombre=" + Nombre + ", Entrenador=" + Entrenador
                + ", lstJugadores=" + lstJugadores + ", Codigo=" + Codigo + ", fechaFundacion=" + fechaFundacion + "]";
    }
}
