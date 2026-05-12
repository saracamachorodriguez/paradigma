package main;

import app.RideApp;
import builder.ViajeBuilder;
import mediator.CentralViajesMediator;
import model.Viaje;
import observer.Conductor;
import observer.Pasajero;
import observer.UIObserver;

public class Main {
    public static void main(String[] args) {
        RideApp app = RideApp.getInstance();

        Pasajero p = new Pasajero("Ana");

        // 1-3: solicitar, RideApp recibe y Factory crea
        Viaje viaje = app.solicitarViaje(p, "premium");

        // 4: Builder configura opciones
        ViajeBuilder builder = new ViajeBuilder(viaje);
        builder.setWifi(true).setAireAcondicionado(true).setEquipaje(true).setNumeroPasajeros(2).build();

        // Observers
        viaje.agregarObservador(p);
        viaje.agregarObservador(new UIObserver());

        // Registrar conductor y asignar por mediator
        CentralViajesMediator mediator = app.getMediator();
        Conductor c = new Conductor("Carlos");
        mediator.registrarConductor(c);
        System.out.println("[Mediator] Intentando asignar conductor");
        mediator.asignarConductor(viaje);

        // 8-11: iniciar, en camino, finalizar
        System.out.println("[App] Iniciando viaje");
        viaje.iniciarViaje();
        viaje.notificar("Viaje iniciado");

        System.out.println("[App] En ruta (simulación)");

        System.out.println("[App] Finalizando viaje");
        viaje.finalizarViaje();
        viaje.notificar("Viaje finalizado");

        System.out.println("[App] Estado final esperado: Finalizado");
    }
}
