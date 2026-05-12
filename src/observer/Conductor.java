package observer;

import model.Viaje;

public class Conductor implements Observer {
    private final String nombre;

    public Conductor(String nombre) { this.nombre = nombre; }

    @Override
    public void update(String evento, Viaje viaje) {
        System.out.println("  → [Conductor] " + nombre + " notificado: " + evento);
    }

    public String getNombre() { return nombre; }
}
