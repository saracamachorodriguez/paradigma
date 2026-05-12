package state;

import model.Viaje;

public interface EstadoViaje {
    default void asignar(Viaje v) { throw new UnsupportedOperationException("Accion no permitida"); }
    default void iniciar(Viaje v) { throw new UnsupportedOperationException("Accion no permitida"); }
    default void cancelar(Viaje v) { throw new UnsupportedOperationException("Accion no permitida"); }
    default void finalizar(Viaje v) { throw new UnsupportedOperationException("Accion no permitida"); }
    String getNombre();
}
