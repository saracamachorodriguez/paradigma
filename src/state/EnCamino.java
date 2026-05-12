package state;

import model.Viaje;

public class EnCamino implements EstadoViaje {
    @Override
    public void finalizar(Viaje v) {
        System.out.println("[State] Transición: EnCamino -> Finalizado");
        v.setEstado(new Finalizado());
    }

    @Override
    public String getNombre() { return "EnCamino"; }
}
