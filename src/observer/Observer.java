package observer;

import model.Viaje;

public interface Observer {
    void update(String evento, Viaje viaje);
}
