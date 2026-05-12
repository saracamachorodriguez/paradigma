package state;

import model.Viaje;

public class EnCamino implements EstadoViaje {
    @Override
    public void finalizar(Viaje v) {
        v.setEstado(new Finalizado());
        System.out.println("    ✓ Estado: En camino → Finalizado");
    }

    @Override
    public String getNombre() { return "EnCamino"; }
}
