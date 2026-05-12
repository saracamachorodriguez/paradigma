package state;

import model.Viaje;

public class Solicitado implements EstadoViaje {
    @Override
    public void asignar(Viaje v) {
        System.out.println("[State] Transición: Solicitado -> Asignado");
        v.setEstado(new Asignado());
    }

    @Override
    public void cancelar(Viaje v) {
        System.out.println("[State] Transición: Solicitado -> Cancelado");
        v.setEstado(new Cancelado());
    }

    @Override
    public String getNombre() { return "Solicitado"; }
}
