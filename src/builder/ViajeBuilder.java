package builder;

import model.Viaje;

public class ViajeBuilder {
    private final Viaje viaje;

    public ViajeBuilder(Viaje viaje) {
        this.viaje = viaje;
    }

    public ViajeBuilder setWifi(boolean v) { viaje.setWifi(v); System.out.println("[Builder] Configurando wifi="+v); return this; }
    public ViajeBuilder setMascota(boolean v) { viaje.setMascota(v); System.out.println("[Builder] Configurando mascota="+v); return this; }
    public ViajeBuilder setAireAcondicionado(boolean v) { viaje.setAireAcondicionado(v); System.out.println("[Builder] Configurando aireAcondicionado="+v); return this; }
    public ViajeBuilder setEquipaje(boolean v) { viaje.setEquipaje(v); System.out.println("[Builder] Configurando equipaje="+v); return this; }
    public ViajeBuilder setMusica(boolean v) { viaje.setMusica(v); System.out.println("[Builder] Configurando musica="+v); return this; }
    public ViajeBuilder setNumeroPasajeros(int n) { viaje.setNumeroPasajeros(n); System.out.println("[Builder] Configurando numeroPasajeros="+n); return this; }

    public Viaje build() {
        System.out.println("[Builder] Construyendo viaje");
        return viaje;
    }
}
