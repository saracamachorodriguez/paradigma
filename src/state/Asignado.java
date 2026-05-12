package state;

import model.Viaje;

public class Asignado implements EstadoViaje {
    @Override
    public void iniciar(Viaje v) {
        v.setEstado(new EnCamino());
        System.out.println("    ✓ Estado: Asignado → En camino");
    }

    @Override
    public void cancelar(Viaje v) {
        System.out.println("[State] Transición: Asignado -> Cancelado");
        v.setEstado(new Cancelado());
    }

    @Override
    public String getNombre() { return "Asignado"; }
}
