package state;

import model.Viaje;

public class Asignado implements EstadoViaje {
    @Override
    public void iniciar(Viaje v) {
        System.out.println("[State] Transición: Asignado -> EnCamino");
        v.setEstado(new EnCamino());
    }

    @Override
    public void cancelar(Viaje v) {
        System.out.println("[State] Transición: Asignado -> Cancelado");
        v.setEstado(new Cancelado());
    }

    @Override
    public String getNombre() { return "Asignado"; }
}
