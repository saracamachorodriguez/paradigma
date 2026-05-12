package observer;

import model.Viaje;

public class Pasajero implements Observer {
    private final String nombre;

    public Pasajero(String nombre) { this.nombre = nombre; }

    @Override
    public void update(String evento, Viaje viaje) {
        System.out.println("  → [Pasajero] " + nombre + " notificado: " + evento);
    }

    public String getNombre() { return nombre; }
}
