package app;

import factory.ViajeFactory;
import mediator.CentralViajesMediator;
import model.Viaje;
import observer.Pasajero;
import state.Solicitado;

public class RideApp {
    private static RideApp instance;
    private final CentralViajesMediator mediator;

    private RideApp() {
        mediator = CentralViajesMediator.getInstance();
    }

    public static synchronized RideApp getInstance() {
        if (instance == null) instance = new RideApp();
        return instance;
    }

    public Viaje solicitarViaje(Pasajero pasajero, String tipo) {
        System.out.println("✓ [RideApp] Solicitud de viaje recibida");
        Viaje viaje = ViajeFactory.crearViaje(tipo);
        viaje.setPasajero(pasajero);
        viaje.setEstado(new Solicitado());
        System.out.println("  ✓ Estado: Solicitado");
        viaje.notificar("Viaje solicitado por " + pasajero.getNombre());
        return viaje;
    }

    public CentralViajesMediator getMediator() {
        return mediator;
    }
}
