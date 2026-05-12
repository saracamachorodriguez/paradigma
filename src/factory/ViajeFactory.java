package factory;

import model.Viaje;
import model.ViajeCompartido;
import model.ViajeEconomico;
import model.ViajeMoto;
import model.ViajePremium;

public class ViajeFactory {
    public static Viaje crearViaje(String tipo) {
        String t = tipo == null ? "economico" : tipo.toLowerCase();
        Viaje viaje = switch (t) {
            case "premium" -> new ViajePremium();
            case "moto" -> new ViajeMoto();
            case "compartido" -> new ViajeCompartido();
            default -> new ViajeEconomico();
        };
        System.out.println("  ✓ [Factory] Viaje " + viaje.getTipo() + " creado");
        return viaje;
    }
}
