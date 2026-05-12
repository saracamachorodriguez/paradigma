package mediator;

import java.util.ArrayList;
import java.util.List;

import model.Viaje;
import observer.Conductor;

public class CentralViajesMediator {
    private static CentralViajesMediator instance;
    private final List<Conductor> conductores = new ArrayList<>();

    private CentralViajesMediator() {}

    public static synchronized CentralViajesMediator getInstance() {
        if (instance == null) instance = new CentralViajesMediator();
        return instance;
    }

    public void registrarConductor(Conductor c) { conductores.add(c); }

    public void asignarConductor(Viaje viaje) {
        if (conductores.isEmpty()) {
            System.out.println("  ✗ [Mediator] No hay conductores disponibles");
            return;
        }
        Conductor elegido = conductores.get(0);
        viaje.agregarObservador(elegido);
        System.out.println("  ✓ [Mediator] Asignando conductor: " + elegido.getNombre());
        viaje.asignarConductor(elegido);
        viaje.notificar("Conductor asignado: " + elegido.getNombre());
    }
}
