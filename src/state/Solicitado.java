package state;

import model.Viaje;
import observer.Conductor;

public class Solicitado implements EstadoViaje {
    @Override
    public void asignar(Viaje v, Conductor conductor) {
        v.setConductor(conductor);
        v.setEstado(new Asignado());
        System.out.println("    ✓ Estado: Solicitado → Asignado");
    }

    @Override
    public void cancelar(Viaje v) {
        System.out.println("[State] Transición: Solicitado -> Cancelado");
        v.setEstado(new Cancelado());
    }

    @Override
    public String getNombre() { return "Solicitado"; }
}
