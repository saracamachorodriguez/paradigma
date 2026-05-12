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
        printBanner();

        RideApp app = RideApp.getInstance();
        CentralViajesMediator mediator = app.getMediator();
        System.out.println("\n" + "=".repeat(60));
        System.out.println("FASE 1: SOLICITUD Y CONFIGURACIÓN DE VIAJE");
        System.out.println("=".repeat(60) + "\n");

        Pasajero ana = new Pasajero("Ana González");
        System.out.println("[1] Pasajero solicita viaje...");
        Viaje viaje = app.solicitarViaje(ana, "premium");

        System.out.println("\n[2] Configurando opciones del viaje...");
        new ViajeBuilder(viaje)
            .setWifi(true)
            .setAireAcondicionado(true)
            .setEquipaje(true)
            .setNumeroPasajeros(2)
            .build();

        System.out.println("\n[3] Registrando observadores...");
        viaje.agregarObservador(ana);
        viaje.agregarObservador(new UIObserver());
        System.out.println("  ✓ Observadores: Pasajero, UI");

        System.out.println("\n" + "=".repeat(60));
        System.out.println("FASE 2: ASIGNACIÓN DE CONDUCTOR");
        System.out.println("=".repeat(60) + "\n");

        Conductor carlos = new Conductor("Carlos Mendoza");
        System.out.println("[4] Registrando conductor en sistema...");
        mediator.registrarConductor(carlos);

        System.out.println("\n[5] Asignando conductor al viaje...");
        mediator.asignarConductor(viaje);

        System.out.println("\n" + "=".repeat(60));
        System.out.println("FASE 3: CICLO DE VIDA DEL VIAJE");
        System.out.println("=".repeat(60) + "\n");

        System.out.println("[6] Iniciando viaje...");
        viaje.iniciarViaje();
        viaje.notificar("Viaje iniciado");

        System.out.println("\n[7] En ruta...");
        sleep(300);
        System.out.println("  ⚊ Viaje en camino...");

        System.out.println("\n[8] Finalizando viaje...");
        sleep(300);
        viaje.finalizarViaje();
        viaje.notificar("Viaje finalizado");

        System.out.println("\n" + "=".repeat(60));
        System.out.println("RESUMEN FINAL");
        System.out.println("=".repeat(60));
        System.out.println("\nEstado final: " + viaje.getEstado().getNombre());
        System.out.println("Pasajero: " + ana.getNombre());
        System.out.println("Conductor: " + carlos.getNombre());
        System.out.println("Servicio: " + viaje.getTipo());
        System.out.println("\n✓ Simulación completada exitosamente\n");
    }

    private static void printBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("      SISTEMA RIDEAPP - LABORATORIO DE PATRONES");
        System.out.println("=".repeat(60));
        System.out.println("Patrones: Singleton, Factory, Builder, Observer,");
        System.out.println("          Mediator, State");
        System.out.println("=".repeat(60) + "\n");
    }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}
