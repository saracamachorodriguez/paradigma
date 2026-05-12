package builder;

import model.Viaje;

public class ViajeBuilder {
    private final Viaje viaje;

    public ViajeBuilder(Viaje viaje) {
        this.viaje = viaje;
    }

    public ViajeBuilder setWifi(boolean v) { viaje.setWifi(v); return this; }
    public ViajeBuilder setMascota(boolean v) { viaje.setMascota(v); return this; }
    public ViajeBuilder setAireAcondicionado(boolean v) { viaje.setAireAcondicionado(v); return this; }
    public ViajeBuilder setEquipaje(boolean v) { viaje.setEquipaje(v); return this; }
    public ViajeBuilder setMusica(boolean v) { viaje.setMusica(v); return this; }
    public ViajeBuilder setNumeroPasajeros(int n) { viaje.setNumeroPasajeros(n); return this; }

    public Viaje build() {
        String config = (viaje.isWifi() ? "WiFi" : "") +
                       (viaje.isMascota() ? (viaje.isWifi() ? ", " : "") + "Mascota" : "") +
                       (viaje.isAireAcondicionado() ? (viaje.isWifi() || viaje.isMascota() ? ", " : "") + "A/C" : "") +
                       (viaje.isEquipaje() ? (viaje.isWifi() || viaje.isMascota() || viaje.isAireAcondicionado() ? ", " : "") + "Equipaje" : "") +
                       (viaje.isMusica() ? (viaje.isWifi() || viaje.isMascota() || viaje.isAireAcondicionado() || viaje.isEquipaje() ? ", " : "") + "Música" : "");
        System.out.println("  ✓ [Builder] Viaje configurado: [" + config + "], pasajeros: " + viaje.getNumeroPasajeros());
        return viaje;
    }
}
