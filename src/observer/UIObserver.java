package observer;

import model.Viaje;

public class UIObserver implements Observer {
    @Override
    public void update(String evento, Viaje viaje) {
        System.out.println("  → [UI] Actualizando pantalla: " + evento);
    }
}
