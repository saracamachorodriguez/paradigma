package factory;

import model.*;

public class ViajeFactory {
    public static Viaje crearViaje(String tipo) {
        String t = tipo == null ? "economico" : tipo.toLowerCase();
        return switch (t) {
            case "premium" -> {
                System.out.println("[Factory] Creando viaje premium");
                yield new ViajePremium();
            }
            case "moto" -> {
                System.out.println("[Factory] Creando viaje moto");
                yield new ViajeMoto();
            }
            case "compartido" -> {
                System.out.println("[Factory] Creando viaje compartido");
                yield new ViajeCompartido();
            }
            default -> {
                System.out.println("[Factory] Creando viaje economico");
                yield new ViajeEconomico();
            }
        };
    }
}
