package observer;

public interface Observable {
    void agregarObservador(Observer o);
    void eliminarObservador(Observer o);
    void notificar(String evento);
}
