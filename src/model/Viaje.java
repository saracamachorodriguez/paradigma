package model;

import java.util.ArrayList;
import java.util.List;

import observer.Conductor;
import observer.Observable;
import observer.Observer;
import observer.Pasajero;
import state.EstadoViaje;

public abstract class Viaje implements Observable {
    protected String id;
    protected String tipo;
    protected boolean wifi;
    protected boolean mascota;
    protected boolean aireAcondicionado;
    protected boolean equipaje;
    protected boolean musica;
    protected int numeroPasajeros = 1;
    protected Conductor conductor;
    protected Pasajero pasajero;
    protected EstadoViaje estado;
    private final List<Observer> observers = new ArrayList<>();

    public Viaje(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() { return tipo; }
    public void setConductor(Conductor c) { this.conductor = c; }
    public Conductor getConductor() { return conductor; }
    public void setPasajero(Pasajero p) { this.pasajero = p; }

    // Option setters for builder (public)
    public void setWifi(boolean wifi) { this.wifi = wifi; }
    public void setMascota(boolean mascota) { this.mascota = mascota; }
    public void setAireAcondicionado(boolean aireAcondicionado) { this.aireAcondicionado = aireAcondicionado; }
    public void setEquipaje(boolean equipaje) { this.equipaje = equipaje; }
    public void setMusica(boolean musica) { this.musica = musica; }
    public void setNumeroPasajeros(int numeroPasajeros) { this.numeroPasajeros = numeroPasajeros; }

    // State delegation
    public void setEstado(EstadoViaje estado) {
        this.estado = estado;
        System.out.println("[State] Estado actual: " + estado.getNombre());
    }

    public EstadoViaje getEstado() { return estado; }
    // State actions - delegate to current state
    public void asignarConductor() { estado.asignar(this); }
    public void iniciarViaje() { estado.iniciar(this); }
    public void cancelarViaje() { estado.cancelar(this); }
    public void finalizarViaje() { estado.finalizar(this); }

    // Observable default implementation
    @Override
    public void agregarObservador(Observer o) { observers.add(o); }

    @Override
    public void eliminarObservador(Observer o) { observers.remove(o); }

    @Override
    public void notificar(String evento) { for (Observer o : observers) o.update(evento, this); }
}
