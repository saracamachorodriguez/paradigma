package observer;

import model.Viaje;

public class UIObserver implements Observer {
    @Override
    public void update(String evento, Viaje viaje) {
        System.out.println("[UI] Evento: " + evento + " -> mostrar en interfaz (" + viaje.getTipo() + ")");
    }
}
